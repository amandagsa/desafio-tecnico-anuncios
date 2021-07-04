package com.capgemini.anuncios.service;

import com.capgemini.anuncios.entity.Anuncio;
import com.capgemini.anuncios.error.ResourcesNotFoundException;
import com.capgemini.anuncios.repository.AnuncioRepository;
import com.capgemini.anuncios.service.utils.Relatorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

// Implementa regras para endpoints.

@Service
public class AnuncioService {
    @Autowired
    AnuncioRepository anuncioRepository;

    public Object cadastraAnuncio(Anuncio anuncio) {
        return anuncioRepository.save(anuncio);
    }

    public ResponseEntity<String> deletaAnuncio(Long id) {
        verificaAnuncioExiste(id);
        anuncioRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Anuncio deletado!");
    }

    public Object buscaRelatorioUmAnuncio(Long id) {
       Optional<Anuncio> anuncio = anuncioRepository.findById(id);
        if (anuncio.isPresent()) {
            Anuncio anuncioCacl = anuncio.get();
            return new Relatorio(anuncioCacl);
        }
        throw new ResourcesNotFoundException("Anuncio não encontrado para o ID: " +id);
    }

    public List<Anuncio> listaTodos() {
        return anuncioRepository.findAll();
    }

    public Object buscaRelatorioAnuncioPorCliente(Long id) {
        List<Anuncio> listaAnuncio = anuncioRepository.findAllByidCliente(id);
        List<Relatorio> listaRelatorioPorCliente = new ArrayList<>();
        for (Anuncio anuncio : listaAnuncio) {
            Relatorio relatorio = new Relatorio(anuncio);
            listaRelatorioPorCliente.add(relatorio);
        }
        return listaRelatorioPorCliente;
    }

    public Object buscaRelatorioAnuncioPorPeriododeTempo(Date inicioIntervalo, Date fimIntervalo) {
        List <Anuncio> listaAnuncio = anuncioRepository.findAllByDataInicioGreaterThanEqualAndDataTerminoLessThanEqual(inicioIntervalo, fimIntervalo);
        List<Relatorio> listaRelatorioPorData = new ArrayList<>();
        for (Anuncio anuncio : listaAnuncio) {
            Relatorio relatorio = new Relatorio(anuncio);
            listaRelatorioPorData.add(relatorio);
        }
        return listaRelatorioPorData;
    }

    public Object buscaRelatorioAnuncioPorPeriododeTempoECliente(Date inicioIntervalo, Date fimIntervalo, long id) {
        List <Anuncio> listaAnuncio = anuncioRepository.findAllByDataInicioGreaterThanEqualAndDataTerminoLessThanEqualAndIdClienteEquals(inicioIntervalo, fimIntervalo, id);
        List<Relatorio> listaRelatorioPorDataECliente = new ArrayList<>();
        for (Anuncio anuncio : listaAnuncio) {
            Relatorio relatorio = new Relatorio(anuncio);
            listaRelatorioPorDataECliente.add(relatorio);
        }
        return listaRelatorioPorDataECliente;
    }

    public void verificaAnuncioExiste(Long id){
        if (anuncioRepository.findById(id).isEmpty())
            throw new ResourcesNotFoundException("Anuncio not found for ID: " +id);
    }
}
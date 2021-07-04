package com.capgemini.anuncios.repository;

import com.capgemini.anuncios.entity.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

//Implementa um repositório de Anmúncios que extende da JpaRepository para utilizar suas funções.

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

    List<Anuncio> findAllByidCliente(Long id);

    List <Anuncio> findAllByDataInicioGreaterThanEqualAndDataTerminoLessThanEqual (Date inicioIntervalo, Date fimIntervalo);

    List <Anuncio> findAllByDataInicioGreaterThanEqualAndDataTerminoLessThanEqualAndIdClienteEquals (Date inicioIntervalo, Date fimIntervalo, Long id);
}



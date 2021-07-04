package com.capgemini.anuncios.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.anuncios.entity.Anuncio;
import com.capgemini.anuncios.service.AnuncioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

//Implementa endpoints da API onde será possível enviar requisições.

@RestController
@RequestMapping(value = "anuncio")
@CrossOrigin(origins = "*")
public class AnuncioController {
    @Autowired
    AnuncioService anuncioService;

    @GetMapping
    @ApiOperation(value = "Lista todos os anúncios cadastrados no sistema.")
    public List<Anuncio> listaTodosAnuncios() {
        return anuncioService.listaTodos();
    }

    @PostMapping()
    @ApiOperation(value = "Cadastra um anúncio no sistema.")
    public Object cadastraAnuncio(@RequestBody Anuncio anuncio) {
        return anuncioService.cadastraAnuncio(anuncio);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta um anúncio do sistema.")
    public Object deletaAnuncio(@PathVariable(value = "id") Long id) {
        return anuncioService.deletaAnuncio(id);
    }

    @GetMapping("relatorio/{idAnuncio}")
    @ApiOperation(value = "Exibe o relatório de um anúncio através do ID do anúncio.")
    public Object buscaRelatorioUmAnuncio(@PathVariable(value = "idAnuncio") Long id) {
        return anuncioService.buscaRelatorioUmAnuncio(id);
    }

    @GetMapping("relatorio/cliente/{idCliente}")
    @ApiOperation(value = "Exibe o relatório dos anúncios de um cliente através do ID do cliente.")
    public Object buscaRelatorioAnuncioPorCliente(@PathVariable(value = "idCliente") Long id) {
        return anuncioService.buscaRelatorioAnuncioPorCliente(id);
    }

    @GetMapping(value = "relatorio/{inicioIntervalo}/{fimIntervalo}/{idCliente}")
    @ApiOperation(value = "Exibe o relatório dos anúncios ativos de um cliente em um intervalo de temp(yyyy-mm-dd).")
    public Object buscaRelatorioAnuncioPorPeriododeTempo(@PathVariable(value = "inicioIntervalo") @DateTimeFormat(pattern = "yyyy-MM-dd") Date inicioIntervalo, @PathVariable(value = "fimIntervalo") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fimIntervalo, @PathVariable(value = "idCliente") Long idCliente) {
            return anuncioService.buscaRelatorioAnuncioPorPeriododeTempoECliente(inicioIntervalo, fimIntervalo, idCliente);
         }

    @GetMapping(value = "relatorio/{inicioIntervalo}/{fimIntervalo}")
    @ApiOperation(value = "Exibe o relatório dos anúncios ativos em um intervalo de tempo (yyyy-mm-dd).")
    public Object buscaRelatorioAnuncioPorPeriododeTempo(@PathVariable(value = "inicioIntervalo") @DateTimeFormat(pattern = "yyyy-MM-dd") Date inicioIntervalo, @PathVariable(value = "fimIntervalo") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fimIntervalo) {
        return anuncioService.buscaRelatorioAnuncioPorPeriododeTempo(inicioIntervalo, fimIntervalo);
    }
}


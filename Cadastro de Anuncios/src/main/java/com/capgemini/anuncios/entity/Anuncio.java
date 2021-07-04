package com.capgemini.anuncios.entity;

import javax.persistence.*;
import java.util.Date;

//Implementa a entidade ANUNCIOS e seus atributos conforme proposto no desafio.

@Entity
@Table(name = "anuncio")
public class Anuncio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAnuncio;

    private String nome;
    private Date dataInicio;
    private Date dataTermino;
    private double valorInvestimentoDia;
    private Long idCliente;

    public Anuncio(){}

    public Anuncio(Long idAnuncio, String nome, Date dataInicio, Date dataTermino, double valorInvestimentoDia, Long idCliente) {
        this.idAnuncio = idAnuncio;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.valorInvestimentoDia = valorInvestimentoDia;
        this.idCliente = idCliente;
    }

    public Long getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(Long idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public double getValorInvestimentoDia() {
        return valorInvestimentoDia;
    }

    public void setValorInvestimentoDia(double valorInvestimentoDia) {
        this.valorInvestimentoDia = valorInvestimentoDia;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }
}
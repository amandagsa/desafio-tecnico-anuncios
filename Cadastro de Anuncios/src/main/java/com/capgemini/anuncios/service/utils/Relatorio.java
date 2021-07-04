package com.capgemini.anuncios.service.utils;

import com.capgemini.anuncios.entity.Anuncio;
import java.util.Date;
import java.util.concurrent.TimeUnit;

//Implementa relatórios e suas regras de negócio para cálculo de projeção de alcance dos anúncio.

public class Relatorio {
    double valorTotal;
    double viewsTotal;
    double cliquesTotal;
    double compartilhamentosTotal;

    private Anuncio anuncio;

    public Relatorio(Anuncio anuncio) {
        this.setAnuncio(anuncio);
        this.valorTotal = getValorTotal();
        this.viewsTotal = getViewsTotal();
        this.cliquesTotal = getCliquesTotal();
        this.compartilhamentosTotal = getCompartilhamentosTotal();
    }

    protected Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }

    public double getValorTotal() {
        long dias = getDiasDuracao();
        double valorDia = this.anuncio.getValorInvestimentoDia();
        valorTotal = valorDia * dias;
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getViewsTotal() {
        double valorTotal = getValorTotal();
        double views = (valorTotal * 30);
        viewsTotal = views;

        for (int sequencia = 0; sequencia < 4; sequencia++) {
            double clicks = (views * 0.12);
            double share = (clicks * 0.15);
            views = share * 40;
            viewsTotal += views;
        }
        return (int) viewsTotal;
    }

    public void setViewsTotal(double viewsTotal) {
        this.viewsTotal = viewsTotal;
    }

    public double getCliquesTotal() {
        viewsTotal = (int) getViewsTotal();
        cliquesTotal = (viewsTotal * 0.12);
        return (int) cliquesTotal;
    }

    public void setCliquesTotal(double cliquesTotal) {
        this.cliquesTotal = cliquesTotal;
    }

    public double getCompartilhamentosTotal() {
        double clicksTotal = getCliquesTotal();
        compartilhamentosTotal = clicksTotal * 0.15;
        return (int) compartilhamentosTotal;
    }

    public void setCompartilhamentosTotal(double compartilhamentosTotal) {
        this.compartilhamentosTotal = compartilhamentosTotal;
    }

    private long getDiasDuracao() {
        Date diaFim = this.anuncio.getDataTermino();
        Date diaIni = this.anuncio.getDataInicio();

        long diferenca = diaFim.getTime() - diaIni.getTime();
        return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
    }
}

package com.senac.prova_rec_backend.vo;

public class TotalContasPagar {

    private String despesa;
    private Double total;

    public TotalContasPagar(String despesa, Double total) {
        this.despesa = despesa;
        this.total = total;
    }

    public String getDespesa() {
        return despesa;
    }

    public void setDespesa(String despesa) {
        this.despesa = despesa;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}

package br.unitins.topicos1.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;

@Entity
public class Boleto extends DefaultEntity {

    private Double valor;
    private String numeroBoleto;
    private LocalDateTime dataEmissao;
    private LocalDateTime dataVencimento;

    public String getNumeroBoleto() {
        return numeroBoleto;
    }

    public void setNumeroBoleto(String numeroBoleto) {
        this.numeroBoleto = numeroBoleto;
    }

    public LocalDateTime getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDateTime localDateTime) {
        this.dataVencimento = localDateTime;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDateTime dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    
}

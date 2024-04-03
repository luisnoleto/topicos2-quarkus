package br.unitins.topicos1.model;

import jakarta.persistence.Entity;

@Entity
public class Requisito extends DefaultEntity{
   
    private String processador;
    private String memoria;
    private String placaVideo;
    private String sistemaOperacional;
    private String armazenamento;
    private Desempenho desempenho;


    public String getProcessador() {
        return processador;
    }
    public void setProcessador(String processador) {
        this.processador = processador;
    }
    public String getMemoria() {
        return memoria;
    }
    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }
    public String getPlacaVideo() {
        return placaVideo;
    }
    public void setPlacaVideo(String placaVideo) {
        this.placaVideo = placaVideo;
    }
    public String getSistemaOperacional() {
        return sistemaOperacional;
    }
    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }
    public String getArmazenamento() {
        return armazenamento;
    }
    public void setArmazenamento(String armazenamento) {
        this.armazenamento = armazenamento;
    }

    public Desempenho getDesempenho() {
        return desempenho;
    }

    public void setDesempenho(Desempenho desempenho) {
        this.desempenho = desempenho;
    }
    
}

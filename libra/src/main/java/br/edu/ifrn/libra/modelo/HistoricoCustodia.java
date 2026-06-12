package br.edu.ifrn.libra.modelo;

import java.time.LocalDateTime;

public class HistoricoCustodia {

    private int idMovimentacao;
    private int idUsuario;
    private int idExemplar;
    private String tipoMovimentacao;
    private LocalDateTime dataHora;

    // Construtor
    public HistoricoCustodia(int idMovimentacao,
                             int idUsuario,
                             int idExemplar,
                             String tipoMovimentacao) {

        this.idMovimentacao = idMovimentacao;
        this.idUsuario = idUsuario;
        this.idExemplar = idExemplar;
        this.tipoMovimentacao = tipoMovimentacao;

        // Timestamp automático
        this.dataHora = LocalDateTime.now();
    }

    // GETTERS

    public int getIdMovimentacao() {
        return idMovimentacao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public int getIdExemplar() {
        return idExemplar;
    }

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
}

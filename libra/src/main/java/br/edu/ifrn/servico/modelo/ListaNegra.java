package br.edu.ifrn.servico.modelo;

public class ListaNegra {

    private String cpfUsuario;
    private boolean possuiMulta;
    private boolean possuiAtraso;
    private boolean bloqueado;

    // GETTERS E SETTERS

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public boolean isPossuiMulta() {
        return possuiMulta;
    }

    public void setPossuiMulta(boolean possuiMulta) {
        this.possuiMulta = possuiMulta;
    }

    public boolean isPossuiAtraso() {
        return possuiAtraso;
    }

    public void setPossuiAtraso(boolean possuiAtraso) {
        this.possuiAtraso = possuiAtraso;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }
}
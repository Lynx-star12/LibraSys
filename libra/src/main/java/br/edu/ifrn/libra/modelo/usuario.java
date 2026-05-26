package br.edu.ifrn.libra.modelo;

public class usuario {

    private String nomeCompleto;
    private String cpf;
    private String email;
    private String telefone;
    private String statusCadastro;

    // Método para verificar se usuário está ativo
    public boolean isAtivo() {

        return statusCadastro.equalsIgnoreCase("ATIVO");
    }

    // GETTERS E SETTERS

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getStatusCadastro() {
        return statusCadastro;
    }

    public void setStatusCadastro(String statusCadastro) {
        this.statusCadastro = statusCadastro;
    }
}

package br.edu.ifrn.servico.modelo;

public class usuario {

    private String nomeCompleto;
    private String cpf;
    private String email;
    private String telefone;
    private String statusCadastro;
    private int limiteEmprestimos;
private int emprestimosAtivos;

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

public boolean atingiuLimite() {

    return emprestimosAtivos >= limiteEmprestimos;
}

public void adicionarEmprestimo() {

    emprestimosAtivos++;
}

public void devolverLivro() {

    emprestimosAtivos--;
}
// adicionando GETTERS E SETTERS
public int getLimiteEmprestimos() {
    return limiteEmprestimos;
}

public void setLimiteEmprestimos(
        int limiteEmprestimos) {

    this.limiteEmprestimos =
            limiteEmprestimos;
}

public int getEmprestimosAtivos() {
    return emprestimosAtivos;
}

public void setEmprestimosAtivos(
        int emprestimosAtivos) {

    this.emprestimosAtivos =
            emprestimosAtivos;
}
}

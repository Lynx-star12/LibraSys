package br.edu.ifrn.libra.modelo;

public class usuario {

    private Long id;
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
public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}
@Override
    public String toString() {
        return "usuario{id=" + id + ", nomeCompleto='" + nomeCompleto + "', cpf='" + cpf +
               "', email='" + email + "', telefone='" + telefone + "', statusCadastro='" + statusCadastro +
               "', limiteEmprestimos=" + limiteEmprestimos + ", emprestimosAtivos=" + emprestimosAtivos + "}";
    }
}

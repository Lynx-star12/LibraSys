package br.edu.ifrn.libra.modelo;

 

public class Secao {

    private Long id;
    private String nomeGenero;
    private String codigo;
    private String localizacao;
    private int capacidadeMaxima;
    private int livrosOcupados;

    // Método para calcular vagas disponíveis
    public int getEspacosDisponiveis() {
        return capacidadeMaxima - livrosOcupados;
    }

    // Método para verificar se está lotada
    public boolean isLotada() {
        return livrosOcupados >= capacidadeMaxima;
    }

    // GETTERS E SETTERS

    public String getNomeGenero() {
        return nomeGenero;
    }

    public void setNomeGenero(String nomeGenero) {
        this.nomeGenero = nomeGenero;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public int getLivrosOcupados() {
        return livrosOcupados;
    }

    public void setLivrosOcupados(int livrosOcupados) {
        this.livrosOcupados = livrosOcupados;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Secao{id=" + id + ", nomeGenero='" + nomeGenero + "', codigo='" + codigo +
               "', localizacao='" + localizacao + "', capacidadeMaxima=" + capacidadeMaxima +
               ", livrosOcupados=" + livrosOcupados + ", espacosDisponiveis=" + getEspacosDisponiveis() + "}";
    }
}


    
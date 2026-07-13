package br.edu.ifrn;

import br.edu.ifrn.libra.modelo.Secao;
import br.edu.ifrn.libra.servico.servico;

public class Main {
    public static void main(String[] args) {
        servico secaoServico = new servico();

        System.out.println("\n--- [C] - INSERINDO Seções no MySQL (Pré-criado via Workbench) ---");
        Secao secao1 = new Secao();
        secao1.setNomeGenero("Maternidade"); // pode trocar pro seu domínio real, ex: "Ficção Científica"
        secao1.setCodigo("SEC-01");
        secao1.setLocalizacao("Corredor A");
        secao1.setCapacidadeMaxima(5);
        secao1.setLivrosOcupados(0);

        Secao secao2 = new Secao();
        secao2.setNomeGenero("Isolamento Clínico");
        secao2.setCodigo("SEC-02");
        secao2.setLocalizacao("Corredor B");
        secao2.setCapacidadeMaxima(3);
        secao2.setLivrosOcupados(0);

        secaoServico.cadastrarSecao(secao1);
        secaoServico.cadastrarSecao(secao2);

        System.out.println("\n--- [R] - SELECIONANDO e exibindo os registros ---");
        secaoServico.listarSecoes().forEach(System.out::println);

        System.out.println("\n--- [U] - ATUALIZANDO e Modificando Dados ---");
        secao2.setLivrosOcupados(3); // Alterando estado do objeto para lotado
        secaoServico.alterarDadosSecao(secao2);
        secaoServico.listarSecoes().forEach(System.out::println);

        System.out.println("\n--- [D] - EXCLUINDO um registro do MySQL ---");
        secaoServico.removerSecao(secao1.getId());

        System.out.println("\nEstado final da tabela no MySQL:");
        secaoServico.listarSecoes().forEach(System.out::println);
    }
}
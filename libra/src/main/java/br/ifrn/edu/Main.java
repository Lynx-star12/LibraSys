package br.ifrn.edu;
// req 001
import br.edu.ifrn.libra.modelo.Secao;
import br.edu.ifrn.libra.servico;

public class Main {

    public static void main(String[] args) {

        // Instanciar serviço
        servico servico = new servico();

        // Criar seção
        Secao secao = new Secao();

        secao.setNomeGenero("Ficção Científica");
        secao.setCodigo("FC001");
        secao.setLocalizacao("Corredor A");
        secao.setCapacidadeMaxima(100);
        secao.setLivrosOcupados(80);

        // Testar cadastro
        System.out.println("=== TESTE DE CADASTRO ===");

        try {

            servico.cadastrarSecao(secao);

        } catch (IllegalArgumentException e) {

            System.out.println(
                "Erro: " + e.getMessage()
            );
        }

        // Mostrar dados
        System.out.println("\n=== STATUS DA SEÇÃO ===");

        System.out.println(
            "Gênero: " + secao.getNomeGenero()
        );

        System.out.println(
            "Código: " + secao.getCodigo()
        );

        System.out.println(
            "Localização: " + secao.getLocalizacao()
        );

        System.out.println(
            "Capacidade Máxima: "
            + secao.getCapacidadeMaxima()
        );

        System.out.println(
            "Espaços Disponíveis: "
            + secao.getEspacosDisponiveis()
        );

        if (secao.isLotada()) {

            System.out.println(
                "A seção está LOTADA."
            );

        } else {

            System.out.println(
                "Ainda há espaço disponível."
            );
        }
    }
}
// req. 002
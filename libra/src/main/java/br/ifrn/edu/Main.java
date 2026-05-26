package br.ifrn.edu;
// req 001
import br.edu.ifrn.libra.modelo.Secao;
import br.edu.ifrn.libra.servico;
import br.edu.ifrn.libra.modelo.usuario;
import br.edu.ifrn.libra.usuarioServico;

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

// req. 002
public class main {

    public static void ain(String[] args) {

        // Instanciar serviço
        usuarioServico servico = new usuarioServico();

        // Criar usuário
        usuario usuario = new usuario();

        usuario.setNomeCompleto("Maria Silva");
        usuario.setCpf("12345678900");
        usuario.setEmail("maria@email.com");
        usuario.setTelefone("(84)99999-9999");
        usuario.setStatusCadastro("ATIVO");

        // Testar cadastro
        System.out.println("=== TESTE DE CADASTRO ===");

        try {

            servico.cadastrarUsuario(usuario);

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Erro: " + e.getMessage()
            );
        }

        // Mostrar dados
        System.out.println("\n=== DADOS DO USUÁRIO ===");

        System.out.println(
                "Nome: " + usuario.getNomeCompleto()
        );

        System.out.println(
                "CPF: " + usuario.getCpf()
        );

        System.out.println(
                "Email: " + usuario.getEmail()
        );

        System.out.println(
                "Telefone: " + usuario.getTelefone()
        );

        System.out.println(
                "Status: " + usuario.getStatusCadastro()
        );

        // Verificar status
        if (usuario.isAtivo()) {

            System.out.println(
                    "Usuário liberado para empréstimos."
            );

        } else {

            System.out.println(
                    "Usuário bloqueado para empréstimos."
            );
        }
    }
}
}
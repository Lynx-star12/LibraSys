package br.edu.ifrn;
// testando =)
import br.edu.ifrn.libra.modelo.Secao;
import br.edu.ifrn.libra.servico;
import br.edu.ifrn.libra.modelo.usuario;
import br.edu.ifrn.libra.usuarioServico;
import br.edu.ifrn.libra.modelo.ListaNegra;
import br.edu.ifrn.libra.ListaNegraServico;
import br.edu.ifrn.libra.modelo.HistoricoCustodia;
import br.edu.ifrn.libra.HistoricoCustodiaServico;
import br.edu.ifrn.libra.EmprestimoServico;

public class Main {
    public static void main(String[] args) {

       
        // teste req.001 — cadrastro das seções 
        

        System.out.println(
                " Teste seção =) "
        );

        servico secaoServico =
                new servico();

        Secao secao =
                new Secao();

        secao.setNomeGenero(
                "Ficção Científica"
        );

        secao.setCodigo("AH005");

        secao.setLocalizacao(
                "Corredor A"
        );

        secao.setCapacidadeMaxima(100);

        secao.setLivrosOcupados(70);

        try {

            secaoServico.cadastrarSecao(
                    secao
            );

        } catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }

        System.out.println(
                "Espaços disponíveis: "
                + secao.getEspacosDisponiveis()
        );

        
        // Teste REQ.002 — Cadrastro de Usuários
        

        System.out.println(
                " Teste usuario =)"
        );

        usuarioServico usuarioServico =
                new usuarioServico();

        usuario usuario =
                new usuario();

        usuario.setNomeCompleto(
                "Luiz Otavio"
        );

        usuario.setCpf(
                "12345678900"
        );

        usuario.setEmail(
                "Otavio@email.com"
        );

        usuario.setTelefone(
                "(84)99999-9999"
        );

        usuario.setStatusCadastro(
                "ATIVO"
        );

        // REQ.005
        usuario.setLimiteEmprestimos(3);

        usuario.setEmprestimosAtivos(2);

        try {

            usuarioServico.cadastrarUsuario(
                    usuario
            );

        } catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }

        System.out.println(
                "Usuário: "
                + usuario.getNomeCompleto()
        );

        // =====================================================
        // TESTE REQ.004 — LISTA NEGRA
        // =====================================================

        System.out.println(
                "\n===== TESTE LISTA NEGRA ====="
        );

        ListaNegra listaNegra =
                new ListaNegra();

        listaNegra.setCpfUsuario(
                usuario.getCpf()
        );

        listaNegra.setPossuiMulta(true);

        listaNegra.setPossuiAtraso(false);

        ListaNegraServico listaServico =
                new ListaNegraServico();

        listaServico.verificarPendencias(
                listaNegra
        );

        System.out.println(
                "Bloqueado: "
                + listaNegra.isBloqueado()
        );

        // =====================================================
        // TESTE REQ.005 — LIMITE DE EMPRÉSTIMOS
        // =====================================================

        System.out.println(
                "\n===== TESTE EMPRÉSTIMO ====="
        );

        EmprestimoServico emprestimoServico =
                new EmprestimoServico();

        try {

            emprestimoServico
                    .realizarEmprestimo(
                            usuario
                    );

        } catch (Exception e) {

            System.out.println(
                    e.getMessage()
            );
        }

        System.out.println(
                "Empréstimos ativos: "
                + usuario.getEmprestimosAtivos()
        );

        // DEVOLUÇÃO

        emprestimoServico
                .registrarDevolucao(
                        usuario
                );

        System.out.println(
                "Após devolução: "
                + usuario.getEmprestimosAtivos()
        );

        // =====================================================
        // TESTE REQ.003 — HISTÓRICO DE CUSTÓDIA
        // =====================================================

        System.out.println(
                "\n===== TESTE HISTÓRICO ====="
        );

        HistoricoCustodia movimentacao =
                new HistoricoCustodia(
                        1,
                        100,
                        500,
                        "EMPRESTIMO"
                );

        HistoricoCustodiaServico historicoServico =
                new HistoricoCustodiaServico();

        historicoServico
                .registrarMovimentacao(
                        movimentacao
                );

        historicoServico
                .listarHistorico();
    }
}
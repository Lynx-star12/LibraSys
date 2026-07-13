package br.edu.ifrn.libra.servico;

import java.util.List;

import br.edu.ifrn.libra.modelo.Secao;
import br.edu.ifrn.libra.repositorio.SecaoRepositorio;

public class servico {

    private final SecaoRepositorio repositorio = new SecaoRepositorio();

    public void cadastrarSecao(Secao novaSecao) {

        // Validar capacidade
        if (novaSecao.getCapacidadeMaxima() <= 0) {

            throw new IllegalArgumentException(
                "A capacidade deve ser maior que zero."
            );
        }

        // Verificar duplicidade (agora consultando o MySQL em vez da List em memória)
        if (repositorio.buscarPorNomeGenero(novaSecao.getNomeGenero()) != null) {

            throw new IllegalArgumentException(
                "Já existe uma seção com esse gênero."
            );
        }

        if (repositorio.buscarPorCodigo(novaSecao.getCodigo()) != null) {

            throw new IllegalArgumentException(
                "Já existe uma seção com esse código."
            );
        }

        // Salvar seção no MySQL
        repositorio.inserir(novaSecao);

        System.out.println(
            "Seção cadastrada com sucesso!"
        );
    }

    public List<Secao> listarSecoes() {
        return repositorio.selecionarTodas();
    }

    // [U] - ATUALIZAR (equivalente ao alterarDadosAla do professor)
    public void alterarDadosSecao(Secao secao) {
        if (secao.getId() == null) {
            throw new IllegalArgumentException(
                "Erro de Regra: Não é possível atualizar uma seção sem ID."
            );
        }
        if (secao.isLotada()) {
            System.out.println(
                "LOG ALERTA: A seção '" + secao.getNomeGenero() + "' atingiu a lotação máxima!"
            );
        }
        repositorio.atualizar(secao);
    }

    // [D] - EXCLUIR (equivalente ao removerAlaDoHospital do professor)
    public void removerSecao(Long id) {
        if (id == null) {
            throw new IllegalArgumentException(
                "Erro de Regra: ID inválido para exclusão."
            );
        }
        repositorio.excluir(id);
    }
}
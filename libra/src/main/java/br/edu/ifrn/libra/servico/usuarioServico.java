package br.edu.ifrn.libra.servico;

import java.util.List;

import br.edu.ifrn.libra.modelo.usuario;
import br.edu.ifrn.libra.repositorio.Usuariorepositorio;

public class usuarioServico {

    private final Usuariorepositorio repositorio = new Usuariorepositorio();

    public void cadastrarUsuario(usuario novoUsuario) {

        // Validar nome
        if (novoUsuario.getNomeCompleto() == null
                || novoUsuario.getNomeCompleto().isEmpty()) {

            throw new IllegalArgumentException(
                    "O nome completo é obrigatório."
            );
        }

        // Validar CPF
        if (novoUsuario.getCpf() == null
                || novoUsuario.getCpf().isEmpty()) {

            throw new IllegalArgumentException(
                    "O CPF é obrigatório."
            );
        }

        // Validar Email
        if (novoUsuario.getEmail() == null
                || novoUsuario.getEmail().isEmpty()) {

            throw new IllegalArgumentException(
                    "O e-mail é obrigatório."
            );
        }

        // Validar Telefone
        if (novoUsuario.getTelefone() == null
                || novoUsuario.getTelefone().isEmpty()) {

            throw new IllegalArgumentException(
                    "O telefone é obrigatório."
            );
        }

        // Verificar CPF duplicado (agora consultando o MySQL em vez da List em memória)
        if (repositorio.buscarPorCpf(novoUsuario.getCpf()) != null) {

            throw new IllegalArgumentException(
                    "CPF já cadastrado no sistema."
            );
        }

        // Salvar usuário no MySQL
        repositorio.inserir(novoUsuario);

        System.out.println(
                "Usuário cadastrado com sucesso!"
        );
    }

    public List<usuario> listarUsuarios() {
        return repositorio.selecionarTodos();
    }
}
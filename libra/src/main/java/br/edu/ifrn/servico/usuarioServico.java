package br.edu.ifrn.servico;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrn.servico.modelo.usuario;


public class usuarioServico {

    private List<usuario> usuarios = new ArrayList<>();

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

        // Verificar CPF duplicado
        for (usuario usuario : usuarios) {

            if (usuario.getCpf().equals(novoUsuario.getCpf())) {

                throw new IllegalArgumentException(
                        "CPF já cadastrado no sistema."
                );
            }
        }

        // Salvar usuário
        usuarios.add(novoUsuario);

        System.out.println(
                "Usuário cadastrado com sucesso!"
        );
    }
}

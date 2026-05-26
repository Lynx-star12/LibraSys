package br.edu.ifrn.libra;

import br.edu.ifrn.libra.modelo.usuario;
public class EmprestimoServico {

    public void realizarEmprestimo(
        usuario usuario) {

    // Validar limite

    if (usuario.atingiuLimite()) {

        throw new IllegalArgumentException(
                "Limite de empréstimos atingido."
        );
    }

    // Registrar empréstimo

    usuario.adicionarEmprestimo();

    System.out.println(
            "Empréstimo realizado!"
    );
}

public void registrarDevolucao(
        usuario usuario) {

    usuario.devolverLivro();

    System.out.println(
            "Livro devolvido!"
    );
}
}
    
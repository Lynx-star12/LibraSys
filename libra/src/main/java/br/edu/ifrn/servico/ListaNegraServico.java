package br.edu.ifrn.servico;

import br.edu.ifrn.servico.modelo.ListaNegra;
public class ListaNegraServico {

    public void verificarPendencias(
        ListaNegra usuario) {

    // Se possui multa ou atraso = bloqueia

    if (usuario.isPossuiMulta()
            || usuario.isPossuiAtraso()) {

        usuario.setBloqueado(true);

        System.out.println(
                "Usuário na lista negra!"
        );

    } else {

        usuario.setBloqueado(false);

        System.out.println(
                "Usuário livre da lista negra!"
        );
    }
}
}

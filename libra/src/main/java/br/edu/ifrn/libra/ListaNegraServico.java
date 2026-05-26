package br.edu.ifrn.libra;

import br.edu.ifrn.libra.modelo.ListaNegra;
public class ListaNegraServico {

    public void verificarPendencias(
        ListaNegra usuario) {

    // Se possui multa ou atraso = bloqueia

    if (usuario.isPossuiMulta()
            || usuario.isPossuiAtraso()) {

        usuario.setBloqueado(true);

        System.out.println(
                "Usuário bloqueado!"
        );

    } else {

        usuario.setBloqueado(false);

        System.out.println(
                "Usuário liberado!"
        );
    }
}
}

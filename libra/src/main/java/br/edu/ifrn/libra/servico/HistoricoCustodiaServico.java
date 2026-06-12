package br.edu.ifrn.libra;

import br.edu.ifrn.libra.modelo.HistoricoCustodia;

import java.util.ArrayList;
import java.util.List;
public class HistoricoCustodiaServico {
    private List<HistoricoCustodia> historico =
    new ArrayList<>();

public void registrarMovimentacao(
    HistoricoCustodia movimentacao) {

historico.add(movimentacao);

System.out.println(
        "Movimentação registrada com sucesso!"
);
}

public void listarHistorico() {

for (HistoricoCustodia h : historico) {

    System.out.println(
            "Movimentação: "
            + h.getIdMovimentacao()
    );

    System.out.println(
            "Usuário: "
            + h.getIdUsuario()
    );

    System.out.println(
            "Exemplar: "
            + h.getIdExemplar()
    );

    System.out.println(
            "Tipo: "
            + h.getTipoMovimentacao()
    );

    System.out.println(
            "Data/Hora: "
            + h.getDataHora()
    );

    System.out.println("----------------");
}
}
}


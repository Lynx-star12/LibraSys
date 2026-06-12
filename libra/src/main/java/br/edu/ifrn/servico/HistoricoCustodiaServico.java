package br.edu.ifrn.servico;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrn.servico.modelo.HistoricoCustodia;
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


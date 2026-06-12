package br.edu.ifrn.libra;

import br.edu.ifrn.libra.modelo.Secao;

import java.util.ArrayList;
import java.util.List;

public class servico {

    private List<Secao> secoes = new ArrayList<>();

    public void cadastrarSecao(Secao novaSecao) {

        // Validar capacidade
        if (novaSecao.getCapacidadeMaxima() <= 0) {

            throw new IllegalArgumentException(
                "A capacidade deve ser maior que zero."
            );
        }

        // Verificar duplicidade
        for (Secao secao : secoes) {

            if (secao.getNomeGenero().equalsIgnoreCase(
                    novaSecao.getNomeGenero())) {

                throw new IllegalArgumentException(
                    "Já existe uma seção com esse gênero."
                );
            }

            if (secao.getCodigo().equalsIgnoreCase(
                    novaSecao.getCodigo())) {

                throw new IllegalArgumentException(
                    "Já existe uma seção com esse código."
                );
            }
        }

        // Salvar seção
        secoes.add(novaSecao);

        System.out.println(
            "Seção cadastrada com sucesso!"
        );
    }
}

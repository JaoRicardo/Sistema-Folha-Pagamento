package folha_pagamento.tads.infrastructure.printer;

import folha_pagamento.tads.domain.printer.*;
import folha_pagamento.tads.domain.valueobject.*;

public class ImprimirFolha implements ImpressoraDeFolha {
    @Override
    public void imprimir(Nome nomeFuncionario, Nome tipoContrato, String detalhes, Dinheiro pagamentoTotal) {
        System.out.println(
            "\nFuncionÃ¡rio: " + nomeFuncionario +
            "\nContrato: " + tipoContrato +
            "\nDetalhes: " + detalhes +
            "\nLÃ­quido a Pagar: R$" + pagamentoTotal
        );
    }
}


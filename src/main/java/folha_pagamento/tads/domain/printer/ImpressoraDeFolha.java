package folha_pagamento.tads.domain.printer;

import folha_pagamento.tads.domain.valueobject.*;

public interface ImpressoraDeFolha {
    void imprimir(Nome nomeFuncionario, Nome tipoContrato, String detalhesContrato, Dinheiro pagamentoTotal);
}


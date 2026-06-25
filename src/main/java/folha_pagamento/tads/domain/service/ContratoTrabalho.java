package folha_pagamento.tads.domain.service;

import folha_pagamento.tads.domain.valueobject.*;
import folha_pagamento.tads.domain.printer.*;

public interface ContratoTrabalho {
    Dinheiro calcularRemuneracao(Horas horasTrabalhadas);
    void registrarDados(ImpressoraDeFolha impressora, Nome nomeFuncionario, Dinheiro totalPago);
}


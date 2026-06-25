package folha_pagamento.tads.domain.service;

import folha_pagamento.tads.domain.valueobject.*;

public interface RegraDescontoHoras {
    Dinheiro calcularDesconto(Dinheiro salario, Horas cargaHoraria, Horas faltantes);
}


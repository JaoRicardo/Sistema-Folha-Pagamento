package folha_pagamento.tads.domain.service;

import folha_pagamento.tads.domain.valueobject.*;

public interface RegraHoraExtra {
    Dinheiro calcularValorExtra(Dinheiro salarioAtual, Horas cargaHoraria, Horas extras);
}


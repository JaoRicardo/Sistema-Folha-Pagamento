package folha_pagamento.tads.domain.service;

import folha_pagamento.tads.domain.valueobject.*;

public interface RegraImposto {
    Dinheiro calcularDesconto(Dinheiro salarioBruto);
}


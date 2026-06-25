package folha_pagamento.tads.infrastructure.tax;

import folha_pagamento.tads.domain.service.*;
import folha_pagamento.tads.domain.valueobject.*;

public class ImpostoIsento implements RegraImposto {
    @Override
    public Dinheiro calcularDesconto(Dinheiro salarioBruto) {
        return new Dinheiro(0);
    }
}


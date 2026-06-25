package folha_pagamento.tads.infrastructure.tax;

import folha_pagamento.tads.domain.service.*;
import folha_pagamento.tads.domain.valueobject.*;

public class ImpostoPadrao implements RegraImposto {
    private final double taxa;

    public ImpostoPadrao(double taxa) {
        this.taxa = taxa;
    }
    
    @Override
    public Dinheiro calcularDesconto(Dinheiro salarioBruto) {
        return salarioBruto.multiplicar(taxa);
    }
}


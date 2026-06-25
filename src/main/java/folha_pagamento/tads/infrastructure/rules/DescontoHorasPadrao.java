package folha_pagamento.tads.infrastructure.rules;

import folha_pagamento.tads.domain.service.*;
import folha_pagamento.tads.domain.valueobject.*;

public class DescontoHorasPadrao implements RegraDescontoHoras {
    @Override
    public Dinheiro calcularDesconto(Dinheiro salario, Horas cargaHoraria, Horas faltantes) {
        return salario.dividir(cargaHoraria.getQuantidade())
                      .multiplicar(faltantes.getQuantidade());
    }
}


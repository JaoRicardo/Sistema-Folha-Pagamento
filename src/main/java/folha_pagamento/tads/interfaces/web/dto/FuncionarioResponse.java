package folha_pagamento.tads.interfaces.web.dto;

import folha_pagamento.tads.domain.entity.Funcionario;

public record FuncionarioResponse(Long id, String nome, String tipoContrato) {
    public static FuncionarioResponse de(Funcionario funcionario) {
        String tipo = funcionario.getContrato() != null ? funcionario.getContrato().getClass().getSimpleName() : "Desconhecido";
        return new FuncionarioResponse(funcionario.getId(), funcionario.getNome().getValor(), tipo);
    }
}

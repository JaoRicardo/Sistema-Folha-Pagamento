package folha_pagamento.tads.domain.entity;

import folha_pagamento.tads.domain.valueobject.*;
import folha_pagamento.tads.domain.service.*;
import folha_pagamento.tads.domain.printer.*;

public class Funcionario {
    private Long id;
    private Nome nome;
    private ContratoTrabalho contrato;

    public Funcionario(Nome nome, ContratoTrabalho contrato) {
        this.nome = nome;
        this.contrato = contrato;
    }

    public Funcionario(Long id, Nome nome, ContratoTrabalho contrato) {
        this.id = id;
        this.nome = nome;
        this.contrato = contrato;
    }

    public Long getId() { return id; }
    public Nome getNome() { return nome; }
    public ContratoTrabalho getContrato() { return contrato; }

    public Dinheiro processarSalarioBruto(Horas horasTrabalhadas) {
        return contrato.calcularRemuneracao(horasTrabalhadas);
    }

    public void registrarDados(ImpressoraDeFolha impressora, Dinheiro totalPago) {
        contrato.registrarDados(impressora, this.nome, totalPago);
    }
}

package folha_pagamento.tads.domain.valueobject;


public class Nome {
    private final String valor;

    public Nome(String valor) {
        if(valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome nÃ£o pode ser vazio.");
        }
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return valor;
    }
}


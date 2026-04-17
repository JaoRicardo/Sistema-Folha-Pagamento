public class Dinheiro {
    private final double valor;

    public Dinheiro(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("O valor monetário não pode ser negativo.");
        }
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public Dinheiro somar(Dinheiro outro) {
        return new Dinheiro(this.valor + outro.valor);
    }

    public Dinheiro subtrair(Dinheiro outro) {
        return new Dinheiro(this.valor - outro.valor);
    }

    public Dinheiro multiplicar(double fator) {
        return new Dinheiro(this.valor * fator);
    }

    public Dinheiro dividir(double divisor) {
        return new Dinheiro(this.valor / divisor);
    }

    @Override
    public String toString() {
        return String.format("%.2f", valor);
    }
}

public class Horas {
    private final int quantidade;

    public Horas(int quantidade) {
        if(quantidade < 0) {
            throw new IllegalArgumentException("As horas não podem ser negativas.");
        }
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Horas somar(Horas outras) {
        return new Horas(this.quantidade + outras.quantidade);
    }

    public Horas subtrair(Horas outras) {
        return new Horas(this.quantidade - outras.quantidade);
    }

    public boolean ehMaiorQue(Horas outras) {
        return this.quantidade > outras.quantidade;
    }

    public boolean ehMenorQue(Horas outras) {
        return this.quantidade < outras.quantidade;
    }

    @Override
    public String toString() {
        return String.valueOf(quantidade);
    }
}



public class Pagamento {
    private Funcionario funcionario;
    private int horasExtras;
    private double imposto;

    public Pagamento(Funcionario funcionario, int horasExtras, double imposto) {
        this.funcionario = funcionario;
        this.horasExtras = horasExtras;
        this.imposto = imposto;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public int getHorasExtras() {
        return horasExtras;
    }
    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }
    public double calcularHoraExtra(){
        double salario = funcionario.getCargo().getSalario();
        int cargaHoraria = funcionario.getCargo().getCargaHoraria();

        double valorHora = salario/cargaHoraria;
        double valorHoraExtra = valorHora+(valorHora*0.5);
        double horasExtrasCalculada = horasExtras*valorHoraExtra;
        return horasExtrasCalculada;
    }

    public double getImposto() {
        return imposto;
    }
    public void setImposto(double imposto) {
        this.imposto = imposto;
    }
    public double calcularimposto(double salario){
        double impostoCalculado = salario*imposto;
        return impostoCalculado;
    }

    public double calcularPagamento(){
        Double salario = funcionario.getCargo().getSalario();
        double horaExtra = calcularHoraExtra();

        salario+=horaExtra;
        double impostoCalculado = calcularimposto(salario);
        salario-=impostoCalculado;

        return salario;
    }

    public void Pagamento(){
        String nomeFuncionario = funcionario.getNome();
        String nomeCargo = funcionario.getCargo().getNomeCargo();
        double salarioBase = funcionario.getCargo().getSalario();
        int cargaHoraria = funcionario.getCargo().getCargaHoraria();
        double horaExtra = calcularHoraExtra();
        double pagamento = calcularPagamento();

        System.out.println(
        "Nome do Funcionário: "+nomeFuncionario+
        "\nCargo: "+nomeCargo+
        "\nSalário Base: R$"+salarioBase+
        "\nCarga Horária: "+cargaHoraria+"hrs"+
        "\nHoras Extras: R$"+horaExtra+
        "\nPagamento: R$"+pagamento);
    }

}

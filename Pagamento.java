

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
        double horaExtra = HoraExtra.calcularHoraExtra(funcionario.getCargo(), horasExtras);

        salario+=horaExtra;
        double impostoCalculado = calcularimposto(salario);
        salario-=impostoCalculado;

        return salario;
    }
}



public class Pagamento {
    private Funcionario funcionario;
    private int horasTrabalhadas;

    public Pagamento(Funcionario funcionario, int horasTrabalhadas) {
        this.funcionario = funcionario;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }
    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }


    public double pagar(){

        double salario = CalculoHorasTrabalhadas.CalculoHoras(funcionario.getCargo(), horasTrabalhadas);
        salario = Imposto.DescontoImposto(salario);

        return salario;
        // Double salario = funcionario.getCargo().getSalario();
        // double horaExtra = HoraExtra.calcularHoraExtra(funcionario.getCargo(), horasExtras);

        // salario+=horaExtra;
        // double impostoCalculado = calcularimposto(salario);
        // salario-=impostoCalculado;

    }
}

public class Cargo {
    private String nomeCargo;
    private int cargaHoraria;
    private double salario;

    public Cargo(int cargaHoraria, String nomeCargo, double salario) {
        this.cargaHoraria = cargaHoraria;
        this.nomeCargo = nomeCargo;
        this.salario = salario;
    }

    // NOME DO CARGO
    public String getNomeCargo() {
        return nomeCargo;
    }
    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    // CARGA HORARIA
    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    // SALARIO
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
}

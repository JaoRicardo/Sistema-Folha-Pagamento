public class HoraExtra {

    public static double calcularHoraExtra(Cargo cargo, int horaExtra){
        double salario = cargo.getSalario();
        int cargaHoraria = cargo.getCargaHoraria();

        double valorHora = salario/cargaHoraria;
        double valorHoraExtra = valorHora+(valorHora*0.5);
        double horasExtrasCalculada = horaExtra*valorHoraExtra;
        return horasExtrasCalculada;
    }
}

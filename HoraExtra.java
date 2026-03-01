public class HoraExtra {

    public static double calcularHoraExtra(Cargo cargo, int horaExtra){
        double salario = cargo.getSalario();
        int cargaHoraria = cargo.getCargaHoraria();

        double horasExtrasCalculada = ((salario/cargaHoraria)*1.5)*horaExtra;
        return horasExtrasCalculada;
    }
}

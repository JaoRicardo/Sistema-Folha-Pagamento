public class HorasDescontadas {
    
    public static double calcularDesconto(Cargo cargo, int horasDescontadas){
        double salario = cargo.getSalario();
        int cargaHoraria = cargo.getCargaHoraria();

        double horasDescontoCalculada = (salario/cargaHoraria)*horasDescontadas;
        return horasDescontoCalculada;
    }
}

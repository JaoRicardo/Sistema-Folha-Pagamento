public class CalculoHorasTrabalhadas {

    public static double CalculoHoras (Cargo cargo, int horasTrabalhadas){
        int cargaHoraria = cargo.getCargaHoraria();
        double salario = cargo.getSalario();
        int horasCalculadas;
        if(horasTrabalhadas>cargaHoraria){
            horasCalculadas = horasTrabalhadas - cargaHoraria;
            double horaExtra = HoraExtra.calcularHoraExtra(cargo, horasCalculadas);
            salario += horaExtra;
            return salario;
        }else if(horasTrabalhadas<cargaHoraria){
            horasCalculadas = cargaHoraria - horasTrabalhadas;
            double horasDescontadas = HorasDescontadas.calcularDesconto(cargo, horasCalculadas);
            salario -= horasDescontadas;
            return salario;
        }else{
            return salario;
        }
    }
}

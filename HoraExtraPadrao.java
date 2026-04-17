public class HoraExtraPadrao implements RegraHoraExtra {
    private final double fatorMultiplicador;
    
    public HoraExtraPadrao(double fatorMultiplicador) {
        this.fatorMultiplicador = fatorMultiplicador;
    }
    
    @Override
    public Dinheiro calcularValorExtra(Dinheiro salario, Horas cargaHoraria, Horas extras) {
        return salario.dividir(cargaHoraria.getQuantidade())
                      .multiplicar(fatorMultiplicador)
                      .multiplicar(extras.getQuantidade());
    }
}

public class DescontoHorasPadrao implements RegraDescontoHoras {
    @Override
    public Dinheiro calcularDesconto(Dinheiro salario, Horas cargaHoraria, Horas faltantes) {
        return salario.dividir(cargaHoraria.getQuantidade())
                      .multiplicar(faltantes.getQuantidade());
    }
}

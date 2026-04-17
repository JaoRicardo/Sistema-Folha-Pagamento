public class ContratoCLT implements ContratoTrabalho {
    private Nome titulo;
    private Horas cargaHoraria;
    private Dinheiro salarioBase;
    private RegraHoraExtra regraHoraExtra;
    private RegraDescontoHoras regraDescontoHoras;

    public ContratoCLT(Horas cargaHoraria, Nome titulo, Dinheiro salarioBase, RegraHoraExtra regraHoraExtra, RegraDescontoHoras regraDescontoHoras) {
        this.cargaHoraria = cargaHoraria;
        this.titulo = titulo;
        this.salarioBase = salarioBase;
        this.regraHoraExtra = regraHoraExtra;
        this.regraDescontoHoras = regraDescontoHoras;
    }

    @Override
    public Dinheiro calcularRemuneracao(Horas horasTrabalhadas) {
        if (horasTrabalhadas.ehMaiorQue(cargaHoraria)) {
            Horas horasExtras = horasTrabalhadas.subtrair(cargaHoraria);
            Dinheiro extra = regraHoraExtra.calcularValorExtra(salarioBase, cargaHoraria, horasExtras);
            return salarioBase.somar(extra);
        }
        if (horasTrabalhadas.ehMenorQue(cargaHoraria)) {
            Horas faltou = cargaHoraria.subtrair(horasTrabalhadas);
            Dinheiro desconto = regraDescontoHoras.calcularDesconto(salarioBase, cargaHoraria, faltou);
            return salarioBase.subtrair(desconto);
        }
        return salarioBase;
    }

    @Override
    public void registrarDados(ImpressoraDeFolha impressora, Nome nomeFuncionario, Dinheiro totalPago) {
        String detalhes = "Salário Base: R$" + salarioBase + " | Carga Horária: " + cargaHoraria + "hrs";
        impressora.imprimir(nomeFuncionario, this.titulo, detalhes, totalPago);
    }
}

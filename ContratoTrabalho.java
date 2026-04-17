public interface ContratoTrabalho {
    Dinheiro calcularRemuneracao(Horas horasTrabalhadas);
    void registrarDados(ImpressoraDeFolha impressora, Nome nomeFuncionario, Dinheiro totalPago);
}

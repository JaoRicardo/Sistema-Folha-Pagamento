public class ImprimirFolha implements ImpressoraDeFolha {
    @Override
    public void imprimir(Nome nomeFuncionario, Nome tipoContrato, String detalhes, Dinheiro pagamentoTotal) {
        System.out.println(
            "\nFuncionário: " + nomeFuncionario +
            "\nContrato: " + tipoContrato +
            "\nDetalhes: " + detalhes +
            "\nLíquido a Pagar: R$" + pagamentoTotal
        );
    }
}

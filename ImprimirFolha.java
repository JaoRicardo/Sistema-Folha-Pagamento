public class ImprimirFolha {

    public static void Imprimir(Pagamento pagamento){
        String nomeFuncionario = pagamento.getFuncionario().getNome();
        String nomeCargo = pagamento.getFuncionario().getCargo().getNomeCargo();
        double salarioBase = pagamento.getFuncionario().getCargo().getSalario();
        int cargaHoraria = pagamento.getFuncionario().getCargo().getCargaHoraria();
        double dinheiro = pagamento.pagar();

        System.out.println(
        "Nome do Funcionário: "+nomeFuncionario+
        "\nCargo: "+nomeCargo+
        "\nSalário Base: R$"+salarioBase+
        "\nCarga Horária: "+cargaHoraria+"hrs"+
        "\nPagamento: R$"+dinheiro);
    }
}

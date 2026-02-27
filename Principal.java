public class Principal {
    
    public static void main(String[] args) {
        Cargo Dois = new Cargo( 400,  "Dois",  2000);
        Funcionario Teste = new Funcionario("Teste", Dois, "000.000.000-01" );
        
        Pagamento pagamento = new Pagamento(Teste, 10, 0.10);
        ImprimirFolha folha = new ImprimirFolha(pagamento);

        folha.Imprimir();
        
    }
}

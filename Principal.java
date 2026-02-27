public class Principal {
    
    public static void main(String[] args) {
        Cargo Dois = new Cargo( 400,  "Dois",  2000);
        Funcionario Teste = new Funcionario("Teste", Dois);
        Pagamento pagamento = new Pagamento(Teste, 10, 0.10);

        pagamento.Pagamento();
    }
}

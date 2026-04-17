public class Principal {
    public static void main(String[] args) {
        ImpressoraDeFolha impressora = new ImprimirFolha();
        
        // Regras / Dependencias Comuns
        RegraHoraExtra regraExtra = new HoraExtraPadrao(1.5);
        RegraDescontoHoras regraDesconto = new DescontoHorasPadrao();
        RegraImposto impostoClt = new ImpostoPadrao(0.1); 
        RegraImposto isento = new ImpostoIsento();

        System.out.println("====== GERADOR DE FOLHA DE PAGAMENTO (POLIMORFISMO) ======");

        // 1. Funcionario CLT
        ContratoTrabalho clt = new ContratoCLT(new Horas(210), new Nome("Desenvolvedor Junior"), new Dinheiro(2000), regraExtra, regraDesconto);
        Funcionario dev = new Funcionario(new Nome("João CLT"), clt);
        Pagamento pagClt = new Pagamento(dev, new Horas(220), impostoClt); // Trabalhou 220hrs (10 extras)
        pagClt.efetuarPagamento(impressora);

        // 2. Funcionario Estagiário
        ContratoTrabalho estagio = new ContratoEstagio(new Nome("Estagiário de TI"), new Dinheiro(1000), new Horas(120), regraDesconto);
        Funcionario est = new Funcionario(new Nome("Maria Estagiária"), estagio);
        Pagamento pagEstagio = new Pagamento(est, new Horas(110), isento); // Trabalhou 110hrs (faltou 10)
        pagEstagio.efetuarPagamento(impressora);

        // 3. Funcionario PJ
        ContratoTrabalho pj = new ContratoPJ(new Nome("Consultor Especialista"), new Dinheiro(150)); // R$ 150 a hora
        Funcionario cons = new Funcionario(new Nome("Carlos PJ"), pj);
        Pagamento pagPj = new Pagamento(cons, new Horas(100), isento); // Trabalhou 100hrs
        pagPj.efetuarPagamento(impressora);
    }
}

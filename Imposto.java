public class Imposto {

    public static double DescontoImposto(double salario){
        double imposto = 0.1; 
        salario -= salario*imposto;
        return salario;
    }
}

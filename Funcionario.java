public class Funcionario {
    private String nome;
    private Cargo cargo;
    public Funcionario(String nome, Cargo cargo)
    {
        this.nome = nome;
        this.cargo = cargo;
    }

    // NOME
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    // CARGO
    public Cargo getCargo() {
        return cargo;
    }
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}

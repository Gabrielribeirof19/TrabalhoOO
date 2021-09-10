package classes;

public abstract class Pessoa {
    protected String nome;
    protected String cpf;
    protected Telefone telefone;
    protected String email;
    
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }

    public Telefone getTelefone(){
        return telefone;
    }
    
    public void setTelefone(Telefone telefone){
        this.telefone = telefone;
    }
}
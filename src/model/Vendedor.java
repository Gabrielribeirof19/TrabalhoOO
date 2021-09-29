package model;

public class Vendedor extends Pessoa{
    private int identificador;
    private int numeroDeVendas;

    public Vendedor(int id, int numVendas, String name){
        identificador = id;
        numeroDeVendas = numVendas;
        nome = name;
    }
    
    public String toString(){
        return "Vendedor: " + nome;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getCpf(){
        return cpf;
    } 
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public Telefone getTelefone(){
        return telefone;
    }
    
    public void setTelefone(Telefone telefone){
        this.telefone = telefone;
    }

    public int getId(){
        return identificador;
    }

    public void setId(int identificador){
        this.identificador = identificador; 
    }

    public int getNumVenda(){
        return numeroDeVendas;
    }

    public void setNumVenda(int numeroDeVendas){
        this.numeroDeVendas = numeroDeVendas;
    }
}
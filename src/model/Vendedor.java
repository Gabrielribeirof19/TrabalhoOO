package model;

public class Vendedor extends Pessoa{
    private int identificador;
    private int numeroDeVendas;
    private Vendedor [] vendedor = new Vendedor[50];
    private int qtdVendedor = 0;

    public Vendedor(int id, int numVendas, String name, String cpf, Telefone telefone, String email){
        identificador = id;
        numeroDeVendas = numVendas;
        nome = name;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
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
    public Vendedor getVendedor(int i){
        return this.vendedor[i];
    }

    public void setVendedor(Vendedor v, int i){
        this.vendedor[i] = v;
    }

    public void cadastrar(Vendedor v, int[] i){
        this.vendedor[i[0]] = v;
        
    }

    public void editar(Vendedor v, int pos){
        this.vendedor[pos] = v;
    }
}
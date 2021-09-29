package model;

public class Cliente extends Pessoa {
    private Endereco endereco;
    private Double cashback;

    public Cliente(Endereco e, Double Cashback){
        endereco = e;
        cashback = Cashback;
    }

    public String toString(){
        return "Nome: " + nome + " CEP: " + endereco.getCEP();
    }

    public Endereco getEndereco(){
        return endereco;
    }

    public void setEndereco(Endereco end){
        this.endereco = end;
    }

    public Double getCasback(){
        return cashback;
    }

    public void setCashback(Double c){
        this.cashback = c;
    }
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
package model;

/**
 * Modelo do Cliente, contém os dados da aplicação
 * @author Cícero Fernandes
 * @author Gabriel de Souza
 * @version 1.0 (out 2021)
 */
public class Cliente extends Pessoa {
    private Endereco endereco;
    private Double cashback;
    private Cliente [] cliente = new Cliente[50];

    public Cliente(String nome, String cpf, Endereco e, Double Cashback, String email, Telefone telefone){
        endereco = e;
        cashback = Cashback;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.nome = nome;
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

    public Cliente getCliente(int i){
        return this.cliente[i];
    }

    public void setCliente(Cliente c, int i){
        this.cliente[i] = c;
    }

    /**
     * Cadastra o objeto "c" na última posição
     * @param c Objeto com os dados a serem cadastrados
     * @param i Posição que irá receber o cadastro(Última)
     */
    public void cadastrar(Cliente c, int[] i){
        this.cliente[i[0]] = c;
        
    }

    /**
     *  Edita o objeto na posição "pos" com os dados de "c"
     * @param c Objetos com os dados que irão editar
     * @param pos Posição que irá sofrer a edição
     */
    public void editar(Cliente c, int pos){
        this.cliente[pos] = c;
    }
}
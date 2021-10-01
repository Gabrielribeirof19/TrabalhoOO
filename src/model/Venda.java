package model;

public class Venda {
    private String nomeProduto;
    private int idVenda;
    private double preco;
    private double cashBack;
    private int idVendedor;
    private String nomeCliente;
    private Venda [] venda = new Venda[50];
    private int qtdVenda = 0;

    public Venda(String nomeCliente, int idVendedor, double preco, double cashBack, String nomeProduto, int idVenda){
        this.nomeCliente = nomeCliente;
        this.idVendedor = idVendedor;
        this.preco = preco;
        this.cashBack = cashBack;
        this.nomeProduto = nomeProduto;
        this.idVenda = idVenda;
    }

    public String toString(){
        return "Nome do cliente: " + nomeCliente + "\n Id do Vendedor: " + idVendedor;
    }

    public String getNomeProduto(){
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto){
        this.nomeProduto = nomeProduto;
    }

    public int getIdVenda(){
        return idVenda;
    }

    public void setIdVenda(int idVenda){
        this.idVenda = idVenda;
    }

    public double getPreco(){
        return preco;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public double getCashBack(){
        return cashBack;
    }

    public void setCashBack(double cashBack){
        this.cashBack = cashBack;
    }

    public int getIdVendedor(){
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor){
        this.idVendedor = idVendedor;
    }

    public String getNomeCliente(){
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente){
        this.nomeCliente = nomeCliente;
    }
    
    public Venda getVenda(int i){
        return this.venda[i];
    }

    public void setVenda(Venda v, int i){
        this.venda[i] = v;
    }

    public void cadastrar(Venda v, int[] i){
        this.venda[i[0]] = v;
        
    }
}
package model;

public class Inferior extends Produto{
    private String material;
    private String tipo;
    private Inferior [] inferior = new Inferior[50];
    private int qtdInferior = 0;

    //Sobrecarga
    public Inferior(String name, double price, String tipo, String material, int tamanho, double porcentagemCash, String cor, int estoque){
        nome = name;
        preco = price;
        this.tipo = tipo;
        this.material = material;
        this.tamanho = tamanho;
        this.porcentagemCash = porcentagemCash;
        this.cor = cor;
        this.estoque = estoque;
    }

    public String toString(){
        return "Produto: " + nome;
    }

    public String getMaterial(){
        return material;
    }

    public void setMaterial(String material){
        this.material = material;
    }

    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }
   
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public double getPreco(){
        return preco;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

    public int getTamanho(){
        return tamanho;
    }

    public void setTamanho(int tamanho){
        this.tamanho = tamanho;
    }

    public double getPorcentagem(){
        return porcentagemCash;
    }

    public void setPorcentagem(double porcentagemCash){
        this.porcentagemCash = porcentagemCash;
    }

    public String getCor(){
        return cor;
    }

    public void setCor(String cor){
        this.cor = cor;
    }

    public int getEstoque(){
        return estoque;
    }

    public void setEstoque(int estoque){
        this.estoque = estoque;
    }
    public Inferior getInferior(int i){
        return this.inferior[i];
    }
    public void setInferior(Inferior c, int i){
        this.inferior[i] = c;
    }
    public void cadastrar(Inferior c, int[] i){
        this.inferior[i[0]] = c;
        
    }

    public void editar(Inferior c, int pos){
        this.inferior[pos] = c;
    }

    
}

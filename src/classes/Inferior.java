package classes;

public class Inferior extends Produto{
    private String material;
    private String tipo;

    //Sobrecarga
    public Inferior(String name, double price, String tipo, String material){
        nome = name;
        preco = price;
        this.tipo = tipo;
        this.material = material;
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

    
}

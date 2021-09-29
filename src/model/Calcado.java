package model;

public class Calcado extends Produto{
    private boolean canoLongo;
    private boolean cadarco;

    //Sobrecarga
    public Calcado(String name, double price, boolean tipoCano, boolean cadarco){
        nome = name;
        preco = price;
        canoLongo = tipoCano;
        this.cadarco = cadarco;
    }

    public Calcado(String name, boolean tipoCano, boolean cadarco){
        nome = name;
        canoLongo = tipoCano;
        this.cadarco = cadarco;
    }

    public String toString(){
        return "Produto: " + nome;
    }

    public boolean getCano(){
        return canoLongo;
    }

    public void setCano(boolean canoLongo){
        this.canoLongo = canoLongo;
    }
    public boolean getCadarco(){
        return cadarco;
    }

    public void setCardarco(boolean cadarco){
        this.cadarco = cadarco;
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
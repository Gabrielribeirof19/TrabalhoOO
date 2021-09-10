package classes;

public abstract class Produto {

    protected String nome;
    protected double preco;
    protected int tamanho;
    protected double porcentagemCash;
    protected String cor;
    protected int estoque;

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

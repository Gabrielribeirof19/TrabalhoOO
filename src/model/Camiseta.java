package model;

public class Camiseta extends Produto{
    private boolean mangaLonga;
    private String gola;
    private String tamanhoString;
    private Camiseta [] camiseta = new Camiseta[50];
    private int qtdCamiseta = 0;

    public Camiseta(String name, double price, String tamanhoString, String gola, double porcentagemCash, String cor, int estoque, boolean mangaLonga){
        nome = name;
        preco = price;
        this.tamanhoString = tamanhoString;
        this.gola = gola;
        this.porcentagemCash = porcentagemCash;
        this.cor = cor;
        this.estoque = estoque;
        this.mangaLonga = mangaLonga;
    }
    
    public String toString(){
        return "Produto: " + nome;
    }

    public String getTamanhoString(){
        return tamanhoString;
    }

    public void setTamanhoString(String tamanhoString){
        this.tamanhoString = tamanhoString;
    }

    public String getGola(){
        return gola;
    }

    public void setGola(String gola){
        this.gola = gola;
    }

    public boolean getMangaLonga(){
        return mangaLonga;
    }

    public void setMangaLonga(boolean mangaLonga){
        this.mangaLonga = mangaLonga;
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
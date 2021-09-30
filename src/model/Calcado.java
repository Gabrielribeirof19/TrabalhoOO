package model;

public class Calcado extends Produto{
    private boolean canoLongo;
    private boolean cadarco;
    private Calcado[] calcado = new Calcado[50];

    //Sobrecarga
    public Calcado(String name, double price, int tamanho, double porcentagemCash, String cor, int estoque, boolean tipoCano, boolean cadarco){
        nome = name;
        preco = price;
        canoLongo = tipoCano;
        this.porcentagemCash = porcentagemCash;
        this.tamanho = tamanho;
        this.cor = cor;
        this.estoque = estoque;
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

    public Calcado getCalcado(int i){
        return this.calcado[i];
    }

    public void setCalcado(Calcado c, int i){
        this.calcado[i] = c;
    }

    public void cadastrar(Calcado c, int[] i){
        this.calcado[i[0]] = c;
        
    }

    public void editar(Calcado c, int pos){
        this.calcado[pos] = c;
    }
}
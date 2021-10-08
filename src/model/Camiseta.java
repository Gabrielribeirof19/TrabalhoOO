package model;

/**
 * Modelo da Camiseta, contém os dados da aplicação
 * @author Cícero Fernandes
 * @author Gabriel de Souza
 * @version 1.0 (out 2021)
 */
public class Camiseta extends Produto{
    private boolean mangaLonga;
    private String gola;
    private String tamanhoString;
    private Camiseta[] camiseta = new Camiseta[50];
   

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

    public Camiseta getCamiseta(int i){
        return this.camiseta[i];
    }

    public void setCamiseta(Camiseta c, int i){
        this.camiseta[i] = c;
    }

    /**
     * Cadastra o objeto "c" na última posição
     * @param c Objeto com os dados a serem cadastrados
     * @param i Posição que irá receber o cadastro(Última)
     */
    public void cadastrar(Camiseta c, int[] i){
        this.camiseta[i[0]] = c;
        
    }

    /**
     * Edita o objeto na posição "pos" com os dados de "c"
     * @param c Objetos com os dados que irão editar
     * @param pos Posição que irá sofrer a edição
     */
    public void editar(Camiseta c, int pos){
        this.camiseta[pos] = c;
    }
}
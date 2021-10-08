package model;

/**
 * Modelo do Casaco, contém os dados da aplicação
 * @author Cícero Fernandes
 * @author Gabriel de Souza
 * @version 1.0 (out 2021)
 */
public class Casaco extends Produto{
    private String material;
    private boolean ziper;
    private boolean capuz;
    private boolean bolso;
    private String tamanhoString;
    private Casaco [] casaco = new Casaco[50];

    public Casaco(String name, double price, String material, boolean ziper, boolean capuz, boolean bolso, String tamanhoString, double porcentagemCash, String cor, int estoque){
        nome = name;
        preco = price;
        this.material = material;
        this.ziper = ziper;
        this.capuz = capuz;
        this.bolso = bolso;
        this.tamanhoString = tamanhoString;
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

    public boolean getZiper(){
        return ziper;
    }

    public void setZiper(boolean ziper){
        this.ziper = ziper;
    }

    public boolean getCapuz(){
        return capuz;
    }

    public void setCapuz(boolean capuz){
        this.capuz = capuz;
    }

    public boolean getBolso(){
        return bolso;
    }

    public void setBolso(boolean bolso){
        this.bolso = bolso;
    }

    public String getTamanhoString(){
        return tamanhoString;
    }

    public void setTamanhoString(String tamanhoString){
        this.tamanhoString = tamanhoString;
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
    public Casaco getCasaco(int i){
        return this.casaco[i];
    }

    public void setCasaco(Casaco c, int i){
        this.casaco[i] = c;
    }

    /**
     * Cadastra o objeto "c" na última posição
     * @param c Objeto com os dados a serem cadastrados
     * @param i Posição que irá receber o cadastro(Última)
     */
    public void cadastrar(Casaco c, int[] i){
        this.casaco[i[0]] = c;
        
    }

    /**
     * Edita o objeto na posição "pos" com os dados de "c"
     * @param c Objetos com os dados que irão editar
     * @param pos Posição que irá sofrer a edição
     */
    public void editar(Casaco c, int pos){
        this.casaco[pos] = c;
    }
}
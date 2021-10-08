package model;

/**
 * Modelo do Calcado, contém os dados da aplicação
 * @author Cícero Fernandes
 * @author Gabriel de Souza
 * @version 1.0 (out 2021)
 */
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

    /**
     * Cadastra o objeto "c" na última posição
     * @param c Objeto com os dados a serem cadastrados
     * @param i Posição que irá receber o cadastro(Última)
     */
    public void cadastrar(Calcado c, int[] i){
        this.calcado[i[0]] = c;
    }

    /**
     * Edita o objeto na posição "pos" com os dados de "c"
     * @param c Objetos com os dados que irão editar
     * @param pos Posição que irá sofrer a edição
     */
    public void editar(Calcado c, int pos){
        this.calcado[pos] = c;
    }
}
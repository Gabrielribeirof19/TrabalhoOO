package model;

/**
 * Modelo do Inferior, contém os dados da aplicação
 * @author Cícero Fernandes
 * @author Gabriel de Souza
 * @version 1.0 (out 2021)
 */
public class Inferior extends Produto{
    private String material;
    private String tipo;
    private Inferior [] inferior = new Inferior[50];
    public int qtdInferior = 0;

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
    
    /**
     * Cadastra o objeto "c" na última posição
     * @param c Objeto com os dados a serem cadastrados
     * @param i Posição que irá receber o cadastro(Última)
     */
    public void cadastrar(Inferior c, int[] i){
        this.inferior[i[0]] = c;
        
    }

    /**
     * Edita o objeto na posição "pos" com os dados de "c"
     * @param c Objetos com os dados que irão editar
     * @param pos Posição que irá sofrer a edição
     */
    public void editar(Inferior c, int pos){
        this.inferior[pos] = c;
    }

    
}

package controller;
import model.*;

/**
 * Trabalha os dados da classe vendedor feita no model.
 * @author Cícero Fernandes
 * @author Gabriel de Souza
 * @version 1.0 (out 2021)
 */
public class ControllerVendedor {
    private Vendedor[] vendedors = new Vendedor[50];
    public int[] qtdVendedor = new int[1];

    /**
     * Carrega um dado do tipo Vendedor vindo do model Vendedor
     * @param i Posição do objeto que você quer buscar
     * @return Objeto do tipo CVendedor carregado do model
     */
    public Vendedor getvVendedor(int i){
        return this.vendedors[i].getVendedor(i);
    }

    /**
     * Retorna a quantidade de vendedores cadastrados
     * @return Quantidade de Vendededor cadastrado
     */
    public int getQtdVendedor(){
        return this.qtdVendedor[0];
    }

    /**
     * Cadastra um objeto do tipo Vendedor no model.
     * @param dados Lista de String contendo os dados para inicializar o objeto a ser cadastrado
     * @return retorna verdadeiro ou falso, indicando se o cadastro foi feito com sucesso ou não
     */
    public boolean cadastro(String[] dados){
        Vendedor c = new Vendedor(Integer.parseInt(dados[6]), Integer.parseInt(dados[7]), dados[1], dados[2], new Telefone(dados[4], dados[5]), dados[3]);
        vendedors[qtdVendedor[0]] = new Vendedor(256, 28, "cicero", "897875432", new Telefone("61", "902389089"), "akshaskjhadjkahs@gmail.com");
        vendedors[qtdVendedor[0]].cadastrar(c, qtdVendedor);
        System.out.println(qtdVendedor[0]);
        qtdVendedor[0]++;
        System.out.println(qtdVendedor[0]);
        return true;
    }

    /**
     * Editar um objeto do tipo Vendedor no model.
     * @param dados Lista de String contendo os dados para editar o objeto cadastrado
     * @param pos Posição do objeto na model que será editado.
     * @return retorna verdadeiro ou falso, indicando se a edição foi feita com sucesso ou não
     */
    public boolean editar(String[] dados, int pos){
        if(pos >= 0 && pos <=this.qtdVendedor[0]){
            Vendedor c = new Vendedor(Integer.parseInt(dados[6]), Integer.parseInt(dados[7]), dados[1], dados[2], new Telefone(dados[4], dados[5]), dados[3]);
            vendedors[this.qtdVendedor[0]] = new Vendedor(256, 28, "cicero", "897875432", new Telefone("61", "902389089"), "akshaskjhadjkahs@gmail.com");
            vendedors[this.qtdVendedor[0]].editar(c, pos);
            return true;
        }
        return false;
    }

    /**
     * Exclui um objeto do tipo Vendedor na posição indicada.
     * @param i Posição a ser excluída
     * @return Retorna verdadeiro ou falso, indicando se a exclusão foi feita com sucesso ou não
     */
    public boolean excluir(int i){
        if(i == qtdVendedor[0] - 1){
            vendedors[i].setVendedor(null, i);
            qtdVendedor[0]--;
            return true;
        }
        
        if(i >= 0 && i < qtdVendedor[0]){
            for(int j = i; j < qtdVendedor[0]; j++){    
                    Vendedor v;
                    vendedors[j].setVendedor(null, j); 
                    v = vendedors[j+1].getVendedor(j+1);
                    vendedors[j].setVendedor(v, j);
                    System.out.println("Excluiu");
            }
            qtdVendedor[0]--;
            return true;
        }
        return false;
    }    
}

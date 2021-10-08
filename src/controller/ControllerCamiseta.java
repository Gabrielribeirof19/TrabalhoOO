package controller;
import model.*;

/**
 * Trabalha os dados da classe Camiseta feita no model.
 * @author Cícero Fernandes
 * @author Gabriel de Souza
 * @version 1.0 (out 2021)
 */
public class ControllerCamiseta {
    private Camiseta [] camiseta = new Camiseta[50];
    public int [] qtdCamiseta = new int [1];

     /**
     * Carrega um dado do tipo Camiseta vindo do model Camiseta
     * @param i Posição do objeto que você quer buscar
     * @return Objeto do tipo Camiseta carregado do model
     */
    public Camiseta getCamiseta(int i){
        return this.camiseta[i].getCamiseta(i);
    }

    /**
     * Retorna a quantidade de camisetas cadastradas
     * @return retorna a quantidade de camisetas
     */

    public int getQtdCamiseta(){
        return this.qtdCamiseta[0];
    }

    /**
     * Cadastra um objeto do tipo Camiseta no model
     * @param dados Lista de String contendo os dados para inicializar o objeto a ser cadastrado
     * @return retorna verdadeiro ou falso, indicando se o cadastro foi feito com sucesso ou não
     */
    public boolean cadastro(String [] dados){
        Camiseta ca = new Camiseta(dados[1], Double.parseDouble(dados[2]), dados[3], dados[4], Double.parseDouble(dados[5]), dados[6], Integer.parseInt(dados[7]), Boolean.parseBoolean(dados[8]));
        camiseta[qtdCamiseta[0]] = new Camiseta("tie-dye", 25.0, "M", "polo", 10.0, "preta", 32, true);
        camiseta[qtdCamiseta[0]].cadastrar(ca, qtdCamiseta);
        System.out.println(qtdCamiseta[0]);
        qtdCamiseta[0]++;
        System.out.println(qtdCamiseta[0]);
        return true;
    }

    /**
     * Editar um objeto do tipo Camiseta no model
     * @param dados Lista de String contendo os dados para editar o objeto cadastrado
     * @param pos Posição do objeto na model que será editado.
     * @return retorna verdadeiro ou falso, indicando se a edição foi feita com sucesso ou não
     */
    
    public boolean editar(String[] dados, int pos){
        if(pos >= 0 && pos <=this.qtdCamiseta[0]){
            Camiseta ca = new Camiseta(dados[1], Double.parseDouble(dados[2]), dados[3], dados[4], Double.parseDouble(dados[5]), dados[6], Integer.parseInt(dados[7]), Boolean.parseBoolean(dados[8]));
            camiseta[pos] = new Camiseta("tie-dye", 25.0, "M", "polo", 10.0, "preta", 32, true);
            camiseta[pos].editar(ca, pos);
            return true;
        }
        return false;
    }

    /**
     * Exclui um objeto do tipo Camiseta na posição indicada
     * @param i Posição a ser excluída 
     * @return Retorna verdadeiro ou falso, indicando se a exclusão foi feita com sucesso ou não
     */
    public boolean excluir(int i){
        if(i == qtdCamiseta[0] - 1){
            camiseta[i].setCamiseta(null, i);
            qtdCamiseta[0]--;
            return true;
        }
         if(i >= 0 && i < qtdCamiseta[0]){
            for(int j = i; j < qtdCamiseta[0]; j++){    
                    Camiseta cami;
                    camiseta[j].setCamiseta(null, j); 
                    cami = camiseta[j+1].getCamiseta(j+1);
                    camiseta[j].setCamiseta(cami, j);
                    System.out.println("Excluiu");
            }
            qtdCamiseta[0]--;
            return true;
        }
        
        return false;
    }

}

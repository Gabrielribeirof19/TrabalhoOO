package controller;

import model.Casaco;

/**
 * Trabalha os dados da classe Casaco feita no model.
 * @author Cícero Fernandes
 * @author Gabriel de Souza
 * @version 1.0 (out 2021)
 */

public class ControllerCasaco {
    private Casaco [] casaco = new Casaco[50];
    public int [] qtdCasaco = new int[1];

    /**
     * Carrega um dado do tipo Casaco vindo do model Casaco
     * @param i Posição do objeto que você quer buscar
     * @return Objeto do tipo Casaco carregado do model
     */
    public Casaco getCasaco(int i){
        return this.casaco[i].getCasaco(i);
    }

    /**
     * Retorna a quantidade de casacos cadastrados
     * @return Quantidade de Casado cadastrado
     */
    public int getQtdCasaco(){
        return this.qtdCasaco[0];
    }

    /**
     * Cadastra um objeto do tipo Casaco no model.
     * @param dados Lista de String contendo os dados para inicializar o objeto a ser cadastrado
     * @return retorna verdadeiro ou falso, indicando se o cadastro foi feito com sucesso ou não
     */
    public boolean cadastro (String [] dados){
        Casaco ca = new Casaco(dados[1], Double.parseDouble(dados[2]), dados[10] , Boolean.parseBoolean(dados[8]), Boolean.parseBoolean(dados[7]), Boolean.parseBoolean(dados[9]), dados[3], Double.parseDouble(dados[4]), dados[5], Integer.parseInt(dados[6]));
        casaco[qtdCasaco[0]] = new Casaco("MOLETOM", 25.5, "algodao" , true, true, true, "M", 15.0, "azul", 30);
        casaco[qtdCasaco[0]].cadastrar(ca, qtdCasaco);
        System.out.println(qtdCasaco[0]);
        qtdCasaco[0]++;
        System.out.println(qtdCasaco[0]);
        return true;
    }

    /**
     * Editar um objeto do tipo Casaco no model.
     * @param dados Lista de String contendo os dados para editar o objeto cadastrado
     * @param pos Posição do objeto na model que será editado.
     * @return retorna verdadeiro ou falso, indicando se a edição foi feita com sucesso ou não
     */
    public boolean editar(String[] dados, int pos){
        if(pos >= 0 && pos <=this.qtdCasaco[0]){
            Casaco ca = new Casaco(dados[1], Double.parseDouble(dados[2]), dados[10] , Boolean.parseBoolean(dados[8]), Boolean.parseBoolean(dados[7]), Boolean.parseBoolean(dados[9]), dados[3], Double.parseDouble(dados[4]), dados[5], Integer.parseInt(dados[6]));
            casaco[pos] = new Casaco("MOLETOM", 25.5, "algodao" , true, true, true, "M", 15.0, "azul", 30);
            casaco[pos].editar(ca, pos);
            return true;
        }
        return false;
    }

    /**
     * Exclui um objeto do tipo Casaco na posição indicada.
     * @param i Posição a ser excluída 
     * @return Retorna verdadeiro ou falso, indicando se a exclusão foi feita com sucesso ou não
     */
    public boolean excluir(int i){
        if(i == qtdCasaco[0] - 1){
            casaco[i].setCasaco(null, i);
            qtdCasaco[0]--;
            return true;
        }
        if(i >= 0 && i < qtdCasaco[0]){
            for(int j = i; j < qtdCasaco[0]; j++){    
                    Casaco c;
                    casaco[j].setCasaco(null, i); 
                    c = casaco[j+1].getCasaco(j+1);
                    casaco[j].setCasaco(c, i);
                    System.out.println("Excluiu");
            }
            qtdCasaco[0]--;
            return true;
        }
        
        return false;
    }

}

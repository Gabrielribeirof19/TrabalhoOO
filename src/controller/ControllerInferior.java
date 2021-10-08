package controller;

import model.Inferior;

/**
*Trabalha os dados da classe Inferior feita no model.
* @author Cícero Fernandes
* @author Gabriel de Souza
* @version 1.0 (out 2021)
*/
public class ControllerInferior {
    private Inferior [] inferiors = new Inferior[50];
    public int [] qtdInferior = new int [1];

    /**
    * Carrega um dado do tipo Inferior vindo do model Inferior
    * @param i Posição do objeto que você quer buscar
    * @return Objeto do tipo Inferior carregado do model
    */
    public Inferior getiInferior(int i){
        return this.inferiors[i].getInferior(i);
    }
    
    /**
    * Retorna a quantidade de inferiores cadastrados
    * @return Quantidade de Inferior cadastrado
    */
    public int getQtdInferior(){
        return this.qtdInferior[0];
    }

    /**
    * Cadastra um objeto do tipo Inferior no model.
    * @param dados Lista de String contendo os dados para inicializar o objeto a ser cadastrado
    * @return  retorna verdadeiro ou falso, indicando se o cadastro foi feito com sucesso ou não
    */
    public boolean cadastro(String [] dados){
        Inferior inf = new Inferior(dados[1], Double.parseDouble(dados[2]), dados[7], dados[8], Integer.parseInt(dados[3]), Double.parseDouble(dados[4]), dados[5], Integer.parseInt(dados[6]));
        inferiors[qtdInferior[0]] = new Inferior("Leg", 25.5, "moletom", "algodão", 36, 10.0, "preta", 25);
        inferiors[qtdInferior[0]].cadastrar(inf, qtdInferior);
        System.out.println(qtdInferior[0]);
        qtdInferior[0]++;
        System.out.println(qtdInferior[0]);
        return true;
    }

    /**
    * Editar um objeto do tipo Inferior no model.
     * @param dados Lista de String contendo os dados para editar o objeto cadastrado
     * @param pos Posição do objeto na model que será editado.
     * @return retorna verdadeiro ou falso, indicando se a edição foi feita com sucesso ou não 
     */
    public boolean editar(String[] dados, int pos){
        if(pos >= 0 && pos <=this.qtdInferior[0]){
            Inferior inf = new Inferior(dados[1], Double.parseDouble(dados[2]), dados[7], dados[8], Integer.parseInt(dados[3]), Double.parseDouble(dados[4]), dados[5], Integer.parseInt(dados[6]));
            inferiors[pos] = new Inferior("Leg", 25.5, "moletom", "algodão", 36, 10.0, "preta", 25);
            inferiors[pos].editar(inf, pos);
            return true;
        }
        return false;
    }
    
    /**
    * Exclui um objeto do tipo Inferior na posição indicada. 
    * @param i Posição a ser excluída 
    * @return Retorna verdadeiro ou falso, indicando se a exclusão foi feita com sucesso ou não
     */
    public boolean excluir(int i){
        if(i == qtdInferior[0] - 1){
            inferiors[i].setInferior(null, i);
            qtdInferior[0]--;
            return true;
        }
      if(i >= 0 && i < qtdInferior[0]){
            for(int j = i; j < qtdInferior[0]; j++){    
                    Inferior v;
                    inferiors[j].setInferior(null, j); 
                    v = inferiors[j+1].getInferior(j+1);
                    inferiors[j].setInferior(v, i);
                    System.out.println("Excluiu");
            }
            qtdInferior[0]--;
            return true;
        }
        
        return false;
    }
}

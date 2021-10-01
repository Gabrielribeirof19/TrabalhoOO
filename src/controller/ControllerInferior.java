package controller;

import model.Inferior;

public class ControllerInferior {
    private Inferior [] inferiors = new Inferior[50];
    public int [] qtdInferior = new int [1];


    public Inferior getiInferior(int i){
        return this.inferiors[i].getInferior(i);
    }
    public int getqtdCamiseta(){
        return this.qtdInferior[0];
    }

    public boolean cadastro(String [] dados){
        Inferior inf = new Inferior("Leg", 25.5, "moletom", "algodão", 36, 10.0, "preta", 25);
        inferiors[qtdInferior[0]] = new Inferior("Leg", 25.5, "moletom", "algodão", 36, 10.0, "preta", 25);
        inferiors[qtdInferior[0]].cadastrar(inf, qtdInferior);
        System.out.println(qtdInferior[0]);
        qtdInferior[0]++;
        System.out.println(qtdInferior[0]);
        return true;
    }
    public boolean editar(String[] dados, int pos){
        if(pos >= 0 && pos <=this.qtdInferior[0]){
            Inferior inf = new Inferior("Leg", 25.5, "moletom", "algodão", 36, 10.0, "preta", 25);
            inferiors[this.qtdInferior[0]] = new Inferior("Leg", 25.5, "moletom", "algodão", 36, 10.0, "preta", 25);
            inferiors[this.qtdInferior[0]].editar(inf, pos);
            return true;
        }
        return false;
    }
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

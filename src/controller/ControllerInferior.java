package controller;

import model.Inferior;

public class ControllerInferior {
    private Inferior [] inferiors = new Inferior[50];
    private int [] qtdInferior = new int [1];


    public Inferior getiInferior(int i){
        return this.inferiors[i].getInferior(i);
    }
    public int getqtdCamiseta(){
        return this.qtdInferior[0];
    }

    public void cadastro(String txt){
        Inferior inf = new Inferior("Leg", 25.5, "moletom", "algodão", 36, 10.0, "preta", 25);
        inferiors[qtdInferior[0]] = new Inferior("Leg", 25.5, "moletom", "algodão", 36, 10.0, "preta", 25);
        inferiors[qtdInferior[0]].cadastrar(inf, qtdInferior);
        System.out.println(qtdInferior[0]);
        qtdInferior[0]++;
        System.out.println(qtdInferior[0]);
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
            return true;
        }
        if(i >= 0 && i < qtdInferior[0]){
            Inferior inf;
            inferiors[i].setInferior(null, i); 
            inf = inferiors[i+1].getInferior(i+1);
            inferiors[i].setInferior(inf, i);
            System.out.println("Excluiu");
            return true;
        }
        
        return false;
    }
}

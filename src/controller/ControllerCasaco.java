package controller;

import model.Casaco;

public class ControllerCasaco {
    private Casaco [] casaco = new Casaco[50];
    private int [] qtdCasaco = new int[1];

    public Casaco getCasaco(int i){
        return this.casaco[i].getCasaco(i);
    }
    public int getqtdCasaco(){
        return this.qtdCasaco[0];
    }
    public void cadastro(String txt){
        Casaco ca = new Casaco("MOLETOM", 25.5, "algodao" , true, true, true, "M", 15.0, "azul", 30);
        casaco[qtdCasaco[0]] = new Casaco("MOLETOM", 25.5, "algodao" , true, true, true, "M", 15.0, "azul", 30);
        casaco[qtdCasaco[0]].cadastrar(ca, qtdCasaco);
        System.out.println(qtdCasaco[0]);
        qtdCasaco[0]++;
        System.out.println(qtdCasaco[0]);
    }
    public boolean editar(String[] dados, int pos){
        if(pos >= 0 && pos <=this.qtdCasaco[0]){
            Casaco ca = new Casaco("MOLETOM", 25.5, "algodao" , true, true, true, "M", 15.0, "azul", 30);
            casaco[this.qtdCasaco[0]] = new Casaco("MOLETOM", 25.5, "algodao" , true, true, true, "M", 15.0, "azul", 30);
            casaco[this.qtdCasaco[0]].editar(ca, pos);
            return true;
        }
        return false;
    }
    public boolean excluir(int i){
        if(i == qtdCasaco[0] - 1){
            casaco[i].setCasaco(null, i);
            qtdCasaco[0]--;
            return true;
        }
        if(i >= 0 && i < qtdCasaco[0]){
            Casaco c;
            casaco[i].setCasaco(null, i); 
            c = casaco[i+1].getCasaco(i+1);
            casaco[i].setCasaco(c, i);
            System.out.println("Excluiu");
            qtdCasaco[0]--;
            return true;
        }
        
        return false;
    }

}

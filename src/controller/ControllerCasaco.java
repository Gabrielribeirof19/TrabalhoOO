package controller;

import model.Casaco;

public class ControllerCasaco {
    private Casaco [] casaco = new Casaco[50];
    public int [] qtdCasaco = new int[1];

    public Casaco getCasaco(int i){
        return this.casaco[i].getCasaco(i);
    }
    public int getQtdCasaco(){
        return this.qtdCasaco[0];
    }
    public boolean cadastro (String [] dados){
        Casaco ca = new Casaco(dados[1], Double.parseDouble(dados[2]), dados[10] , Boolean.parseBoolean(dados[8]), Boolean.parseBoolean(dados[7]), Boolean.parseBoolean(dados[9]), dados[3], Double.parseDouble(dados[4]), dados[5], Integer.parseInt(dados[6]));
        casaco[qtdCasaco[0]] = new Casaco("MOLETOM", 25.5, "algodao" , true, true, true, "M", 15.0, "azul", 30);
        casaco[qtdCasaco[0]].cadastrar(ca, qtdCasaco);
        System.out.println(qtdCasaco[0]);
        qtdCasaco[0]++;
        System.out.println(qtdCasaco[0]);
        return true;
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

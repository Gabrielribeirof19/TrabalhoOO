package controller;
import model.*;

public class ControllerCamiseta {
    private Camiseta [] camiseta = new Camiseta[50];
    public int [] qtdCamiseta = new int [1];


    public Camiseta getCamiseta(int i){
        return this.camiseta[i].getCamiseta(i);
    }
    public int getQtdCamiseta(){
        return this.qtdCamiseta[0];
    }

    public boolean cadastro(String [] dados){
        Camiseta ca = new Camiseta(dados[1], Double.parseDouble(dados[2]), dados[3], dados[4], Double.parseDouble(dados[5]), dados[6], Integer.parseInt(dados[7]), Boolean.parseBoolean(dados[8]));
        camiseta[qtdCamiseta[0]] = new Camiseta("tie-dye", 25.0, "M", "polo", 10.0, "preta", 32, true);
        camiseta[qtdCamiseta[0]].cadastrar(ca, qtdCamiseta);
        System.out.println(qtdCamiseta[0]);
        qtdCamiseta[0]++;
        System.out.println(qtdCamiseta[0]);
        return true;
    }
    
    public boolean editar(String[] dados, int pos){
        if(pos >= 0 && pos <=this.qtdCamiseta[0]){
            Camiseta ca = new Camiseta(dados[1], Double.parseDouble(dados[2]), dados[3], dados[4], Double.parseDouble(dados[5]), dados[6], Integer.parseInt(dados[7]), Boolean.parseBoolean(dados[8]));
            camiseta[pos] = new Camiseta("tie-dye", 25.0, "M", "polo", 10.0, "preta", 32, true);
            camiseta[pos].editar(ca, pos);
            return true;
        }
        return false;
    }

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

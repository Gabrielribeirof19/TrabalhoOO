package controller;
import model.*;

public class ControllerCamiseta {
    private Camiseta [] camiseta = new Camiseta[50];
    private int [] qtdCamiseta = new int [1];


    public Camiseta getCamiseta(int i){
        return this.camiseta[i].getCamiseta(i);
    }
    public int getqtdCamiseta(){
        return this.qtdCamiseta[0];
    }

    public void cadastro(String txt){
        Camiseta ca = new Camiseta("tie-dye", 25.0, "M", "polo", 10.0, "preta", 32, true);
        camiseta[qtdCamiseta[0]] = new Camiseta("tie-dye", 25.0, "M", "polo", 10.0, "preta", 32, true);
        camiseta[qtdCamiseta[0]].cadastrar(ca, qtdCamiseta);
        System.out.println(qtdCamiseta[0]);
        qtdCamiseta[0]++;
        System.out.println(qtdCamiseta[0]);
    }
    public boolean editar(String[] dados, int pos){
        if(pos >= 0 && pos <=this.qtdCamiseta[0]){
            Camiseta ca = new Camiseta("tie-dye", 25.0, "M", "polo", 10.0, "preta", 32, true);
            camiseta[this.qtdCamiseta[0]] = new Camiseta("tie-dye", 25.0, "M", "polo", 10.0, "preta", 32, true);
            camiseta[this.qtdCamiseta[0]].editar(ca, pos);
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
            Camiseta c;
            camiseta[i].setCamiseta(null, i); 
            c = camiseta[i+1].getCamiseta(i+1);
            camiseta[i].setCamiseta(c, i);
            System.out.println("Excluiu");
            qtdCamiseta[0]--;
            return true;
        }
        
        return false;
    }

}

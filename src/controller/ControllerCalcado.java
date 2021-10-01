package controller;

import model.*;
public class ControllerCalcado {
    private Calcado[] calcado = new Calcado[50];
    private int[] qtdCalcado = new int[1];

    
    public Calcado getCalcado(int i){
        return this.calcado[i].getCalcado(i);
    }

    public int getQtdCalcado(){
        return this.qtdCalcado[0];
    }

    public void cadastro(String txt){
        Calcado c = new Calcado(txt, 33.4, 40, 4.5, "cor", 4, true, true);
        calcado[qtdCalcado[0]] = new Calcado("Tenis1", 320, 43, 5.4, "Azul", 5, true, true);
        calcado[qtdCalcado[0]].cadastrar(c, qtdCalcado);
        System.out.println(qtdCalcado[0]);
        qtdCalcado[0]++;
        System.out.println(qtdCalcado[0]);
    }

    public boolean editar(String[] dados, int pos){
        if(pos >= 0 && pos <=this.qtdCalcado[0]){
            Calcado c = new Calcado("Tenis1", 33.4, 40, 4.5, "cor", 4, true, true);
            calcado[this.qtdCalcado[0]] = new Calcado("Tenis1", 320, 43, 5.4, "Azul", 5, true, true);
            calcado[this.qtdCalcado[0]].editar(c, pos);
            return true;
        }
        return false;
    }

    public boolean excluir(int i){
        if(i == qtdCalcado[0] - 1){
            calcado[i].setCalcado(null, i);
            qtdCalcado[0]--;
            return true;
        }
        if(i >= 0 && i < qtdCalcado[0]){
            Calcado c;
            calcado[i].setCalcado(null, i); 
            c = calcado[i+1].getCalcado(i+1);
            calcado[i].setCalcado(c, i);
            System.out.println("Excluiu");
            qtdCalcado[0]--;
            return true;
        }
        
        return false;
    }
}

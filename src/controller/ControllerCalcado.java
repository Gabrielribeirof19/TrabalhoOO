package controller;

import model.*;
public class ControllerCalcado {
    private Calcado[] calcado = new Calcado[50];
    public int[] qtdCalcado = new int[1];

    
    public Calcado getCalcado(int i){
        return this.calcado[i].getCalcado(i);
    }

    public int getQtdCalcado(){
        return this.qtdCalcado[0];
    }

    public boolean cadastro(String [] dados ){
        Calcado c = new Calcado(dados[1], Double.parseDouble(dados[2]), Integer.parseInt(dados[3]), Double.parseDouble(dados[4]), dados[5], Integer.parseInt(dados[6]), Boolean.parseBoolean(dados[7]), Boolean.parseBoolean(dados[8]));
        calcado[qtdCalcado[0]] = new Calcado("Tenis1", 320, 43, 5.4, "Azul", 5, true, true);
        calcado[qtdCalcado[0]].cadastrar(c, qtdCalcado);
        System.out.println(qtdCalcado[0]);
        qtdCalcado[0]++;
        System.out.println(qtdCalcado[0]);
        return true;
    }

    public boolean editar(String[] dados, int pos){
        if(pos >= 0 && pos <=this.qtdCalcado[0]){
            Calcado c = new Calcado(dados[1], Double.parseDouble(dados[2]), Integer.parseInt(dados[3]), Double.parseDouble(dados[4]), dados[5], Integer.parseInt(dados[6]), Boolean.parseBoolean(dados[7]), Boolean.parseBoolean(dados[8]));
            calcado[pos] = new Calcado("Tenis1", 320, 43, 5.4, "Azul", 5, true, true);
            calcado[pos].editar(c, pos);
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
            for(int j = i; j < qtdCalcado[0]; j++){    
                    Calcado c;
                    calcado[j].setCalcado(null, j); 
                    c = calcado[j+1].getCalcado(j+1);
                    calcado[j].setCalcado(c, j);
                    System.out.println("Excluiu");
            }
            qtdCalcado[0]--;
            return true;
        }
        
        return false;
    }
}

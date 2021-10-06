package controller;
import model.*;

public class ControllerVenda {
    private Venda[] vendas = new Venda[50];
    public int[] qtdVenda = new int[1];

    
    public Venda getVenda(int i){
        return this.vendas[i].getVenda(i);
    }

    public int getQtdVenda(){
        return this.qtdVenda[0];
    }

    public boolean cadastro(String [] dados){
        Venda v = new Venda("LUCAS", 5, 320, 32, "Calça", 960);
        vendas[qtdVenda[0]] = new Venda("LUCAS", 5, 320, 32, "Calça", 960);
        vendas[qtdVenda[0]].cadastrar(v, qtdVenda);
        System.out.println(qtdVenda[0]);
        qtdVenda[0]++;
        System.out.println(qtdVenda[0]);
        return true;
    }

   

    public boolean cancelar(int i){
        if(i == qtdVenda[0] - 1){
            vendas[i].setVenda(null, i);
            
            return true;
        }
         if(i >= 0 && i < qtdVenda[0]){
            for(int j = i; j < qtdVenda[0]; j++){    
                    Venda v;
                    vendas[j].setVenda(null, j); 
                    v = vendas[j+1].getVenda(j+1);
                    vendas[j].setVenda(v, j);
                    System.out.println("Excluiu");
            }
            qtdVenda[0]--;
            return true;
        }
        
        return false;
    }    
}

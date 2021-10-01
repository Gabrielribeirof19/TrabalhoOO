package controller;
import model.*;

public class ControllerVenda {
    private Venda[] vendas = new Venda[50];
    private int[] qtdVenda = new int[1];

    
    public Venda getVenda(int i){
        return this.vendas[i].getVenda(i);
    }

    public int getqtdVenda(){
        return this.qtdVenda[0];
    }

    public void cadastro(String txt){
        Venda v = new Venda("LUCAS", 5, 320, 32, "Calça", 960);
        vendas[qtdVenda[0]] = new Venda("LUCAS", 5, 320, 32, "Calça", 960);
        vendas[qtdVenda[0]].cadastrar(v, qtdVenda);
        System.out.println(qtdVenda[0]);
        qtdVenda[0]++;
        System.out.println(qtdVenda[0]);
    }

    public boolean editar(String[] dados, int pos){
        if(pos >= 0 && pos <=this.qtdVenda[0]){
            Venda v = new Venda("LUCAS", 5, 320, 32, "Calça", 960);
            vendas[this.qtdVenda[0]] = new Venda("LUCAS", 5, 320, 32, "Calça", 960);
            vendas[this.qtdVenda[0]].editar(v, pos);
            return true;
        }
        return false;
    }

    public boolean excluir(int i){
        if(i == qtdVenda[0] - 1){
            vendas[i].setVenda(null, i);
            return true;
        }
        if(i >= 0 && i < qtdVenda[0]){
            Venda v;
            vendas[i].setVenda(null, i); 
            v = vendas[i+1].getVenda(i+1);
            vendas[i].setVenda(v, i);
            System.out.println("Excluiu");
            return true;
        }
        
        return false;
    }    
}

package controller;
import model.*;

public class ControllerVendedor {
    private Vendedor[] vendedors = new Vendedor[50];
    private int[] qtdVendedor = new int[1];

    
    public Vendedor getvVendedor(int i){
        return this.vendedors[i].getVendedor(i);
    }

    public int getQtdCalcado(){
        return this.qtdVendedor[0];
    }

    public void cadastro(String txt){
        Vendedor c = new Vendedor(256, 28, "cicero", "897875432", new Telefone("61", "902389089"), "akshaskjhadjkahs@gmail.com");
        vendedors[qtdVendedor[0]] = new Vendedor(256, 28, "cicero", "897875432", new Telefone("61", "902389089"), "akshaskjhadjkahs@gmail.com");
        vendedors[qtdVendedor[0]].cadastrar(c, qtdVendedor);
        System.out.println(qtdVendedor[0]);
        qtdVendedor[0]++;
        System.out.println(qtdVendedor[0]);
    }

    public boolean editar(String[] dados, int pos){
        if(pos >= 0 && pos <=this.qtdVendedor[0]){
            Vendedor c = new Vendedor(256, 28, "cicero", "897875432", new Telefone("61", "902389089"), "akshaskjhadjkahs@gmail.com");
            vendedors[this.qtdVendedor[0]] = new Vendedor(256, 28, "cicero", "897875432", new Telefone("61", "902389089"), "akshaskjhadjkahs@gmail.com");
            vendedors[this.qtdVendedor[0]].editar(c, pos);
            return true;
        }
        return false;
    }

    public boolean excluir(int i){
        if(i == qtdVendedor[0] - 1){
            vendedors[i].setVendedor(null, i);
      return true;
        }
        if(i >= 0 && i < qtdVendedor[0]){
            Vendedor v;
            vendedors[i].setVendedor(null, i); 
            v = vendedors[i+1].getVendedor(i+1);
            vendedors[i].setVendedor(v, i);
            System.out.println("Excluiu");
            return true;
        }
        
        return false;
    }    
}

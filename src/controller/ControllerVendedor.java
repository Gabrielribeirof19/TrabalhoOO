package controller;
import model.*;

public class ControllerVendedor {
    private Vendedor[] vendedors = new Vendedor[50];
    public int[] qtdVendedor = new int[1];

    
    public Vendedor getvVendedor(int i){
        return this.vendedors[i].getVendedor(i);
    }

    public int getQtdVendedor(){
        return this.qtdVendedor[0];
    }

    public boolean cadastro(String[] dados){
        Vendedor c = new Vendedor(Integer.parseInt(dados[6]), Integer.parseInt(dados[7]), dados[1], dados[2], new Telefone(dados[4], dados[5]), dados[3]);
        vendedors[qtdVendedor[0]] = new Vendedor(256, 28, "cicero", "897875432", new Telefone("61", "902389089"), "akshaskjhadjkahs@gmail.com");
        vendedors[qtdVendedor[0]].cadastrar(c, qtdVendedor);
        System.out.println(qtdVendedor[0]);
        qtdVendedor[0]++;
        System.out.println(qtdVendedor[0]);
        return true;
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
            qtdVendedor[0]--;
            return true;
        }
        
        if(i >= 0 && i < qtdVendedor[0]){
            for(int j = i; j < qtdVendedor[0]; j++){    
                    Vendedor v;
                    vendedors[j].setVendedor(null, j); 
                    v = vendedors[j+1].getVendedor(j+1);
                    vendedors[j].setVendedor(v, j);
                    System.out.println("Excluiu");
            }
            qtdVendedor[0]--;
            return true;
        }
        return false;
    }    
}

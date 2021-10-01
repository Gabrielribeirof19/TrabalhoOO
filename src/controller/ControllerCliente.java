package controller;
import model.*;

public class ControllerCliente {
    private Cliente [] cliente = new Cliente[50];
    private int [] qtdCliente = new int [1];

    public Cliente getCliente(int i){
        return this.cliente[i].getCliente(i);
    }

    public int getQtdCliente(){
        return this.qtdCliente[0];
    }

    public void cadastro(String txt){
        Cliente c = new Cliente("Cicero", "687684313", new Endereco(256456, "bairro", "complemento", "endereco"), 25.80, "cicerogay@gmail.com", new Telefone("61", "902389089"));
        cliente[qtdCliente[0]] = new Cliente("Cicero", "687684313", new Endereco(256456, "bairro", "complemento", "endereco"), 25.80, "cicerogay@gmail.com", new Telefone("61", "902389089"));
        cliente[qtdCliente[0]].cadastrar(c, qtdCliente);
        System.out.println(qtdCliente[0]);
        qtdCliente[0]++;
        System.out.println(qtdCliente[0]);
    }

    public boolean editar(String[] dados, int pos){
        if(pos >= 0 && pos <=this.qtdCliente[0]){
            Cliente c = new Cliente("Cicero", "687684313", new Endereco(256456, "bairro", "complemento", "endereco"), 25.80, "cicerogay@gmail.com", new Telefone("61", "902389089"));
            cliente[this.qtdCliente[0]] = new Cliente("Cicero", "687684313", new Endereco(256456, "bairro", "complemento", "endereco"), 25.80, "cicerogay@gmail.com", new Telefone("61", "902389089"));
            cliente[this.qtdCliente[0]].editar(c, pos);
            return true;
        }
        return false;
    }

    public boolean excluir(int i){
        if(i == qtdCliente[0] - 1){
            cliente[i].setCliente(null, i);
      return true;
        }
        if(i >= 0 && i < qtdCliente[0]){
            Cliente c;
            cliente[i].setCliente(null, i); 
            c = cliente[i+1].getCliente(i+1);
            cliente[i].setCliente(c, i);
            System.out.println("Excluiu");
            return true;
        }
        
        return false;
    } 

    
}

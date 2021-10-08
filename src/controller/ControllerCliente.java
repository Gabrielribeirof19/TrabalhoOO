package controller;
import model.*;

public class ControllerCliente {
    private Cliente [] cliente = new Cliente[50];
    public int [] qtdCliente = new int [1];

    public Cliente getCliente(int i){
        return this.cliente[i].getCliente(i);
    }

    public int getQtdCliente(){
        return this.qtdCliente[0];
    }

    public boolean cadastro(String[] dados){
        Cliente c = new Cliente(dados[1], dados[2], new Endereco(Integer.parseInt(dados[7]), dados[8], dados[9], dados[6]), Double.parseDouble(dados[10]), dados[3], new Telefone(dados[4], dados[5]));
        cliente[qtdCliente[0]] = new Cliente("Cicero", "687684313", new Endereco(256456, "bairro", "complemento", "endereco"), 25.80, "cicero@gmail.com", new Telefone("61", "902389089"));
        cliente[qtdCliente[0]].cadastrar(c, qtdCliente);
        System.out.println(qtdCliente[0]);
        qtdCliente[0]++;
        System.out.println(qtdCliente[0]);
        return true;
    }

    public boolean editar(String[] dados, int pos){
        if(pos >= 0 && pos <=this.qtdCliente[0]){
            Cliente c = new Cliente(dados[1], dados[2], new Endereco(Integer.parseInt(dados[7]), dados[8], dados[9], dados[6]), Double.parseDouble(dados[10]), dados[3], new Telefone(dados[4], dados[5]));
            cliente[pos] = new Cliente("Cicero", "687684313", new Endereco(256456, "bairro", "complemento", "endereco"), 25.80, "cicero@gmail.com", new Telefone("61", "902389089"));
            cliente[pos].editar(c, pos);
            return true;
        }
        return false;
    }

    public boolean excluir(int i){
        if(i == qtdCliente[0] - 1){
            cliente[i].setCliente(null, i);
            qtdCliente[0]--;
        return true;
        }
         if(i >= 0 && i < qtdCliente[0]){
            for(int j = i; j < qtdCliente[0]; j++){    
                    Cliente c;
                    cliente[j].setCliente(null, j); 
                    c = cliente[j+1].getCliente(j+1);
                    cliente[j].setCliente(c, j);
                    System.out.println("Excluiu");
            }
            qtdCliente[0]--;
            return true;
        }
        
        return false;
    } 

    
}

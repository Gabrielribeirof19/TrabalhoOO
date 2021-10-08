package controller;
import model.*;

/**
 * Trabalha os dados da classe Cliente feita no model.
 * @author Cícero Fernandes
 * @author Gabriel de Souza
 * @version 1.0 (out 2021)
 */
public class ControllerCliente {
    private Cliente [] cliente = new Cliente[50];
    public int [] qtdCliente = new int [1];

    /**
     * Carrega um dado do tipo Cliente vindo do model Cliente
     * @param i Posição do objeto que você quer buscar
     * @return Objeto do tipo Cliente carregado do model
     */
    public Cliente getCliente(int i){
        return this.cliente[i].getCliente(i);
    }

    /**
     * Retorna a quantidade de clientes cadastrados
     * @return Quantidade de Cliente cadastrado
     */
    public int getQtdCliente(){
        return this.qtdCliente[0];
    }

    /**
     * Cadastra um objeto do tipo Cliente no model.
     * @param dados Lista de String contendo os dados para inicializar o objeto a ser cadastrado
     * @return retorna verdadeiro ou falso, indicando se o cadastro foi feito com sucesso ou não
     */
    public boolean cadastro(String[] dados){
        Cliente c = new Cliente(dados[1], dados[2], new Endereco(Integer.parseInt(dados[7]), dados[8], dados[9], dados[6]), Double.parseDouble(dados[10]), dados[3], new Telefone(dados[4], dados[5]));
        cliente[qtdCliente[0]] = new Cliente("Cicero", "687684313", new Endereco(256456, "bairro", "complemento", "endereco"), 25.80, "cicero@gmail.com", new Telefone("61", "902389089"));
        cliente[qtdCliente[0]].cadastrar(c, qtdCliente);
        System.out.println(qtdCliente[0]);
        qtdCliente[0]++;
        System.out.println(qtdCliente[0]);
        return true;
    }

    /**
     * Editar um objeto do tipo Casado no model.
     * @param dados Lista de String contendo os dados para editar o objeto cadastrado
     * @param pos Posição do objeto na model que será editado.
     * @return retorna verdadeiro ou falso, indicando se a edição foi feita com sucesso ou não
     */
    public boolean editar(String[] dados, int pos){
        if(pos >= 0 && pos <=this.qtdCliente[0]){
            Cliente c = new Cliente(dados[1], dados[2], new Endereco(Integer.parseInt(dados[7]), dados[8], dados[9], dados[6]), Double.parseDouble(dados[10]), dados[3], new Telefone(dados[4], dados[5]));
            cliente[pos] = new Cliente("Cicero", "687684313", new Endereco(256456, "bairro", "complemento", "endereco"), 25.80, "cicero@gmail.com", new Telefone("61", "902389089"));
            cliente[pos].editar(c, pos);
            return true;
        }
        return false;
    }

    /**
     * Exclui um objeto do tipo Cliente na posição indicada
     * @param i Posição a ser excluída 
     * @return Retorna verdadeiro ou falso, indicando se a exclusão foi feita com sucesso ou não
     */
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

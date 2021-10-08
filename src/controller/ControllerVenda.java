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

    public boolean cadastro(String [] dados, ControllerCliente cliente, ControllerCalcado calcado, ControllerInferior inf, ControllerCasaco casaco, ControllerVendedor vendedor, ControllerCamiseta camiseta){
        boolean flagCliente = false;
        boolean flagVendedor = false;
        boolean flagProduto = false;
        int idCliente = 0;
        int idVendedor = 0;
        int idProduto = 0;
        String op = "NotFind";

        System.out.println(dados[2]);

        for(int i = 0; i < cliente.qtdCliente[0]; i++){
            System.out.println(cliente.getCliente(i).getNome());
            if(dados[1].equals(cliente.getCliente(i).getNome())){
                System.out.println("Achou cliente");
                flagCliente = true;
                idCliente = i;
                break;
            }
        }

        for(int i = 0; i < vendedor.qtdVendedor[0]; i++){
            if(Integer.parseInt(dados[3]) == vendedor.getvVendedor(i).getId()){
                System.out.println("Achou vendedor");
                flagVendedor = true;
                idVendedor = i;
                break;
            }
        }

        for (int i = 0; i < calcado.getQtdCalcado(); i++){
            if(dados[2].equals(calcado.getCalcado(i).getNome())){
                System.out.println(dados[2] + " "+calcado.getCalcado(i).getNome());
                flagProduto = true;
                idProduto = i;
                op = "cal";
                break;
            }
        }

        if (!flagProduto){
            for (int i = 0; i < casaco.getQtdCasaco(); i++){
                if(dados[2].equals(casaco.getCasaco(i).getNome())){
                    flagProduto = true;
                    idProduto = i;
                    op = "cas";
                    break;
                }
            }
        }

        if(!flagProduto){
            for (int i = 0; i < camiseta.getQtdCamiseta(); i++){
                if(dados[2].equals(camiseta.getCamiseta(i).getNome())){
                    flagProduto = true;
                    idProduto = i;
                    op = "cam";
                    break;
                }
            }
        }

        if(!flagProduto){
            for (int i = 0; i < inf.getQtdInferior(); i++){
                if(dados[2].equals(inf.getiInferior(i).getNome())){
                    flagProduto = true;
                    idProduto = i;
                    op = "inf";
                    break;
                }
            }
        }

        System.out.println("FLAPRODUTO: "+ flagProduto);
        System.out.println("FLACLIENTE: "+ flagCliente);
        System.out.println("FLAVENDEDOR: "+ flagVendedor);
        System.out.println(dados[1]);        
        System.out.println(dados[2]);
        System.out.println(cliente.getCliente(0).getNome());




        if(flagCliente && flagVendedor && flagProduto){
            switch(op){
                case "cal":
                    Venda v = new Venda(dados[1], Integer.parseInt(dados[3]), calcado.getCalcado(idProduto).getPreco(), calcado.getCalcado(idProduto).getPorcentagem(), dados[2], Integer.parseInt(dados[3]));
                    vendas[qtdVenda[0]] = new Venda("LUCAS", 5, 320, 32, "Calça", 960);
                    vendas[qtdVenda[0]].cadastrar(v, qtdVenda);
                    System.out.println(qtdVenda[0]);
                    qtdVenda[0]++;
                    System.out.println(qtdVenda[0]);

                    //MUDANDO CASH DO CLIENTE
                    double cashAntigo = cliente.getCliente(idCliente).getCasback();
                    double cash = (calcado.getCalcado(idProduto).getPorcentagem()/100) * calcado.getCalcado(idProduto).getPreco();
                    cliente.getCliente(idCliente).setCashback(cash + cashAntigo);

                    //DIMINUINDO ESTOQUE
                    int estoque = calcado.getCalcado(idProduto).getEstoque();
                    calcado.getCalcado(idProduto).setEstoque(estoque - 1);

                    //AUMENTANDO Nº VENDA DO VENDEDOR
                    int numeroVendas = vendedor.getvVendedor(idVendedor).getNumVenda();
                    vendedor.getvVendedor(idVendedor).setNumVenda(numeroVendas + 1);
                    
                    return true;

                case "cas":
                    Venda v1 = new Venda(dados[1], Integer.parseInt(dados[3]), casaco.getCasaco(idProduto).getPreco(), casaco.getCasaco(idProduto).getPorcentagem(), dados[2], Integer.parseInt(dados[3]));
                    vendas[qtdVenda[0]] = new Venda("LUCAS", 5, 320, 32, "Calça", 960);
                    vendas[qtdVenda[0]].cadastrar(v1, qtdVenda);
                    System.out.println(qtdVenda[0]);
                    qtdVenda[0]++;
                    System.out.println(qtdVenda[0]);
                    
                    //MUDANDO CASH DO CLIENTE
                    double cashAntigo1 = cliente.getCliente(idCliente).getCasback();
                    double cash1 = (casaco.getCasaco(idProduto).getPorcentagem()/100) * casaco.getCasaco(idProduto).getPreco();
                    cliente.getCliente(idCliente).setCashback(cash1 + cashAntigo1);

                    //DIMINUINDO O ESTOQUE 
                    int estoque1 = casaco.getCasaco(idProduto).getEstoque();
                    casaco.getCasaco(idProduto).setEstoque(estoque1 -1);
                    
                    //AUMENTANDO Nº VENDA DO VENDEDOR
                    int numeroVendas1 = vendedor.getvVendedor(idVendedor).getNumVenda();
                    vendedor.getvVendedor(idVendedor).setNumVenda(numeroVendas1 + 1);
                    
                    return true;

                case "cam":
                    Venda v2 = new Venda(dados[1], Integer.parseInt(dados[3]), camiseta.getCamiseta(idProduto).getPreco(), camiseta.getCamiseta(idProduto).getPorcentagem(), dados[2], Integer.parseInt(dados[3]));
                    vendas[qtdVenda[0]] = new Venda("LUCAS", 5, 320, 32, "Calça", 960);
                    vendas[qtdVenda[0]].cadastrar(v2, qtdVenda);
                    System.out.println(qtdVenda[0]);
                    qtdVenda[0]++;
                    System.out.println(qtdVenda[0]);
                    
                    //MUDANDO CASH DO CLIENTE
                    double cashAntigo2 = cliente.getCliente(idCliente).getCasback();
                    double cash2 = (camiseta.getCamiseta(idProduto).getPorcentagem()/100) * camiseta.getCamiseta(idProduto).getPreco();
                    cliente.getCliente(idCliente).setCashback(cash2 + cashAntigo2);

                    //DIMINUINDO O ESTOQUE
                    int estoque2 = camiseta.getCamiseta(idProduto).getEstoque();
                    camiseta.getCamiseta(idProduto).setEstoque(estoque2 -1);
                    
                    //AUMENTANDO Nº VENDA DO VENDEDOR
                    int numeroVendas2 = vendedor.getvVendedor(idVendedor).getNumVenda();
                    vendedor.getvVendedor(idVendedor).setNumVenda(numeroVendas2 + 1);

                    return true;

                case "inf":
                    Venda v3 = new Venda(dados[1], Integer.parseInt(dados[3]), inf.getiInferior(idProduto).getPreco(), inf.getiInferior(idProduto).getPorcentagem(), dados[2], Integer.parseInt(dados[3]));
                    vendas[qtdVenda[0]] = new Venda("LUCAS", 5, 320, 32, "Calça", 960);
                    vendas[qtdVenda[0]].cadastrar(v3, qtdVenda);
                    System.out.println(qtdVenda[0]);
                    qtdVenda[0]++;
                    System.out.println(qtdVenda[0]);
                    
                    //MUDANDO CASH DO CLIENTE
                    double cashAntigo3 = cliente.getCliente(idCliente).getCasback();
                    double cash3 = (inf.getiInferior(idProduto).getPorcentagem()/100) * inf.getiInferior(idProduto).getPreco();
                    cliente.getCliente(idCliente).setCashback(cash3 + cashAntigo3);

                    //DIMINUINDO O ESTOQUE
                    int estoque3 = inf.getiInferior(idProduto).getEstoque();
                    inf.getiInferior(idProduto).setEstoque(estoque3 -1);
                    
                    //AUMENTANDO Nº VENDA DO VENDEDOR
                    int numeroVendas3 = vendedor.getvVendedor(idVendedor).getNumVenda();
                    vendedor.getvVendedor(idVendedor).setNumVenda(numeroVendas3 + 1);
                    
                    return true;
                default:
                    System.out.println("Nao existe produto");
            }
        };

        return false;

    }

    public boolean cancelar(int i){
        if(i == qtdVenda[0] - 1){
            vendas[i].setVenda(null, i);
            qtdVenda[0]--;
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

package model;
import controller.*;
public class Teste {
    static ControllerCalcado calcado;
    static Camiseta c;
    static Venda v;
    static Cliente cliente;
    static Vendedor vendedor;
    static Endereco e;

    public static void main(String[] args){
        calcado = new ControllerCalcado();
        // c = new Camiseta("Camiseta de manga longa", 34.6, "M", "gola V");
        // v = new Venda("Arnaldo", 4);

        // e = new Endereco();
        // e.setCEP(71918360);
        // e.setBairo("Aguas claras");
        // e.setComplemento("Residencial life residence");
        // e.setEndereco("rua 31 norte lote 3");

        // cliente = new Cliente(e, 5.6);
        //cliente.setNome("Fernando");

        // vendedor = new Vendedor(4, 324235, "Sérgio");

        // System.out.println(c.toString());
        // System.out.println(v.toString());
        // System.out.println("CLIENTE - "+cliente.toString());
        // System.out.println("VENDEDOR - "+vendedor.toString());
        calcado.cadastro("Carlos");
        System.out.println(calcado.getCalcado(0).getNome());
        calcado.cadastro("Pedro");
        System.out.println(calcado.getCalcado(1).getNome());
        calcado.excluir(1);
        System.out.println(calcado.getCalcado(0).getNome());
    }
    
}

//kkkkkkkkkkkkkkk só comenta sim
package classes;

public class Telefone {
    private String DDD;
    private String numero;
    
    
    public Telefone(String codigo, String num){
        DDD = codigo;
        numero = num;
    }

    @Override
    public String toString(){
        return "telefone: (" + DDD +")" + numero;
    }

    public String getDDD(){
        return DDD;
    }

    public void setDDD(String ddd){
        this.DDD = ddd;
    }

    public String getNumero(){
        return numero;
    }
    
    public void setNumero(String num){
        this.numero = num;
    }
}
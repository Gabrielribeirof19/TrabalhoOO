package classes;

public class Endereco{
    private int CEP;
    private String bairro;
    private String complemento;
    private String endereco;

    public int getCEP(){
        return CEP;
    }
    public void setCEP(int cep){
        this.CEP = cep;
    }
    public String getBairro(){
        return bairro;
    }
    public void setBairoo(String Bairro){
        this.bairro = Bairro;
    }
    public String getComplemento(){
        return complemento;
    } 
    public void setComplemento(String compl){
        this.complemento = compl;
    }
    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String end){
        this.endereco = end;
    }

}
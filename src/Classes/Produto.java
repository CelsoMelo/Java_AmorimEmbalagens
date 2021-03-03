package Classes;

public class Produto {
    
    private int cod;
    private String desc;
    private double quant;
    private String unidade;
    private double precAtac;

    public int getCod() {
        return cod;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getQuant() {
        return quant;
    }

    public void setQuant(double quant) {
        this.quant = quant;
    }

    public double getPrecAtac() {
        return precAtac;
    }

    public void setPrecAtac(double precAtac) {
        this.precAtac = precAtac;
    }
      
}

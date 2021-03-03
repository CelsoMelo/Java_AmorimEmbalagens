package Classes;

public class ItemCompra {
    
    private int codItem;
    private String unidade;
    //private double precUnit;
    private double precTotal;
    private double quantItem;
    private int produto;
    private int compra;

    public int getCodItem() {
        return codItem;
    }

    public void setCodItem(int codItem) {
        this.codItem = codItem;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    /*public double getPrecUnit() {
        return precUnit;
    }

    public void setPrecUnit(double precUnit) {
        this.precUnit = precUnit;
    }*/

    public double getPrecTotal() {
        return precTotal;
    }

    public void setPrecTotal(double precTotal) {
        this.precTotal = precTotal;
    }

    public double getQuantItem() {
        return quantItem;
    }

    public void setQuantItem(double quantItem) {
        this.quantItem = quantItem;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public int getCompra() {
        return compra;
    }

    public void setCompra(int compra) {
        this.compra = compra;
    }
      
    
    
}

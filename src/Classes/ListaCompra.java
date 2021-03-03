package Classes;

public class ListaCompra {
    
    int codCompra, codProd, codItem;
    String descProd;
    double precProd;
    double quantProd;
    String unidProd;

    public int getCodItem() {
        return codItem;
    }

    public void setCodItem(int codItem) {
        this.codItem = codItem;
    }

    public int getCodCompra() {
        return codCompra;
    }

    public void setCodCompra(int codCompra) {
        this.codCompra = codCompra;
    }

    public int getCodProd() {
        return codProd;
    }

    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

    public String getDescProd() {
        return descProd;
    }

    public void setDescProd(String descProd) {
        this.descProd = descProd;
    }

    public double getPrecProd() {
        return precProd;
    }

    public void setPrecProd(double precProd) {
        this.precProd = precProd;
    }

    public double getQuantProd() {
        return quantProd;
    }

    public void setQuantProd(double quantProd) {
        this.quantProd = quantProd;
    }

    public String getUnidProd() {
        return unidProd;
    }

    public void setUnidProd(String unidProd) {
        this.unidProd = unidProd;
    }
    
}

package Classes;

/*
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
*/

public class Compra {
    
    private int cod;
    private String data;
    private String pagForm;
    private double vlrTot;


    public String getPagForm() {
        return pagForm;
    }

    public void setPagForm(String pagForm) {
        this.pagForm = pagForm;
    }
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getData() {
        /*
        SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dataF = null;
        try {
            dataF = dtf.parse(dtf.format(data));
        } catch (ParseException ex) {
            Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataF;
        */
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getVlrTot() {
        return vlrTot;
    }

    public void setVlrTot(double vlrTot) {
        this.vlrTot = vlrTot;
    }
    
}

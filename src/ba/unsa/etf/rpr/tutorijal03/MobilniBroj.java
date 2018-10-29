package ba.unsa.etf.rpr.tutorijal03;

public class MobilniBroj extends TelefonskiBroj {

    private int mobilnaMreza;
    private String broj;

    public int getMobilnaMreza() {
        return mobilnaMreza;
    }

    public String getBroj() {
        return broj;
    }

    public void setMobilnaMreza(int mobilnaMreza) {
        this.mobilnaMreza = mobilnaMreza;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }
}

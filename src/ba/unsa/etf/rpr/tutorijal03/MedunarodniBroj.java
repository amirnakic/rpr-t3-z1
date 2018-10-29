package ba.unsa.etf.rpr.tutorijal03;

public class MedunarodniBroj extends TelefonskiBroj {
    private String drzava, broj;

    public String getDrzava() {
        return drzava;
    }

    public String getBroj() {
        return broj;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }
}

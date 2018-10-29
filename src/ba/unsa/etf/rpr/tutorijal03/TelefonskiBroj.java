package ba.unsa.etf.rpr.tutorijal03;

public abstract class TelefonskiBroj {

    protected String broj;

    TelefonskiBroj() {
        broj = "Nepoznat broj";
    }

    public abstract String ispisi();
}

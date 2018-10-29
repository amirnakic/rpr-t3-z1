package ba.unsa.etf.rpr.tutorijal03;

public class FiksniBroj extends TelefonskiBroj {
    public enum Grad {
        TRAVNIK(30), ORASJE(31), ZENICA(32), SARAJEVO(33), LIVNO(34), TUZLA(35),
        MOSTAR(36), BIHAC(37), GORAZDE(38), POSUSJE(39), BRCKO(49);
        private final int pozivniBroj;

        Grad(int pozivniBroj) {
            this.pozivniBroj = pozivniBroj;
        }
    }

    private String broj;
    private Grad grad;
}

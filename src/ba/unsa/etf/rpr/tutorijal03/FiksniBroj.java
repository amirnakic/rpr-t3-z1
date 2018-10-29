package ba.unsa.etf.rpr.tutorijal03;

public class FiksniBroj extends TelefonskiBroj {

    private String broj;
    private Grad grad;

    public enum Grad {
        TRAVNIK(30), ORASJE(31), ZENICA(32), SARAJEVO(33), LIVNO(34), TUZLA(35),
        MOSTAR(36), BIHAC(37), GORAZDE(38), POSUSJE(39), BRCKO(49);
        private final int pozivniBroj;

        Grad(int pozivniBroj) {
            this.pozivniBroj = pozivniBroj;
        }

        public int getPozivniBroj() {
            return pozivniBroj;
        }
    }

    public FiksniBroj(Grad grad, String broj) {
        setGrad(grad);
        setBroj(broj);
    }

    public String getBroj() {
        return broj;
    }

    public Grad getGrad() {
        return grad;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
    }

    @Override
    public String ispisi() {
        return "0" + getGrad().getPozivniBroj() + "/" + getBroj();
    }
}

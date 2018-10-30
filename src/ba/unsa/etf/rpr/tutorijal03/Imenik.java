package ba.unsa.etf.rpr.tutorijal03;

import java.util.HashMap;

public class Imenik {
    private HashMap<String, TelefonskiBroj> imenik;

    public Imenik() {
        this.imenik = new HashMap<>();
    }

    public HashMap<String, TelefonskiBroj> getImenik() {
        return imenik;
    }

    public void dodaj(String ime, TelefonskiBroj broj) {
        getImenik().put(ime, broj);
    }

    public String dajBroj(String ime) {
        return getImenik().get(ime).ispisi();
    }

    public String dajIme(TelefonskiBroj broj) {
        return getImenik().get(broj).toString();
    }

    public String naSlovo(char s) {
        int brojac = 0;
        String rezultat = "";
        for (String ime : getImenik().keySet())
            if (ime.indexOf(s) == 0) {
                rezultat = brojac + 1 + ". " + ime + " - " + dajBroj(ime) + "\n";
                brojac++;
            }
        return rezultat;
    }

    
}
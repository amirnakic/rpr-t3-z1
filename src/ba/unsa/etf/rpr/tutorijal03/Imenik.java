package ba.unsa.etf.rpr.tutorijal03;

import java.util.*;

public class Imenik {
    private HashMap<String, TelefonskiBroj> imenik;

    public Imenik() {
        this.imenik = new HashMap<>();
    }

    public HashMap<String, TelefonskiBroj> getImenik() {
        return imenik;
    }

    public void dodaj(String ime, TelefonskiBroj broj) throws IllegalArgumentException {
        if (dajIme(broj) == null)
            getImenik().put(ime, broj);
        else throw new IllegalArgumentException("Broj se vec nalazi unutar imenika.");
    }

    public String dajBroj(String ime) throws NullPointerException {
        if (getImenik().get(ime) == null)
            throw new NullPointerException("Broj nije pronadjen, jer korisnik pod imenom " + ime + " nije dodan u imenik.");
        return getImenik().get(ime).ispisi();
    }

    public String dajIme(TelefonskiBroj broj) {
        for (String ime : getImenik().keySet())
            if (dajBroj(ime).equals(broj.ispisi()))
                return ime;
        return null;
    }

    public String naSlovo(char s) throws IllegalArgumentException {
        int brojac = 0;
        String rezultat = null;
        for (String ime : getImenik().keySet())
            if (ime.indexOf(s) == 0) {
                rezultat = brojac + 1 + ". " + ime + " - " + dajBroj(ime) + "\n";
                brojac++;
            }
        if (rezultat == null)
            throw new IllegalArgumentException("Unutar imenika nema korisnika sa pocetnim slovom " + s + ".");
        return rezultat;
    }

    Set<String> izGrada(FiksniBroj.Grad g) {
        TreeSet<String> rezultat = new TreeSet<>();
        for (String ime : getImenik().keySet())
            if (getImenik().get(ime).hashCode() == g.getPozivniBroj()) rezultat.add(ime);
        return rezultat;
    }

    Set<TelefonskiBroj> izGradaBrojevi(FiksniBroj.Grad g) {
        TreeSet<TelefonskiBroj> rezultat = new TreeSet<>();
        for (String ime : getImenik().keySet())
            if (getImenik().get(ime).hashCode() == g.getPozivniBroj()) rezultat.add(getImenik().get(ime));
        return rezultat;
    }
}
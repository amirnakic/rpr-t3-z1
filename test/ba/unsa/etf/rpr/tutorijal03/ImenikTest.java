package ba.unsa.etf.rpr.tutorijal03;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static ba.unsa.etf.rpr.tutorijal03.FiksniBroj.Grad.*;
import static org.junit.jupiter.api.Assertions.*;

class ImenikTest {

    @Test
    void dodaj() {
        Imenik imenik = new Imenik();
        imenik.dodaj("John Smith", new MedunarodniBroj("+1", "23 45-67-89"));
        imenik.dodaj("Hana Hanic", new FiksniBroj(SARAJEVO, "123-156"));
        imenik.dodaj("Meho Mehic", new FiksniBroj(SARAJEVO, "123-456"));
        assertEquals("033/123-456", imenik.dajBroj("Meho Mehic"));
    }

    @Test
    void dodaj1() { //pokusaj ponovnog dodavanja ranije unesenog broja
        Imenik imenik = new Imenik();
        imenik.dodaj("Amir Nakic", new FiksniBroj(ZENICA, "246-860"));
        assertThrows(IllegalArgumentException.class, () -> {
            imenik.dodaj("Amir Nakic", new FiksniBroj(ZENICA, "246-860"));
        });
    }

    @Test
    void dajBroj() { //trazenje broja korisnika cijeg imena nema u imeniku
        Imenik imenik = new Imenik();
        imenik.dodaj("Amir Nakic", new MobilniBroj(62, "911-818"));
        assertThrows(NullPointerException.class, () -> {
            imenik.dajBroj("Ibrahim Alispahic");
        });
    }

    @Test
    void dajIme() {
        Imenik imenik = new Imenik();
        imenik.dodaj("Amir Nakic", new MobilniBroj(62, "911-818"));
        TelefonskiBroj tb = new MobilniBroj(62, "911-818");
        assertEquals("Amir Nakic", imenik.dajIme(tb));
    }

    @Test
    void dajIme1() { //trazenje korisnika cijeg broja nema u imeniku
        Imenik imenik = new Imenik();
        TelefonskiBroj tb = new MobilniBroj(62, "911-818");
        assertNull(imenik.dajIme(tb));
    }

    @Test
    void naSlovo() {
        Imenik imenik = new Imenik();
        imenik.dodaj("Sara Sarac", new FiksniBroj(SARAJEVO, "123-156"));
        imenik.dodaj("Pero Peric", new FiksniBroj(SARAJEVO, "123-656"));
        imenik.dodaj("Ivo Ivic", new MobilniBroj(61, "321-645"));
        imenik.dodaj("Jozo Jozic", new MobilniBroj(64, "987-654"));
        imenik.dodaj("John Smith", new MedunarodniBroj("+1", "23 45-67-89"));
        assertEquals("1. Ivo Ivic - 061/321-645", imenik.naSlovo('I').trim());
    }

    @Test
    void naSlovo1() {
        Imenik imenik = new Imenik();
        imenik.dodaj("Sara Sarac", new FiksniBroj(SARAJEVO, "123-156"));
        imenik.dodaj("Pero Peric", new FiksniBroj(SARAJEVO, "123-656"));
        imenik.dodaj("Ivo Ivic", new MobilniBroj(61, "321-645"));
        imenik.dodaj("Jozo Jozic", new MobilniBroj(64, "987-654"));
        imenik.dodaj("John Smith", new MedunarodniBroj("+1", "23 45-67-89"));
        assertThrows(IllegalArgumentException.class, () -> {
            imenik.naSlovo('A');
        });
    }

    @Test
    void izGrada() {
        Imenik imenik = new Imenik();
        imenik.dodaj("Ivo Ivic", new FiksniBroj(SARAJEVO, "123-456"));
        imenik.dodaj("Sara Sarac", new FiksniBroj(SARAJEVO, "123-156"));
        imenik.dodaj("Meho Mehic", new FiksniBroj(SARAJEVO, "123-656"));
        imenik.dodaj("Pero Peric", new MobilniBroj(64, "987-654"));
        imenik.dodaj("John Smith", new MedunarodniBroj("+1", "23 45-67-89"));
        Set<String> set = imenik.izGrada(SARAJEVO);
        String result = "";
        for (String ime : set) {
            result += ime + ",";
        }
        assertEquals("Ivo Ivic,Meho Mehic,Sara Sarac,", result);
    }

    @Test
    void izGrada1() {
        Imenik imenik = new Imenik();
        imenik.dodaj("Ivo Ivic", new FiksniBroj(BRCKO, "123-456"));
        imenik.dodaj("Sara Sarac", new FiksniBroj(BIHAC, "123-156"));
        imenik.dodaj("Amir Nakic", new FiksniBroj(ZENICA, "123-656"));
        imenik.dodaj("Amel Nakic", new MobilniBroj(64, "987-654"));
        imenik.dodaj("Mirha Nakic", new MedunarodniBroj("+1", "23 45-67-89"));
        Set<String> set = imenik.izGrada(ZENICA);
        String result = "";
        for (String ime : set) {
            result += ime;
        }
        assertEquals("Amir Nakic", result);
    }

    @Test
    void izGrada2() {
        Imenik imenik = new Imenik();
        imenik.dodaj("Ivo Ivic", new FiksniBroj(BRCKO, "123-456"));
        imenik.dodaj("Sara Sarac", new FiksniBroj(BIHAC, "123-156"));
        imenik.dodaj("Amir Nakic", new FiksniBroj(ZENICA, "123-656"));
        imenik.dodaj("Amel Nakic", new MobilniBroj(64, "987-654"));
        imenik.dodaj("Mirha Nakic", new MedunarodniBroj("+1", "23 45-67-89"));
        assertThrows(IllegalArgumentException.class, () -> imenik.izGrada(SARAJEVO));
    }

    @Test
    void izGradaBrojevi() {
        Imenik imenik = new Imenik();
        imenik.dodaj("Ivo Ivic", new FiksniBroj(SARAJEVO, "123-456"));
        imenik.dodaj("Sara Sarac", new FiksniBroj(SARAJEVO, "123-156"));
        imenik.dodaj("Meho Mehic", new FiksniBroj(SARAJEVO, "123-656"));
        imenik.dodaj("Pero Peric", new MobilniBroj(64, "987-654"));
        imenik.dodaj("John Smith", new MedunarodniBroj("+1", "23 45-67-89"));
        Set<TelefonskiBroj> set = imenik.izGradaBrojevi(SARAJEVO);
        String result = "";
        for (TelefonskiBroj broj : set) {
            result += broj.ispisi() + ",";
        }
        assertEquals("033/123-156,033/123-456,033/123-656,", result);
    }

    @Test
    void izGradaBrojevi1() {
        Imenik imenik = new Imenik();
        imenik.dodaj("Ivo Ivic", new FiksniBroj(LIVNO, "123-456"));
        imenik.dodaj("Sara Sarac", new FiksniBroj(SARAJEVO, "123-156"));
        imenik.dodaj("Meho Mehic", new FiksniBroj(ZENICA, "123-656"));
        imenik.dodaj("Pero Peric", new MobilniBroj(64, "987-654"));
        imenik.dodaj("John Smith", new MedunarodniBroj("+1", "23 45-67-89"));
        Set<TelefonskiBroj> set = imenik.izGradaBrojevi(SARAJEVO);
        String result = "";
        for (TelefonskiBroj broj : set) {
            result += broj.ispisi();
        }
        assertEquals("033/123-156", result);
    }

    @Test
    void izGradaBrojevi2() {
        Imenik imenik = new Imenik();
        imenik.dodaj("Ivo Ivic", new FiksniBroj(LIVNO, "123-456"));
        imenik.dodaj("Sara Sarac", new FiksniBroj(SARAJEVO, "123-156"));
        imenik.dodaj("Meho Mehic", new FiksniBroj(ZENICA, "123-656"));
        assertThrows(IllegalArgumentException.class, () -> imenik.izGradaBrojevi(BIHAC));
    }
}
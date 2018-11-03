package ba.unsa.etf.rpr.tutorijal03;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        boolean istina = true;
        Imenik imenik = new Imenik();
        String imeIPrezime = new String();
        String grad = new String();
        String broj = new String();
        String drzava = new String();
        int mobilnaMreza;
        while (istina) {
            System.out.println("-----ETF - Telefonski imenik-----");
            System.out.println("Izaberite koju opciju želite:");
            System.out.println(" 0 - Prekini program");
            System.out.println(" 1 - Dodaj broj");
            System.out.println(" 2 - Pronađi broj na osnovu imena korisnika");
            System.out.println(" 3 - Pronađi korisnika na osnovu broja");
            System.out.println(" 4 - Ispiši korisnike sa unesenim početnim slovom");
            System.out.println(" 5 - Ispiši korisnike iz unesenog grada");
            System.out.println(" 6 - Ispiši brojeve iz unesenog grada");
            Scanner ulaz = new Scanner(System.in);
            int izbor = ulaz.nextInt();
            ulaz.nextLine();
            switch (izbor) {
                case 0:
                    System.out.println("Kraj programa.");
                    istina = false;
                    break;
                case 1:
                    System.out.println("-----Izabrali ste opciju dodavanja broja u imenik-----");
                    boolean novaIstina = true;
                    while (novaIstina) {
                        System.out.println("Izaberite koji broj želite dodati: ");
                        System.out.println(" 0 - Nazad");
                        System.out.println(" 1 - Dodaj fiksni broj");
                        System.out.println(" 2 - Dodaj mobilni broj");
                        System.out.println(" 3 - Dodaj međunarodni broj");
                        int noviIzbor = ulaz.nextInt();
                        ulaz.nextLine();
                        switch (noviIzbor) {
                            case 0:
                                novaIstina = false;
                                break;
                            case 1:
                                System.out.println("-----Izabrali ste opciju dodavanja fiksnog broja u imenik-----");
                                System.out.println("Unesite ime i prezime korisnika: ");
                                imeIPrezime = ulaz.nextLine();
                                System.out.println("Unesite grad: ");
                                grad = ulaz.nextLine();
                                System.out.println("Unesite telefonski broj: ");
                                broj = ulaz.nextLine();
                                TelefonskiBroj tb = new FiksniBroj(FiksniBroj.Grad.valueOf(grad.toUpperCase()), broj);
                                imenik.dodaj(imeIPrezime, tb);
                                System.out.println("Korisnik " + imeIPrezime + " sa brojem telefona " + tb.ispisi() + " je uspješno dodan.");
                                break;
                            case 2:
                                System.out.println("-----Izabrali ste opciju dodavanja mobilnog broja u imenik-----");
                                System.out.println("Unesite ime i prezime korisnika: ");
                                imeIPrezime = ulaz.nextLine();
                                System.out.println("Unesite mobilnu mrežu: ");
                                mobilnaMreza = ulaz.nextInt();
                                ulaz.nextLine();
                                System.out.println("Unesite telefonski broj: ");
                                broj = ulaz.nextLine();
                                TelefonskiBroj mb = new MobilniBroj(mobilnaMreza, broj);
                                imenik.dodaj(imeIPrezime, mb);
                                System.out.println("Korisnik " + imeIPrezime + " sa brojem telefona " + mb.ispisi() + " je uspješno dodan.");
                                break;
                            case 3:
                                System.out.println("-----Izabrali ste opciju dodavanja međunarodnog broja u imenik-----");
                                System.out.println("Unesite ime i prezime korisnika: ");
                                imeIPrezime = ulaz.nextLine();
                                System.out.println("Unesite državu: ");
                                drzava = ulaz.nextLine();
                                System.out.println("Unesite telefonski broj: ");
                                broj = ulaz.nextLine();
                                TelefonskiBroj medjb = new MedunarodniBroj(drzava, broj);
                                imenik.dodaj(imeIPrezime, medjb);
                                System.out.println("Korisnik " + imeIPrezime + " sa brojem telefona " + medjb.ispisi() + " je uspješno dodan.");
                                break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("-----Izabrali ste opciju traženja broja na osnovu imena korisnika-----");
                    System.out.println("Unesite ime korisnika: ");
                    imeIPrezime = ulaz.nextLine();
                    String broj1 = new String();
                    try {
                        broj1 = imenik.dajBroj(imeIPrezime);
                        System.out.println("Uspješno je pronađen korisnik " + imeIPrezime + " sa brojem " + broj1 + ".");
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("-----Izabrali ste opciju traženja korisnika na osnovu njegovog broja-----");
                    boolean novaNovaIstina = true;
                    while (novaNovaIstina) {
                        System.out.println("Izaberite na osnovu kojeg broja želite tražiti korisnika: ");
                        System.out.println(" 0 - Nazad");
                        System.out.println(" 1 - Na osnovu fiksnog broja");
                        System.out.println(" 2 - Na osnovu mobilnog broja");
                        System.out.println(" 3 - Na osnovu međunarodnog broja");
                        int noviIzbor = ulaz.nextInt();
                        ulaz.nextLine();
                        switch (noviIzbor) {
                            case 0:
                                novaNovaIstina = false;
                                break;
                            case 1:
                                System.out.println("-----Izabrali ste opciju traženja korisnika na osnovu fiksnog broja-----");
                                System.out.println("Unesite grad: ");
                                grad = ulaz.nextLine();
                                System.out.println("Unesite telefonski broj: ");
                                broj = ulaz.nextLine();
                                TelefonskiBroj tb = new FiksniBroj(FiksniBroj.Grad.valueOf(grad.toUpperCase()), broj);
                                String korisnik = new String();
                                korisnik = imenik.dajIme(tb);
                                System.out.println("Uspješno je pronađen korisnik " + korisnik + " sa brojem " + tb.ispisi() + ".");
                                break;
                            case 2:
                                System.out.println("-----Izabrali ste opciju traženja korisnika na osnovu mobilnog broja-----");
                                System.out.println("Unesite mobilnu mrežu: ");
                                mobilnaMreza = ulaz.nextInt();
                                ulaz.nextLine();
                                System.out.println("Unesite telefonski broj: ");
                                broj = ulaz.nextLine();
                                TelefonskiBroj mb = new MobilniBroj(mobilnaMreza, broj);
                                korisnik = imenik.dajIme(mb);
                                System.out.println("Uspješno je pronađen korisnik " + korisnik + " sa brojem " + mb.ispisi() + ".");
                                break;
                            case 3:
                                System.out.println("-----Izabrali ste opciju traženja korisnika na osnovu međunarodnog broja-----");
                                System.out.println("Unesite državu: ");
                                drzava = ulaz.nextLine();
                                System.out.println("Unesite telefonski broj: ");
                                broj = ulaz.nextLine();
                                TelefonskiBroj medjb = new MedunarodniBroj(drzava, broj);
                                korisnik = imenik.dajIme(medjb);
                                System.out.println("Uspješno je pronađen korisnik " + korisnik + " sa brojem " + medjb.ispisi() + ".");
                                break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("-----Izabrali ste opciju ispisa registrovanih korisnika sa unesenim početnim slovom-----");
                    System.out.println("Unesite početno slovo: ");
                    char slovo;
                    slovo = ulaz.next().charAt(0);
                    ulaz.nextLine();
                    try {
                        System.out.println("Korisnici sa početnim slovom " + slovo + " su:\n" + imenik.naSlovo(slovo));
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("-----Izabrali ste opciju ispisa registrovanih korisnika iz unesenog grada-----");
                    System.out.println("Unesite ime grada: ");
                    grad = ulaz.nextLine();
                    try {
                        Set<String> st = new TreeSet<>();
                        st = imenik.izGrada(FiksniBroj.Grad.valueOf(grad.toUpperCase()));
                        System.out.println("Registrovani korisnici iz traženog grada su: ");
                        int brojanje = 0;
                        for (String ime : st) {
                            System.out.println(brojanje + 1 + ". " + ime + "\n");
                            brojanje++;
                        }
                        System.out.println("Korisnici su uspješno pronađeni.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("-----Izabrali ste opciju ispisa brojeva registrovanih korisnika iz unesenog grada-----");
                    System.out.println("Unesite grad: ");
                    grad = ulaz.nextLine();
                    try {
                        Set<TelefonskiBroj> st = new TreeSet<>();
                        st = imenik.izGradaBrojevi(FiksniBroj.Grad.valueOf(grad.toUpperCase()));
                        System.out.println("Registrovani korisnici sa unesenim brojem iz traženog grada su: ");
                        int brojanje = 0;
                        for (TelefonskiBroj tb : st) {
                            if (tb instanceof FiksniBroj) {
                                System.out.println((brojanje + 1) + ". " + imenik.dajIme(tb) + "\n");
                                brojanje++;
                            }
                        }
                        System.out.println("Korisnici su uspješno pronađeni.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }
}

package ba.unsa.etf.rpr.tutorijal03;

import java.util.Scanner;

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

            }
        }
    }
}

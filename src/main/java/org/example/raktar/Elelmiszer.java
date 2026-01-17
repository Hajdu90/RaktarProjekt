package org.example.raktar;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;


public abstract class Elelmiszer implements Serializable, Comparable<Elelmiszer> {

    private String nev;
    private String gyarto;
    private LocalDate lejaratiDatum;


    public Elelmiszer(String nev, String gyarto, LocalDate lejaratiDatum) throws LejartElelmiszerException {
        this.nev = nev;
        this.gyarto = gyarto;


        if (lejaratiDatum.isBefore(LocalDate.now()) || lejaratiDatum.equals(LocalDate.now())) {
            throw new LejartElelmiszerException("lejárt élelmiszer: " + nev);
        }
        this.lejaratiDatum = lejaratiDatum;
    }


    public Elelmiszer(String nev, String gyarto) {
        this.nev = nev;
        this.gyarto = gyarto;
        this.lejaratiDatum = LocalDate.now().plusYears(1);
    }

    public String getNev() {
        return nev;
    }

    public String getGyarto() {
        return gyarto;
    }

    public LocalDate getLejaratiDatum() {
        return lejaratiDatum;
    }

    @Override
    public String toString() {
        return "Név: " + nev + ", Gyártó: " + gyarto + ", Lejárat: " + lejaratiDatum;
    }


    @Override
    public int compareTo(Elelmiszer o) {
        return this.nev.compareTo(o.nev);
    }


    public static Comparator<Elelmiszer> GyartoComparator = new Comparator<Elelmiszer>() {
        @Override
        public int compare(Elelmiszer e1, Elelmiszer e2) {
            return e1.getGyarto().compareTo(e2.getGyarto());
        }
    };
}

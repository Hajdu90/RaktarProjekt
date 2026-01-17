package org.example.raktar;

import java.io.File;
import java.time.LocalDate;

public class Konzerv extends Elelmiszer {

    private String leiras;
    private File receptAjanlas;


    public Konzerv(String nev, String gyarto, LocalDate lejaratiDatum, String leiras, String receptFajlNeve) throws LejartElelmiszerException {
        super(nev, gyarto, lejaratiDatum);
        this.leiras = leiras;
        this.receptAjanlas = new File(receptFajlNeve);
    }


    public Konzerv(String nev, String gyarto, LocalDate lejaratiDatum, String leiras) throws LejartElelmiszerException {
        super(nev, gyarto, lejaratiDatum);
        this.leiras = leiras;
        this.receptAjanlas = null;
    }


    public Konzerv(String nev, String gyarto, String leiras) {
        super(nev, gyarto);
        this.leiras = leiras;
        this.receptAjanlas = null;
    }

    public void receptetMutat() {
        if (receptAjanlas != null && receptAjanlas.exists()) {

        } else {

        }
    }

    @Override
    public String toString() {
        String receptInfo = (receptAjanlas != null) ? ", Recept: " + receptAjanlas.getName() : "";
        return super.toString() + ", Leírás: " + leiras + receptInfo;
    }
}

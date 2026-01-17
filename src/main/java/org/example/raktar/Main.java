package org.example.raktar;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            Raktar raktar = new Raktar();


            Konzerv k1 = new Konzerv("Babfőzelék", "Globus", LocalDate.now().plusMonths(6), "Finom főzelék", "recept.txt");

            Konzerv k2 = new Konzerv("Lencse", "Bonduelele", "Lencse konzerv");

            Konzerv k3 = new Konzerv("Kukorica", "Globus", LocalDate.of(2026, 1, 19), "Édes kukorica");

            raktar.felvesz(k1);
            raktar.felvesz(k2);
            raktar.felvesz(k3);


            try {
                Konzerv lejart = new Konzerv("Romlott Hús", "Senki", LocalDate.of(2000, 1, 1), "Ez már rossz");
            } catch (LejartElelmiszerException e) {
                System.out.println("Hiba elkapva: " + e.getMessage());
            }

            System.out.println("--- Raktár tartalma (Eredeti sorrend) ---");
            for (Elelmiszer e : raktar) {
                System.out.println(e);
            }


            System.out.println("\n--- Rendezve NÉV szerint ---");
            List<Elelmiszer> lista = new ArrayList<>(raktar.getElelmiszerek());
            Collections.sort(lista);
            for (Elelmiszer e : lista) {
                System.out.println(e);
            }


            System.out.println("\n-- Rendezve GYÁRTÓ szerint ---");
            Collections.sort(lista, Elelmiszer.GyartoComparator);
            for (Elelmiszer e : lista) {
                System.out.println(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

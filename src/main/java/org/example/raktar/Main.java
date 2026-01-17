package org.example.raktar;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Raktar raktar = new Raktar();

        try {


            Konzerv k1 = new Konzerv("Babfőzelék", "Globus", LocalDate.now().plusMonths(6), "Finom főzelék", "recept.txt");
            Konzerv k2 = new Konzerv("Lencse", "Bonduelele", "Lencse konzerv");
            Konzerv k3 = new Konzerv("Kukorica", "Globus", LocalDate.of(2028, 1, 19), "Édes kukorica");

            raktar.felvesz(k1);
            raktar.felvesz(k2);
            raktar.felvesz(k3);



        } catch (Exception e) {
            e.printStackTrace();
        }



        System.out.println("--- Mentés folyamatban... ---");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("raktar.bin"))) {
            oos.writeObject(raktar);
            System.out.println("Sikeres mentés a raktar.bin fájlba.");
        } catch (Exception e) {
            System.err.println("Hiba a mentés során: " + e.getMessage());
        }

        System.out.println("\n--- Visszaolvasás folyamatban... ---");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("raktar.bin"))) {
            Raktar visszatoltott = (Raktar) ois.readObject();

            System.out.println("Visszatöltött raktár tartalma:");
            for (Elelmiszer e : visszatoltott) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.err.println("Hiba a visszaolvasás során: " + e.getMessage());
        }
    }
}
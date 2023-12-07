package Formlar;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DosyaIO {
    public static void dersleriDosyayaYaz(List<Model.Ders> dersler, String dosyaAdi) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaAdi, true))) {
            for (Model.Ders ders : dersler) {
                String dersBilgisi = ders.getDersAd() + "-" + ders.getDersDonem() + "-" + ders.getDersKodu();
                writer.write(dersBilgisi + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Model.Ders> dersleriDosyadanOku(String dosyaAdi) {
        List<Model.Ders> dersListesi = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(dosyaAdi))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("-");
                if (tokens.length == 3) {
                    Model.Ders ders = new Model.Ders(tokens[2], tokens[0], tokens[1]);
                    dersListesi.add(ders);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dersListesi;
    }

    public static void ogrenciyiDosyayaYaz(String ogrenci, String dosyaAdi, String dosyaUzantisi) {
        try (FileWriter fileWriter = new FileWriter(dosyaAdi + dosyaUzantisi, true)) {
            fileWriter.write(ogrenci + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

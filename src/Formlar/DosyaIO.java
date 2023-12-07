package Formlar;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DosyaIO {
    public static void dersleriDosyayaYaz(List<Model.Ders> dersler, String dosyaAdi) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaAdi))) {
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

    public static void ogrenciyiDosyayaYaz(Model.Ogrenci ogrenci, String dosyaAdi, String dosyaUzantisi) {
        try (FileWriter fileWriter = new FileWriter(dosyaAdi + "Dosyalar/derslistesi")) {
            fileWriter.write(ogrenci.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

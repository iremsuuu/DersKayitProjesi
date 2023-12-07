package Formlar;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OgrenciKayitForm extends JFrame {
    private JTextField txtOgrenciNo;
    private JTextField txtOgrenciAd;
    private JTextField txtOgrenciSoyad;
    private JTextField txtOgrenciBolum;
    private JComboBox<String> dersSecimComboBox;
    private JButton btnKaydet;

    public OgrenciKayitForm() {
        initializeComponents();
    }

    private void initializeComponents() {
        setTitle("Öğrenci Kayıt Formu");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10)); // 6 satır, 2 sütunlu grid layout
        panel.setBackground(new Color(255, 192, 203)); // Toz pembe arka plan rengi

        JLabel labelOgrenciNo = new JLabel("Öğrenci No:");
        txtOgrenciNo = new JTextField();

        JLabel labelOgrenciAd = new JLabel("Öğrenci Adı:");
        txtOgrenciAd = new JTextField();

        JLabel labelOgrenciSoyad = new JLabel("Öğrenci Soyadı:");
        txtOgrenciSoyad = new JTextField();

        JLabel labelOgrenciBolum = new JLabel("Öğrenci Bölümü:");
        txtOgrenciBolum = new JTextField();

        JLabel labelDersSecimi = new JLabel("Ders Seçimi:");
        dersSecimComboBox = new JComboBox<>();

        panel.add(labelOgrenciNo);
        panel.add(txtOgrenciNo);

        panel.add(labelOgrenciAd);
        panel.add(txtOgrenciAd);

        panel.add(labelOgrenciSoyad);
        panel.add(txtOgrenciSoyad);

        panel.add(labelOgrenciBolum);
        panel.add(txtOgrenciBolum);

        panel.add(labelDersSecimi);
        panel.add(dersSecimComboBox);

        btnKaydet = new JButton("Kaydet");
        btnKaydet.addActionListener(e -> kaydetAction());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Butonu ortala
        buttonPanel.add(btnKaydet);

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH); // Butonu aşağıya ekle
        setSize(500, 250); // Boyutları büyültülmüş
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void kaydetAction() {
        String ogrenciNo = txtOgrenciNo.getText();
        String ogrenciAd = txtOgrenciAd.getText();
        String ogrenciSoyad = txtOgrenciSoyad.getText();
        String ogrenciBolum = txtOgrenciBolum.getText();

        String ogrenciBilgileri = ogrenciNo + ", " + ogrenciAd + ", " + ogrenciSoyad + ", " + ogrenciBolum + "\n";
        dosyayaYaz("Dosyalar/ögrencilistesi.txt", ogrenciBilgileri);

        JOptionPane.showMessageDialog(this, "Kaydedildi");
    }

    private void dosyayaYaz(String dosyaYolu, String icerik) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaYolu, true))) {
            writer.write(icerik);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(OgrenciKayitForm::new);
    }
}

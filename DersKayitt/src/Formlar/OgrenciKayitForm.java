package Formlar;

import javax.swing.*;
import java.awt.*;
import java.util.List;

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
        panel.setBackground(new Color(251, 195, 176));

        JLabel labelOgrenciNo = new JLabel("Öğrenci No:");
        txtOgrenciNo = new JTextField();

        JLabel labelOgrenciAd = new JLabel("Öğrenci Adı:");
        txtOgrenciAd = new JTextField();

        JLabel labelOgrenciSoyad = new JLabel("Öğrenci Soyadı:");
        txtOgrenciSoyad = new JTextField();

        JLabel labelOgrenciBolum = new JLabel("Öğrenci Bölümü:");
        txtOgrenciBolum = new JTextField();

        JLabel labelDersSecimi = new JLabel("Ders Seçimi:");

        // Dersleri dosyadan oku
        List<Model.Ders> dersListesi = DosyaIO.dersleriDosyadanOku("Dosyalar/dersler.txt");
        String[] dersler = dersListesi.stream().map(Model.Ders::getDersAd).toArray(String[]::new);
        dersSecimComboBox = new JComboBox<>(dersler);

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
        String secilenDers = (String) dersSecimComboBox.getSelectedItem();

        if (ogrenciNo.isEmpty() || ogrenciAd.isEmpty() || ogrenciSoyad.isEmpty() || ogrenciBolum.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Lütfen tüm alanları doldurun.", "Hata", JOptionPane.ERROR_MESSAGE);
        } else {
            // Öğrenci bilgilerini birleştir
            String ogrenciBilgileri = ogrenciNo + ", " + ogrenciAd + ", " + ogrenciSoyad + ", " + ogrenciBolum + ", " + secilenDers;

            // Öğrenci bilgilerini dosyaya ekle
            DosyaIO.ogrenciyiDosyayaYaz(ogrenciBilgileri, "Dosyalar/ögrencilistesi.txt", ".txt");

            JOptionPane.showMessageDialog(this, "Kaydedildi");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(OgrenciKayitForm::new);
    }
}

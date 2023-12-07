package Formlar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DersKayitForm extends JFrame {
    private JTextField txtDersKodu;
    private JTextField txtDersAd;
    private JTextField txtDersDonem;
    private JButton btnKaydet;

    public DersKayitForm() {
        initializeComponents();
    }

    private void initializeComponents() {
        setTitle("Ders Kayıt");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10)); // 4 satır, 2 sütunlu grid layout
        panel.setBackground(new Color(251,195,176)); // Toz pembe arka plan rengi

        JLabel labelDersKodu = new JLabel("Ders Kodu:");
        txtDersKodu = new JTextField();

        JLabel labelDersAd = new JLabel("Ders Adı:");
        txtDersAd = new JTextField();

        JLabel labelDersDonem = new JLabel("Ders Dönemi:");
        txtDersDonem = new JTextField();

        panel.add(labelDersKodu);
        panel.add(txtDersKodu);

        panel.add(labelDersAd);
        panel.add(txtDersAd);

        panel.add(labelDersDonem);
        panel.add(txtDersDonem);

        btnKaydet = new JButton("Kaydet");
        btnKaydet.addActionListener(e -> kaydetAction());

        // Fontu ayarla
        Font customFont = new Font("Arial", Font.BOLD, 14);
        labelDersKodu.setFont(customFont);
        labelDersAd.setFont(customFont);
        labelDersDonem.setFont(customFont);
        txtDersKodu.setFont(customFont);
        txtDersAd.setFont(customFont);
        txtDersDonem.setFont(customFont);
        btnKaydet.setFont(customFont);

        btnKaydet = new JButton("Kaydet");
        btnKaydet.addActionListener(e -> kaydetAction());

        add(panel, BorderLayout.CENTER);
        add(btnKaydet, BorderLayout.SOUTH);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void kaydetAction() {
        String dersKodu = txtDersKodu.getText();
        String dersAd = txtDersAd.getText();
        String dersDonem = txtDersDonem.getText();

        List<Model.Ders> dersListesi = new ArrayList<>();
        Model.Ders ders = new Model.Ders(dersKodu, dersAd, dersDonem);
        dersListesi.add(ders);

        DosyaIO.dersleriDosyayaYaz(dersListesi, "Dosyalar/dersler.txt");

        JOptionPane.showMessageDialog(this, "Kaydedildi"); // Kaydedildi mesajı
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DersKayitForm();
        });
    }
}

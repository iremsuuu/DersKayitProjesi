package Formlar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class AnasayfaForm extends JFrame {
    private JButton btnOgrenciKayit;
    private JButton btnDersKayit;

    public AnasayfaForm() {
        initializeComponents();
    }

    private void initializeComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Anasayfa");
        setSize(400, 250); // Boyutlar güncellendi
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(251,195,176));

        btnOgrenciKayit = new JButton("Öğrenci Kayıt");
        btnDersKayit = new JButton("Ders Kayıt");

        panel.add(btnOgrenciKayit);
        panel.add(btnDersKayit);
        add(panel);

        btnOgrenciKayit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OgrenciKayitForm ogrenciKayitForm = new OgrenciKayitForm();
                ogrenciKayitForm.setVisible(true);
            }
        });


        btnDersKayit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DersKayitForm dersKayitForm = new DersKayitForm();
                dersKayitForm.setVisible(true);
            }
        });
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AnasayfaForm anasayfa = new AnasayfaForm();
            anasayfa.setVisible(true);
        });
    }
}

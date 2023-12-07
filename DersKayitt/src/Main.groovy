import javax.swing.SwingUtilities

class Main {
  static void main(String[] args) {
    SwingUtilities.invokeLater({
      def anasayfaForm = new Formlar.AnasayfaForm()
      anasayfaForm.setVisible(true)
    })
  }
}

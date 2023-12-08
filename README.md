# DersKayitProjesi
#### Bu proje, öğrenci ve ders bilgilerini kaydetmeyi sağlayan basit bir Java uygulamasını içerir. Projenin temel bileşenleri şunlardır:

## OgrenciKayitForm Sınıfı:

-Bu sınıf, öğrenci bilgilerini giriş alır ve bu bilgileri dosyalara yazmak için DosyaIO sınıfını kullanır.  
-Öğrenci bilgileri, öğrenci numarası, adı, soyadı, bölümü ve seçilen dersi içerir.    
-kaydetAction metodu, gerekli alanları kontrol eder ve ardından öğrenci ve ders bilgilerini dosyalara kaydetmek için dosyayaYaz metodunu çağırır.

## DersKayitForm Sınıfı:

-Bu sınıf, ders bilgilerini giriş alır ve bu bilgileri dosyalara yazmak için DosyaIO sınıfını kullanır.   
-Ders bilgileri, ders kodu, adı ve dönemini içerir.        
-kaydetAction metodu, gerekli alanları kontrol eder ve ardından ders bilgilerini dosyalara kaydetmek için DosyaIO sınıfındaki dersleriDosyayaYaz metodunu çağırır.

## DosyaIO Sınıfı:
-Bu sınıf, dosya işlemleri için yardımcı metotları içerir.  
-dersleriDosyayaYaz metodu, ders listesini alır ve dosyaya yazmak için kullanılır.   
-dersleriDosyadanOku metodu, ders listesini dosyadan okur ve liste olarak döndürür.   
-ogrenciyiDosyayaYaz metodu, öğrenci bilgilerini dosyaya yazmak için kullanılır.

## AnasayfaForm Sınıfı:
-Bu sınıf, kullanıcıya öğrenci kayıt ve ders kayıt formlarına gitme seçeneği sunar.      
-Öğrenci Kayıt ve Ders Kayıt butonları, ilgili formları açmak için ActionListener'lar içerir.        
-btnOgrenciKayit butonuna tıklandığında, OgrenciKayitForm'u görüntülemek için yeni bir örneğini oluşturur.       
-btnDersKayit butonuna tıklandığında, DersKayitForm'u görüntülemek için yeni bir örneğini oluşturur.

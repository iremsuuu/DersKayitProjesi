package Model;

public class Ders {
    private String dersKodu;
    private String dersAd;
    private String dersDonem;

    public Ders(String dersKodu, String dersAd, String dersDonem) {
        this.dersKodu = dersKodu;
        this.dersAd = dersAd;
        this.dersDonem = dersDonem;
    }

    // Getter ve Setter metotları
    public String getDersKodu() {
        return dersKodu;
    }

    public void setDersKodu(String dersKodu) {
        this.dersKodu = dersKodu;
    }

    public String getDersAd() {
        return dersAd;
    }

    public void setDersAd(String dersAd) {
        this.dersAd = dersAd;
    }

    public String getDersDonem() {
        return dersDonem;
    }

    public void setDersDonem(String dersDonem) {
        this.dersDonem = dersDonem;
    }

    @Override
    public String toString() {
        return "Ders Kodu: " + dersKodu + ", Ders Adı: " + dersAd + ", Dönem: " + dersDonem;
    }
}


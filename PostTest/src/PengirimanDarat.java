public class PengirimanDarat extends LayananPengiriman 
implements LacakKargo {
    private String jenisTruk;
    private String statusSaatIni;

    public PengirimanDarat(String noResi, double beratBarang,
                            double jarakTempuh, String jenisTruk) {
        super(noResi, beratBarang, jarakTempuh);
        this.jenisTruk    = jenisTruk;
        this.statusSaatIni = "Menunggu Kurir";
    }

    @Override
    public double hitungOngkosKirim() {
        double ongkos = (beratBarang * 5000) + (jarakTempuh * 2000);
        if (jenisTruk.equalsIgnoreCase("Tronton")) {
            ongkos += 150000;
        }
        return ongkos;
    }

    @Override
    public void updateStatus(String status) {
        this.statusSaatIni = status;
        System.out.println("  Status diperbarui: " + statusSaatIni);
    }

    @Override
    public String cekLokasiTerakhir() {
        return statusSaatIni;
    }
}
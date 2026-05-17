public abstract class LayananPengiriman {
    protected String noResi;
    protected double beratBarang;
    protected double jarakTempuh;

    public LayananPengiriman(String noResi, double beratBarang, 
    double jarakTempuh) {
        this.noResi      = noResi;
        this.beratBarang = beratBarang;
        this.jarakTempuh = jarakTempuh;
    }

    public void cetakResi() {
        System.out.println("  No. Resi      : " + noResi);
        System.out.println("  Berat Barang  : " + beratBarang + " kg");
        System.out.println("  Jarak Tempuh  : " + jarakTempuh + " km");
    }

    public abstract double hitungOngkosKirim();
}
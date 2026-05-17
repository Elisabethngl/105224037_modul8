// Pembayaran.java
public abstract class Pembayaran {
    protected String namaPembayar;
    protected double nominal;

    public Pembayaran(String namaPembayar, double nominal) {
        this.namaPembayar = namaPembayar;
        this.nominal      = nominal;
    }

    public void tampilkanDetail() {
        System.out.println("  Nama Pembayar : " + namaPembayar);
        System.out.println("  Nominal       : Rp " + 
            String.format("%,.0f", nominal));
    }

    public abstract void prosesPembayaran();
}
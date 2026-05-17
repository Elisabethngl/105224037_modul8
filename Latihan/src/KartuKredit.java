// KartuKredit.java
public class KartuKredit extends Pembayaran implements Keamanan {
    private String nomorKartu;

    public KartuKredit(String namaPembayar, double nominal, 
                       String nomorKartu) {
        super(namaPembayar, nominal);
        this.nomorKartu = nomorKartu;
    }

    @Override
    public void prosesPembayaran() {
        double biayaAdmin = nominal * 0.02;
        double total      = nominal + biayaAdmin;
        System.out.println("  [KARTU KREDIT]");
        System.out.println("  Nomor Kartu   : " + nomorKartu);
        System.out.println("  Nominal       : Rp " + 
            String.format("%,.0f", nominal));
        System.out.println("  Biaya Admin   : Rp " + 
            String.format("%,.0f", biayaAdmin));
        System.out.println("  Total Tagihan : Rp " + 
            String.format("%,.0f", total));
    }

    @Override
    public boolean autentikasi() {
        System.out.println("  Autentikasi PIN berhasil.");
        return true;
    }
}
// EWallet.java
public class EWallet extends Pembayaran implements Keamanan {
    private String nomorHP;

    public EWallet(String namaPembayar, double nominal, 
                   String nomorHP) {
        super(namaPembayar, nominal);
        this.nomorHP = nomorHP;
    }

    @Override
    public void prosesPembayaran() {
        System.out.println("  [E-WALLET]");
        System.out.println("  Nomor HP      : " + nomorHP);
        System.out.println("  Nominal       : Rp " + 
            String.format("%,.0f", nominal));
        System.out.println("  Total Tagihan : Rp " + 
            String.format("%,.0f", nominal));
    }

    @Override
    public boolean autentikasi() {
        System.out.println("  Autentikasi berhasil.");
        return true;
    }
}
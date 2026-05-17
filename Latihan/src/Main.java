// MainLatihan.java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Pembayaran> list = new ArrayList<>();
        list.add(new KartuKredit("Elisabeth", 1000000, "1234-5678-9012-3456"));
        list.add(new EWallet("Silvi", 500000, "0812-3456-7890"));

        System.out.println("=== SISTEM PEMBAYARAN DIGITAL ===\n");
        for (Pembayaran p : list) {
            p.tampilkanDetail();
            if (p instanceof Keamanan) {
                boolean auth = ((Keamanan) p).autentikasi();
                if (auth) {
                    p.prosesPembayaran();
                }
            }
            System.out.println();
        }
    }
}
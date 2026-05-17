public class Main {
    public static void main(String[] args) {

        LayananPengiriman[] armada = new LayananPengiriman[2];

        armada[0] = new PengirimanDarat(
            "DRT-001", 50, 100, "Tronton");
        armada[1] = new PengirimanUdara(
            "UDR-999", 10, 800, "GA-123", 5000000);

        System.out.println();
        ((PengirimanDarat) armada[0])
            .updateStatus("Sedang di jalan tol Cipali");
        ((PengirimanUdara) armada[1])
            .updateStatus("Transit di Bandara Soekarno-Hatta");
        
        System.out.println();
        System.out.println("=== SISTEM LOGISTIK LOGISTIK-PRO ===\n");

        for (LayananPengiriman p : armada) {
            System.out.println("----------------------------------------");
            p.cetakResi();
            System.out.println("  Lokasi Terakhir: " + 
                ((LacakKargo) p).cekLokasiTerakhir());

            double ongkos = p.hitungOngkosKirim();
            double total  = ongkos;

            if (p instanceof Asuransi) {
                Asuransi a     = (Asuransi) p;
                double nilai   = ((PengirimanUdara) p).getNilaiBarang();
                double premi   = a.hitungPremi(nilai);
                a.cetakPolis();
                System.out.println("  Premi Asuransi : Rp " +
                    String.format("%,.0f", premi));
                total += premi;
            }

            System.out.println("  Ongkos Kirim   : Rp " +
                String.format("%,.0f", ongkos));
            System.out.println("  Total Tagihan  : Rp " +
                String.format("%,.0f", total));
            System.out.println("----------------------------------------\n");
        }
    }
}
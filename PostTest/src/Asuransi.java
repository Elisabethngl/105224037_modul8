public interface Asuransi {
    double hitungPremi(double nilaiBarang);

    default void cetakPolis() {
        System.out.println("  Polis Asuransi aktif: Menanggung " +
            "kehilangan dan kerusakan fisik sebesar " +
            "100% dari nilai barang.");
    }
}
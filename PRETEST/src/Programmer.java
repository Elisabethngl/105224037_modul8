public class Programmer extends Karyawan {
    private double gajiPokok;


    public Programmer (String nama, double gajiPokok){
    super(nama);
    this.gajiPokok = gajiPokok;

    }
    
    @Override 
    public void hitungGaji (){
        System.out.println ("Gaji Programmer" + nama + ":" +gajiPokok);

    }
}


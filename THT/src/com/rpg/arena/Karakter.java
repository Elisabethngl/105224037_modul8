package com.rpg.arena;

// Abstract class = kelas "setengah jadi", tidak bisa langsung dibuat objeknya
// Dia implementasi AksiBertarung karena semua karakter punya aksi bertarung
public abstract class Karakter implements AksiBertarung {

    // protected = bisa diakses oleh subclass (Pahlawan & Monster)
    // private = hanya bisa diakses di kelas ini saja
    protected String nama;
    protected int hp;
    protected int baseDamage;
    private boolean isDefending; // status apakah sedang bertahan

    // Constructor: dipanggil saat objek dibuat, untuk isi nilai awal
    public Karakter(String nama, int hp, int baseDamage) {
        this.nama = nama;
        this.hp = hp;
        this.baseDamage = baseDamage;
        this.isDefending = false; // default tidak sedang bertahan
    }

    // ===== GETTER & SETTER =====
    // Getter = cara aman untuk ambil nilai atribut private dari luar kelas
    public String getNama() { return nama; }
    public int getHp() { return hp; }
    public int getBaseDamage() { return baseDamage; }
    public boolean isDefending() { return isDefending; }

    // Setter = cara aman untuk ubah nilai atribut private dari luar kelas
    public void setNama(String nama) { this.nama = nama; }
    public void setHp(int hp) { this.hp = hp; }
    public void setBaseDamage(int baseDamage) { 
        this.baseDamage = baseDamage; 
    }
    public void setDefending(boolean isDefending) { 
        this.isDefending = isDefending; 
    }

    // Metode untuk terima damage dari lawan
    // Logika percabangan: kalau lagi bertahan, damage dikurangi setengah
    public void terimaDamage(int damage) {
        if (isDefending) {
            // Kalau lagi defend, damage cuma setengahnya
            damage = damage / 2;
            // Setelah kena serangan, status defend langsung hilang
            isDefending = false;
        }

        // Kurangi HP sesuai damage yang diterima
        hp -= damage;

        // Pastikan HP tidak minus, minimal 0
        if (hp < 0) {
            hp = 0;
        }
    }

    // Abstract method: WAJIB di-override oleh subclass
    // Karena cara menampilkan status Pahlawan & Monster beda-beda
    public abstract void tampilkanStatus();
}
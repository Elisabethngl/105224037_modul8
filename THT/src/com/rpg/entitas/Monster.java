package com.rpg.entitas;

import com.rpg.arena.Karakter;

// Monster adalah subclass dari Karakter
// Punya atribut tambahan jenisMonster untuk membedakan tipe monster
public class Monster extends Karakter {

    // jenisMonster = tipe/jenis monster, misal "Goblin Prajurit", "Naga Merah"
    private String jenisMonster;

    // Constructor Monster: panggil constructor induk pakai super()
    // lupa super() = error, karena Karakter butuh nama, hp, baseDamage
    public Monster(String nama, int hp, int baseDamage,
                   String jenisMonster) {
        super(nama, hp, baseDamage); // panggil constructor Karakter
        this.jenisMonster = jenisMonster;
    }

    // Getter untuk jenisMonster
    public String getJenisMonster() { return jenisMonster; }

    // ===== POLYMORPHISM: override metode serang dari interface =====
    // Damage monster = baseDamage saja, tidak ada level seperti Pahlawan
    @Override
    public int serang() {
        return baseDamage;
    }

    // Override bertahan: monster pulihkan sedikit HP saat bertahan
    // Ini bedanya dengan Pahlawan, monster lebih "pasif" saat defend
    @Override
    public void bertahan() {
        int pulih = baseDamage / 2; // pulihkan HP setengah dari baseDamage
        setHp(getHp() + pulih);
        System.out.println("  " + nama +
            " memulihkan HP sebesar " + pulih +
            ". HP sekarang: " + getHp());
    }

    // Override gunakanItem: monster tidak bisa pakai item
    // Berbeda dengan Pahlawan yang bisa heal pakai item
    @Override
    public void gunakanItem() {
        System.out.println("  " + nama +
            " tidak bisa menggunakan item!");
    }

    // Override tampilkanStatus: cetak info Monster
    // Menampilkan nama, jenis, dan HP monster saat ini
    @Override
    public void tampilkanStatus() {
        System.out.println("  [MONSTER] " + nama +
            " (" + jenisMonster + ")" +
            " | HP: " + getHp());
    }
}
package com.rpg.entitas;

import com.rpg.arena.Karakter;

// Monster juga subclass dari Karakter
// Punya atribut tambahan jenisMonster
public class Monster extends Karakter {

    private String jenisMonster;

    public Monster(String nama, int hp, int baseDamage, 
                   String jenisMonster) {
        super(nama, hp, baseDamage); // panggil constructor Karakter
        this.jenisMonster = jenisMonster;
    }

    public String getJenisMonster() { return jenisMonster; }

    // Override serang: damage monster = baseDamage saja (tidak ada level)
    @Override
    public int serang() {
        return baseDamage;
    }

    // Override bertahan: monster pulihkan sedikit HP saat bertahan
    // Ini bedanya dengan Pahlawan, monster lebih "pasif" saat defend
    @Override
    public void bertahan() {
        int pulih = baseDamage / 2; // pulihkan HP setengah dari damage
        setHp(getHp() + pulih);
        System.out.println("  " + nama + 
            " memulihkan HP sebesar " + pulih + 
            ". HP sekarang: " + getHp());
    }

    // Override gunakanItem: monster tidak pakai item
    @Override
    public void gunakanItem() {
        System.out.println("  " + nama + " tidak bisa menggunakan item!");
    }

    // Override tampilkanStatus: cetak info Monster
    @Override
    public void tampilkanStatus() {
        System.out.println("  [MONSTER] " + nama + 
            " (" + jenisMonster + ")" + 
            " | HP: " + getHp());
    }
}
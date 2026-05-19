package com.rpg.entitas;

import com.rpg.arena.Karakter;

// Pahlawan adalah subclass dari Karakter
// "extends" = mewarisi semua atribut & method dari Karakter
public class Pahlawan extends Karakter {

    // Atribut tambahan khusus Pahlawan
    private String mana;  // mana karakter
    private int level;    // level pahlawan, mempengaruhi damage

    // Constructor Pahlawan: panggil constructor induk pakai super()
    // lupa super() = error, karena Karakter butuh nama, hp, baseDamage
    public Pahlawan(String nama, int hp, int baseDamage,
                    String mana, int level) {
        super(nama, hp, baseDamage); // panggil constructor Karakter
        this.mana = mana;
        this.level = level;
    }

    // Getter & Setter untuk atribut tambahan Pahlawan
    public String getMana() { return mana; }
    public int getLevel() { return level; }
    public void setMana(String mana) { this.mana = mana; }
    public void setLevel(int level) { this.level = level; }

    // ===== POLYMORPHISM: override metode serang dari interface =====
    // Damage pahlawan = baseDamage dikali level
    // Misal baseDamage=10, level=3 → damage = 30
    @Override
    public int serang() {
        return baseDamage * level;
    }

    // ===== METHOD OVERLOADING: serang versi kedua dengan skill =====
    // Overloading = nama method sama tapi parameternya beda
    // Versi ini pakai skill, butuh nama skill & biaya mana
    public int serang(String namaSkill, int manaCost) {
        // Cek apakah mana cukup untuk pakai skill
        int manaSekarang = Integer.parseInt(this.mana);
        if (manaSekarang >= manaCost) {
            // Mana cukup: kurangi mana & hitung damage besar
            this.mana = String.valueOf(manaSekarang - manaCost);
            int damage = baseDamage * level * 2; // damage skill 2x lipat
            System.out.println("  Skill " + namaSkill +
                " digunakan! Damage: " + damage);
            return damage;
        } else {
            // Mana tidak cukup: gagal pakai skill
            System.out.println("  Mana tidak cukup untuk skill " +
                namaSkill + "!");
            return 0;
        }
    }

    // Override bertahan: ubah status isDefending jadi true
    @Override
    public void bertahan() {
        setDefending(true);
        System.out.println("  " + nama + " bersiap bertahan!");
    }

    // Override gunakanItem: tambah HP sebesar 30
    @Override
    public void gunakanItem() {
        setHp(getHp() + 30);
        System.out.println("  " + nama +
            " menggunakan item! HP bertambah 30. HP sekarang: " +
            getHp());
    }

    // Override tampilkanStatus: cetak info lengkap Pahlawan
    @Override
    public void tampilkanStatus() {
        System.out.println("  [PAHLAWAN] " + nama +
            " | HP: " + getHp() +
            " | Mana: " + mana +
            " | Level: " + level);
    }
}
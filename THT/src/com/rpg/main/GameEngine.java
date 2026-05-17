package com.rpg.main;

import com.rpg.arena.AksiBertarung;
import com.rpg.entitas.Monster;
import com.rpg.entitas.Pahlawan;
import java.util.Scanner;

public class GameEngine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===========================================");
        System.out.println("       SELAMAT DATANG DI RPG DUNGEON      ");
        System.out.println("===========================================");

        // Minta nama pahlawan dari pemain
        System.out.print("Masukkan nama Pahlawan: ");
        String namaPahlawan = scanner.nextLine();

        // Buat objek Pahlawan dengan nilai awal
        // mana disimpan sebagai String sesuai soal
        Pahlawan pahlawan = new Pahlawan(
            namaPahlawan, 100, 15, "50", 3
        );

        // Mode Survival: buat Array berisi 3 Monster berbeda
        // Array dipakai karena jumlah monster sudah pasti = 3
        Monster[] monsters = new Monster[3];
        monsters[0] = new Monster("Goblin",   40, 8,  "Goblin Prajurit");
        monsters[1] = new Monster("Orc",      60, 12, "Orc Berserker");
        monsters[2] = new Monster("Dragon",   80, 20, "Naga Merah");

        System.out.println("\nMode Survival dimulai! Kalahkan 3 monster!");
        System.out.println("===========================================\n");

        // ===== NESTED LOOP =====
        // Loop luar: untuk iterasi setiap monster satu per satu
        for (int i = 0; i < monsters.length; i++) {
            Monster monster = monsters[i];

            System.out.println(">>> Monster " + (i + 1) + 
                " muncul: " + monster.getNama() + "!");
            System.out.println("-------------------------------------------");

            // Loop dalam (Battle Loop): jalan selama kedua pihak masih hidup
            // Kondisi: HP Pahlawan > 0 DAN HP Monster > 0
            while (pahlawan.getHp() > 0 && monster.getHp() > 0) {

                // Tampilkan status kedua pihak setiap ronde
                pahlawan.tampilkanStatus();
                monster.tampilkanStatus();
                System.out.println();

                // ===== SWITCH-CASE: pilihan aksi pemain =====
                System.out.println("Pilih aksi:");
                System.out.println("1. Serang");
                System.out.println("2. Skill");
                System.out.println("3. Bertahan/Heal");
                System.out.print("Pilihan: ");

                int pilihan = scanner.nextInt();
                scanner.nextLine(); // bersihkan buffer scanner

                int damage = 0; // damage yang akan diberikan ke monster

                switch (pilihan) {
                    case 1:
                        // Serang biasa: panggil serang() versi 1
                        damage = pahlawan.serang();
                        System.out.println("  " + pahlawan.getNama() + 
                            " menyerang! Damage: " + damage);
                        // Berikan damage ke monster
                        monster.terimaDamage(damage);
                        break;

                    case 2:
                        // Serang skill: pakai method overloading serang()
                        // versi 2 dengan nama skill dan biaya mana
                        damage = pahlawan.serang("Fireball", 20);
                        if (damage > 0) {
                            monster.terimaDamage(damage);
                        }
                        break;

                    case 3:
                        // Bertahan & Heal: pakai bertahan() dan gunakanItem()
                        pahlawan.bertahan();
                        pahlawan.gunakanItem();
                        break;

                    default:
                        System.out.println("  Pilihan tidak valid!");
                        break;
                }

                // Setelah pemain beraksi, giliran monster menyerang balik
                // Tapi hanya kalau monster masih hidup
                if (monster.getHp() > 0) {
                    // Pakai instanceof untuk cek apakah monster
                    // implementasi AksiBertarung (selalu true, tapi
                    // ini contoh penggunaan instanceof)
                    if (monster instanceof AksiBertarung) {
                        int damageMonster = monster.serang();
                        System.out.println("  " + monster.getNama() + 
                            " membalas! Damage: " + damageMonster);
                        // Pahlawan terima damage dari monster
                        pahlawan.terimaDamage(damageMonster);
                    }
                }
                System.out.println();
            }

            // Cek hasil battle setiap monster
            if (monster.getHp() <= 0) {
                System.out.println(">>> " + monster.getNama() + 
                    " berhasil dikalahkan!\n");
            } else {
                // Kalau pahlawan mati di tengah, keluar dari loop luar
                break;
            }
        }

        // ===== KONDISI AKHIR GAME =====
        // Cek apakah Pahlawan berhasil kalahkan semua 3 monster
        // dan HP nya masih ada
        System.out.println("===========================================");
        if (pahlawan.getHp() > 0) {
            // Berhasil kalahkan semua monster
            System.out.println("SELAMAT! " + pahlawan.getNama() + 
                " berhasil menamatkan Dungeon!");
            System.out.println("HP tersisa: " + pahlawan.getHp());
        } else {
            // HP habis sebelum semua monster dikalahkan
            System.out.println("GAME OVER! " + pahlawan.getNama() + 
                " telah gugur di Dungeon...");
        }
        System.out.println("===========================================");

        scanner.close();
    }
}
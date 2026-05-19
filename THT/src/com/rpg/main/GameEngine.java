package com.rpg.main;

import com.rpg.arena.AksiBertarung;
import com.rpg.entitas.Monster;
import com.rpg.entitas.Pahlawan;
import java.util.Scanner;

public class GameEngine {
    public static void main(String[] args) {

        /*Kita pakai Scanner karena kita butuh input dari pemain
        untuk memilih nama dan aksi saat battle
        */
        Scanner scanner = new Scanner(System.in);

        System.out.println("===========================================");
        System.out.println("       SELAMAT DATANG DI RPG DUNGEON      ");
        System.out.println("===========================================");

        // Kita minta nama dari pemain supaya game terasa, lebih personal dan tidak hardcode nama pahlawannya
        System.out.print("Masukkan nama Pahlawan: ");
        String namaPahlawan = scanner.nextLine();

        // Kita buat objek Pahlawan dengan nilai awal yang sudah ditentukan mana disimpan sebagai String karena soal memintanya seperti itu
        Pahlawan pahlawan = new Pahlawan(
            namaPahlawan, 100, 15, "50", 3
        );

        // Kita pakai Array karena jumlah monster sudah pasti 3 dan urutannya tidak berubah selama game berjalan 
        Monster[] monsters = new Monster[3];
        monsters[0] = new Monster("Goblin",  40, 8,  "Goblin Prajurit");
        monsters[1] = new Monster("Orc",     60, 12, "Orc Berserker");
        monsters[2] = new Monster("Dragon",  80, 20, "Naga Merah");

        System.out.println("\nMode Survival dimulai! Kalahkan 3 monster!");
        System.out.println("===========================================\n");

        // Kita pakai for karena kita butuh iterasi setiap monster satu per satu secara berurutan dari index 0 sampai 2
        for (int i = 0; i < monsters.length; i++) {
            Monster monster = monsters[i];

            System.out.println(">>> Monster " + (i + 1) +
                " muncul: " + monster.getNama() + "!");
            System.out.println("-------------------------------------------");

            /*Kita pakai while karena battle harus terus berjalan selama kedua pihak masih hidup (HP > 0)
            kita tidak tahu butuh berapa ronde, makanya pakai while
            */
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
                scanner.nextLine();

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

                // Setelah pemain beraksi, giliran monster menyerang balik, Tapi hanya kalau monster masih hidup
                if (monster.getHp() > 0) {
                    // instanceof untuk cek apakah monster
                    // implementasi AksiBertarung
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

            // kita cek hasil battle setiap monster
            if (monster.getHp() <= 0) {
                System.out.println(">>> " + monster.getNama() +
                    " berhasil dikalahkan!\n");
            } else {
                // Kalau pahlawan mati di tengah, keluar dari loop luar
                break;
            }
        }

        // kita cek apakah Pahlawan berhasil kalahkan semua 3 monster dan HP nya masih ada
        System.out.println("===========================================");
        if (pahlawan.getHp() > 0) {
            System.out.println("SELAMAT! " + pahlawan.getNama() +
                " berhasil menamatkan Dungeon!");
            System.out.println("HP tersisa: " + pahlawan.getHp());
        } else {
            System.out.println("GAME OVER! " + pahlawan.getNama() +
                " telah gugur di Dungeon...");
        }
        System.out.println("===========================================");

        scanner.close();
    }
}
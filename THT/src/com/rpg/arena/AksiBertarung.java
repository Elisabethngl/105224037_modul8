package com.rpg.arena;

// Interface = kontrak yang WAJIB dipakai siapa saja yang implement dia
// Semua karakter (Pahlawan & Monster) WAJIB punya 3 kemampuan ini
public interface AksiBertarung {

    // Metode serang: wajib mengembalikan nilai damage (berapa HP yang berkurang)
    int serang();

    // Metode bertahan: untuk mode defense, tidak perlu return nilai
    void bertahan();

    // Metode gunakanItem: untuk pakai item seperti obat, buff, dll
    void gunakanItem();
}
package com.hei.model;

public class Rue {
    private final Lieu premierLieu;
    private final Lieu deuxiemeLieu;

    public Rue(Lieu premierLieu, Lieu deuxiemeLieu) {
        this.premierLieu = premierLieu;
        this.deuxiemeLieu = deuxiemeLieu;
    }

    public Lieu getPremierLieu() {
        return premierLieu;
    }

    public Lieu getDeuxiemeLieu() {
        return deuxiemeLieu;
    }
}

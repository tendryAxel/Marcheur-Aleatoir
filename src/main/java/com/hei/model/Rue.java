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


    public Lieu prendreRue(int idLieuDebut) {
        if (premierLieu.getId() == idLieuDebut) {
            return deuxiemeLieu;
        } else if (deuxiemeLieu.getId() == idLieuDebut) {
            return premierLieu;
        } else {
            throw new RuntimeException("Id lieu n'est pas dans cette rue");
        }
    }
}

package com.hei.model;

import java.util.Objects;

public class Rue {
    private final Lieu premierLieu;
    private final Lieu deuxiemeLieu;

    public Rue(Lieu premierLieu, Lieu deuxiemeLieu) {
        this.premierLieu = premierLieu;
        this.deuxiemeLieu = deuxiemeLieu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rue rue = (Rue) o;
        return Objects.equals(premierLieu, rue.premierLieu) && Objects.equals(deuxiemeLieu, rue.deuxiemeLieu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(premierLieu, deuxiemeLieu);
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

    public boolean estComposeDeLieu(int id) {
        return premierLieu.getId() == id || deuxiemeLieu.getId() == id;
    }
}

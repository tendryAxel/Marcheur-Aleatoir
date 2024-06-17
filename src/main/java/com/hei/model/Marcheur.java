package com.hei.model;

public class Marcheur {
    private Lieu position;

    public Marcheur(Lieu position) {
        this.position = position;
    }

    public Lieu getPosition() {
        return position;
    }

    public void prendreRue(Rue rue) {
        rue.augmenterPassage();
        position = rue.prendreRue(position.getId());
    }
}

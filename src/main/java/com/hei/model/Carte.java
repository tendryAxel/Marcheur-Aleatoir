package com.hei.model;

public class Carte {
    private final Marcheur marcheur;

    public Carte(Marcheur marcheur) {
        this.marcheur = marcheur;
    }

    public Marcheur getMarcheur() {
        return marcheur;
    }
}

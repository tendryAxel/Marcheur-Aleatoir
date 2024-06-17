package com.hei.model;

import java.util.HashSet;
import java.util.Set;

public class Carte {
    private final Marcheur marcheur;
    private final Set<Rue> rues;

    public Carte(Marcheur marcheur) {
        this.marcheur = marcheur;
        this.rues = new HashSet<>();
    }

    public Marcheur getMarcheur() {
        return marcheur;
    }

    public Set<Rue> getRues() {
        return rues;
    }

    public void addRue(Rue rue) {
        this.rues.add(rue);
    }
}

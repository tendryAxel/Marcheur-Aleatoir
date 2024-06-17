package com.hei.model;

import java.util.HashSet;
import java.util.Set;

public class Carte {
    private final Marcheur marcheur;
    private final Set<Lieu> lieux;

    public Carte(Marcheur marcheur) {
        this.marcheur = marcheur;
        this.lieux = new HashSet<>();
    }

    public Marcheur getMarcheur() {
        return marcheur;
    }

    public Set<Lieu> getLieux() {
        return lieux;
    }
}

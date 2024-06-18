package com.hei.carte;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Carte {
    private final Set<Rue> rues;

    public Carte() {
        this.rues = new HashSet<>();
    }

    public void addRue(Rue rue) {
        this.rues.add(rue);
    }

    public List<Rue> voirRueDisponible(Lieu position) {
        return this.rues.stream()
                .filter(rue -> rue.estComposeDeLieu(position.getId()))
                .toList();
    }
}

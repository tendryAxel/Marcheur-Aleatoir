package com.hei.model;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Carte {
    private final Set<Rue> rues;

    public Carte() {
        this.rues = new HashSet<>();
    }

    public Set<Rue> getRues() {
        return rues;
    }

    public void addRue(Rue rue) {
        this.rues.add(rue);
    }

    public Rue choisirRueAleatoirement(Lieu lieuDeDepart) {
        List<Rue> possibleChemin = this.rues.stream()
                .filter(rue -> rue.estComposeDeLieu(lieuDeDepart.getId()))
                .toList();
        int minPassage = possibleChemin.stream()
                .min(Comparator.comparing(Rue::getPassage))
                .orElse(null)
                .getPassage();
        List<Rue> possibleCheminAvecPeuDePassage = possibleChemin.stream()
                .filter(rue -> rue.getPassage() == minPassage)
                .toList();
        return possibleCheminAvecPeuDePassage.get((int) (possibleCheminAvecPeuDePassage.toArray().length * Math.random()));
    }
}

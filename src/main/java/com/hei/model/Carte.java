package com.hei.model;

import java.util.*;

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

    public Rue prendreRueAleatoir(int idDuLieuDeDepart) {
        List<Rue> possibleChemin = this.rues.stream()
                .filter(rue -> rue.estComposeDeLieu(idDuLieuDeDepart))
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

    public Lieu prendreRueAleatoir() {
        marcheur.prendreRue(prendreRueAleatoir(marcheur.getPosition().getId()));
        return marcheur.getPosition();
    }

    public List<Lieu> marcherAleatoirementJusqua(Lieu destination) {
        List<Lieu> lieuVisite = new ArrayList<>();
        while (marcheur.getPosition().getId() != destination.getId()) {
            lieuVisite.add(prendreRueAleatoir());
        }
        return lieuVisite;
    }
}

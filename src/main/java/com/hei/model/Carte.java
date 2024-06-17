package com.hei.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    public Rue prendreRueAleatoir(int idDuLieuDeDepart) {
        List<Rue> possibleChemin = this.rues.stream()
                .filter(rue -> rue.estComposeDeLieu(idDuLieuDeDepart))
                .toList();
        return possibleChemin.get((int) (possibleChemin.toArray().length * Math.random()));
    }

    public Lieu prendreRueAleatoir() {
        marcheur.prendreRue(prendreRueAleatoir(marcheur.getPosition().getId()));
        return marcheur.getPosition();
    }

    public List<Lieu> marcherAleatoirementJusqua(int idLieu) {
        List<Lieu> lieuVisite = new ArrayList<>();
        while (marcheur.getPosition().getId() != idLieu) {
            lieuVisite.add(prendreRueAleatoir());
        }
        return lieuVisite;
    }
}

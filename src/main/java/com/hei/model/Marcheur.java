package com.hei.model;

import java.util.ArrayList;
import java.util.List;

public class Marcheur {
    private Lieu position;
    private final Carte carte;

    public Marcheur(Lieu position, Carte carte) {
        this.position = position;
        this.carte = carte;
    }

    public Lieu getPosition() {
        return position;
    }

    public Carte getCarte() {
        return carte;
    }

    public void prendreRue(Rue rue) {
        rue.augmenterPassage();
        position = rue.prendreRue(position.getId());
    }

    public Lieu prendreRueAleatoir() {
        prendreRue(carte.choisirRueAleatoirement(position));
        return position;
    }

    public List<Lieu> marcherAleatoirementJusqua(Lieu destination) {
        List<Lieu> lieuVisite = new ArrayList<>();
        lieuVisite.add(position);
        while (!position.equals(destination)) {
            lieuVisite.add(prendreRueAleatoir());
        }
        return lieuVisite;
    }
}

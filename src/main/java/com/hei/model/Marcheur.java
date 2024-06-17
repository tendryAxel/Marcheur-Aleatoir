package com.hei.model;

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

    public Trajet marcherAleatoirementJusqua(Lieu destination) {
        Trajet trajet = new Trajet(position);
        while (!position.equals(destination)) {
            trajet.addLieu(prendreRueAleatoir());
        }
        return trajet;
    }
}

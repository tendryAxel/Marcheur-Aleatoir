package com.hei.marcheur;

import com.hei.carte.Carte;
import com.hei.carte.Lieu;
import com.hei.carte.Rue;
import com.hei.carte.Trajet;

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
        position = rue.prendreRue(position.getId());
    }

    public Rue choisirRueAleatoirement(Lieu lieuDeDepart) {
        List<Rue> possibleChemin = carte.voirRueDisponible(lieuDeDepart);
        return possibleChemin.get((int) (possibleChemin.toArray().length * Math.random()));
    }

    public Lieu prendreRueAleatoir() {
        prendreRue(choisirRueAleatoirement(position));
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

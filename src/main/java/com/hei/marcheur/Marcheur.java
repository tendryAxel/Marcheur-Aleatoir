package com.hei.marcheur;

import com.hei.carte.Carte;
import com.hei.carte.Lieu;
import com.hei.carte.Rue;
import com.hei.carte.Trajet;

import java.util.List;

public class Marcheur {
    private Lieu position;

    public Marcheur(Lieu position) {
        this.position = position;
    }

    public Lieu getPosition() {
        return position;
    }

    public void prendreRue(Rue rue) {
        position = rue.prendreRue(position.getId());
    }

    public Rue choisirRueAleatoirement(List<Rue> possibleChemin) {
        return possibleChemin.get((int) (possibleChemin.toArray().length * Math.random()));
    }

    public Lieu prendreRueAleatoir(List<Rue> possibleChemin) {
        prendreRue(choisirRueAleatoirement(possibleChemin));
        return position;
    }

    public Trajet marcherAleatoirementJusqua(Lieu destination, Carte carte) {
        Trajet trajet = new Trajet(position);
        while (!position.equals(destination)) {
            trajet.addLieu(prendreRueAleatoir(carte.voirRueDisponible(position)));
        }
        return trajet;
    }
}

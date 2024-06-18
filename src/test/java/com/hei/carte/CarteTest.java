package com.hei.carte;

import com.hei.marcheur.Marcheur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarteTest {

    @Test
    void addRue() {
        var HEI = new Lieu(1,"hei");
        var Pullman = new Lieu(2,"pullman");
        var Balancoire = new Lieu(3,"balancoire");

        var carte = new Carte();

        assertDoesNotThrow(()->{
            carte.addRue(new Rue(HEI, Pullman));
            carte.addRue(new Rue(Pullman, Balancoire));
            carte.addRue(new Rue(HEI, Balancoire));
        });
    }

    @Test
    void choisirRueAleatoirement() {
        var HEI = new Lieu(1,"hei");
        var Pullman = new Lieu(2,"pullman");
        var Balancoire = new Lieu(3,"balancoire");
        var ESTI = new Lieu(4,"ESTI");
        var Marais = new Lieu(5,"Marais");
        var Sekolintsika = new Lieu(6,"Sekolintsika");
        var Nexta = new Lieu(7,"Nexta");

        var carte = new Carte();
        var marcheur = new Marcheur(HEI);

        carte.addRue(new Rue(Marais, Sekolintsika));
        carte.addRue(new Rue(HEI, Sekolintsika));
        carte.addRue(new Rue(HEI, Pullman));
        carte.addRue(new Rue(HEI, Balancoire));
        carte.addRue(new Rue(Nexta, Pullman));
        carte.addRue(new Rue(ESTI, Balancoire));

        for (int i = 0; i <10; i++) {
            marcheur.prendreRueAleatoir(carte.voirRueDisponible(marcheur.getPosition()));
        }
    }

    @Test
    void marcherAleatoirementJusqua() {
        // Creation de la carte
        var HEI = new Lieu(1,"hei");
        var Pullman = new Lieu(2,"pullman");
        var Balancoire = new Lieu(3,"balancoire");
        var ESTI = new Lieu(4,"ESTI");
        var Marais = new Lieu(5,"Marais");
        var Sekolintsika = new Lieu(6,"Sekolintsika");
        var Nexta = new Lieu(7,"Nexta");
        var Boulevard = new Lieu(8,"Boulevard");

        var carte = new Carte();

        carte.addRue(new Rue(Marais, Sekolintsika));
        carte.addRue(new Rue(HEI, Sekolintsika));
        carte.addRue(new Rue(HEI, Pullman));
        carte.addRue(new Rue(HEI, Balancoire));
        carte.addRue(new Rue(Nexta, Pullman));
        carte.addRue(new Rue(Balancoire, Pullman));
        carte.addRue(new Rue(ESTI, Balancoire));
        carte.addRue(new Rue(Boulevard, ESTI));
        carte.addRue(new Rue(Boulevard, Balancoire));

        // Creation du marcheur
        var marcheur = new Marcheur(HEI);
        var trajet = marcheur.marcherAleatoirementJusqua(ESTI, carte);

        // Test
        System.out.println(trajet);
        assertEquals(ESTI, trajet.getArrive());
        assertTrue(trajet.longueurDuTrajet() >= 3);
    }
}
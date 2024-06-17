package com.hei.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarcheurTest {

    @Test
    void prendreRue() {
        var HEI = new Lieu(1,"hei");
        var Pullman = new Lieu(2,"pullman");
        var Balancoire = new Lieu(3,"balancoire");

        var carte = new Carte();
        var marcheur = new Marcheur(HEI, carte);

        var rue1 = new Rue(HEI, Pullman);

        carte.addRue(rue1);
        carte.addRue(new Rue(Pullman, Balancoire));
        carte.addRue(new Rue(HEI, Balancoire));

        marcheur.prendreRue(rue1);
        assertEquals(Pullman, marcheur.getPosition());
    }
}
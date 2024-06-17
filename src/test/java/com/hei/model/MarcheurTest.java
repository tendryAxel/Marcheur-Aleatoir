package com.hei.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarcheurTest {

    @Test
    void prendreRue() {
        var HEI = new Lieu(1,"hei");
        var Pullman = new Lieu(2,"pullman");
        var Balancoire = new Lieu(3,"balancoire");

        var carte = new Carte(new Marcheur(HEI));

        var rue1 = new Rue(HEI, Pullman);

        carte.addRue(rue1);
        carte.addRue(new Rue(Pullman, Balancoire));
        carte.addRue(new Rue(HEI, Balancoire));

        carte.getMarcheur().prendreRue(rue1);
        assertEquals(Pullman, carte.getMarcheur().getPosition());
    }
}
package com.hei.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarteTest {

    @Test
    void addRue() {
        var HEI = new Lieu(1,"hei");
        var Pullman = new Lieu(2,"pullman");
        var Balancoire = new Lieu(3,"balancoire");

        var carte = new Carte(new Marcheur(HEI));

        assertDoesNotThrow(()->{
            carte.addRue(new Rue(HEI, Pullman));
            carte.addRue(new Rue(Pullman, Balancoire));
            carte.addRue(new Rue(HEI, Balancoire));
        });
    }
}
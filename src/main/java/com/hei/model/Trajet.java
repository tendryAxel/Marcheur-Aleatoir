package com.hei.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trajet {
    private final List<Lieu> lieux;

    public Trajet(Lieu depart) {
        this.lieux = new ArrayList<>();
        addLieu(depart);
    }

    public void addLieu(Lieu lieu) {
        this.lieux.add(lieu);
    }

    public Lieu getArrive() {
        return lieux.getLast();
    }

    public int longueurDuTrajet() {
        return lieux.size();
    }

    @Override
    public String toString() {
        return "Trajet{\n\t" +
                lieux.stream()
                        .map(Lieu::toString)
                        .collect(Collectors.joining("\n\t")) +
                "\n}";
    }
}

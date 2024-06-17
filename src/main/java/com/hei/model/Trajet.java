package com.hei.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trajet {
    private final List<Lieu> lieux;

    public Trajet() {
        this.lieux = new ArrayList<>();
    }

    public Trajet(Lieu depart) {
        this.lieux = new ArrayList<>();
        addLieu(depart);
    }

    public Trajet addLieu(Lieu lieu) {
        this.lieux.add(lieu);
        return this;
    }

    public List<Lieu> getLieux() {
        return lieux;
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

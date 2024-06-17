package com.hei.model;

public class Lieu {
    private final int id;
    private final String name;

    public Lieu(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

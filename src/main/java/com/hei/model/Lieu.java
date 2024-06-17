package com.hei.model;

import java.util.Objects;

public class Lieu {
    private final int id;
    private final String name;

    public Lieu(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Lieu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lieu lieu = (Lieu) o;
        return id == lieu.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}

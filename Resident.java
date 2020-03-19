package com.company;

import java.util.Objects;

public class Resident extends Element implements Comparable<Resident> {
    public Resident(String name) {
        setName(name);
        this.preferences = new Partition();
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Resident element = (Resident) obj;
        return getName().equals(element.getName());
    }

    @Override
    public int compareTo(Resident o) {
        return getName().compareTo(o.getName());
    }
}

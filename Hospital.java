package com.company;

import sun.util.locale.provider.HostLocaleProviderAdapterImpl;

import java.util.Objects;

public class Hospital extends Element implements Comparable<Hospital>{
    private int capacity;

    public Hospital(String name) {
        setName(name);
        capacity = 1;
        this.preferences = new Partition();
    }

    public void setCapacity(int c) {
        capacity = c;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Hospital element = (Hospital) obj;
        return getName().equals(element.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCapacity());
    }

    @Override
    public int compareTo(Hospital o) {
        return getName().compareTo(o.getName());
    }
}

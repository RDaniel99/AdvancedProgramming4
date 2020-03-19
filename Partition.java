package com.company;

import java.util.List;
import java.util.Vector;

public class Partition {
    private Vector<Element> preferences;

    public Partition() {
        preferences = new Vector<Element>();
    }

    public void addPreference(Element element) {
        preferences.add(element);
    }

    public int getPreferenceCount() {
        return preferences.size();
    }

    public Element getPreferenceByIndex(int index) {
        if(index < 0 || index >= getPreferenceCount()) {
            return null;
        }

        return preferences.get(index);
    }

    public void addPreferences(List<Element> a) {
        preferences.addAll(a);
    }
}

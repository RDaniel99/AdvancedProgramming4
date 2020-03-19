package com.company;

public class Element {
    public Partition preferences;
    private String name;

    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Element element = (Element) obj;
        return getName().equals(element.getName());
    }

    public int searchForElementInPreference(Element element) {
        for(int i = 0; i < preferences.getPreferenceCount(); i++) {
            if(element == preferences.getPreferenceByIndex(i)) {
                return i;
            }
        }

        return preferences.getPreferenceCount();
    }
}

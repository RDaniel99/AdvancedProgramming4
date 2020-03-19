package com.company;

import javafx.util.Pair;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Matching {
    private List<Resident> residentList;
    private List<Hospital> hospitalList;
    private List<Pair<Hospital, Resident> > solution;

    private boolean hasAnswer;

    public Matching() {
        solution = new ArrayList<Pair<Hospital, Resident> >();
    }

    public void setResidentList(List<Resident> residents) {
        residentList = residents;
    }

    public void setHospitalList(List<Hospital> hospitals) {
        hospitalList = hospitals;
    }

    public boolean getHasAnswer() {
        return hasAnswer;
    }

    public void startMatch() {
        hasAnswer = true;
        for (Resident resident : residentList) {
            boolean flag = false;
            for (int j = 0; j < resident.preferences.getPreferenceCount(); j++) {
                Hospital h = (Hospital) resident.preferences.getPreferenceByIndex(j);
                if (h.getCapacity() > 0) {
                    Pair<Hospital, Resident> pair = new Pair<Hospital, Resident>(h, resident);
                    solution.add(pair);
                    h.setCapacity(h.getCapacity() - 1);
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                hasAnswer = false;
                break;
            }
        }
    }

    public boolean isStable() {
        for(int i = 0; i < solution.size(); i++) {
            Resident r = solution.get(i).getValue();
            Hospital h = solution.get(i).getKey();

            // r assigned to h
            for(int j = 0; j < r.preferences.getPreferenceCount(); j++) {
                Hospital hprim = (Hospital) r.preferences.getPreferenceByIndex(j);
                if(hprim == h) {
                    break;
                }

                // r wanted hprim more than h
                int posR = hprim.searchForElementInPreference((Element) r);

                for (Pair<Hospital, Resident> hospitalResidentPair : solution) {
                    if (hospitalResidentPair.getKey() != hprim) continue;

                    Resident rprim = hospitalResidentPair.getValue();
                    int posRPrim = hprim.searchForElementInPreference((Element) rprim);
                    if(posRPrim > posR) {
                        // hprim wanted r more than rprim and rprim is assigned to hprim
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public void printSolution() {
        for (Pair<Hospital, Resident> hospitalResidentPair : solution) {
            System.out.println(hospitalResidentPair.getValue() + " -> " + hospitalResidentPair.getKey());
        }
    }
}

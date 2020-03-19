package com.company;

import java.util.List;

public class Problem {
    private Matching matching;

    public Problem() {
        matching = new Matching();
    }

    public void setResidentList(List<Resident> residents) {
       matching.setResidentList(residents);
    }

    public void setHospitalList(List<Hospital> hospitals) {
        matching.setHospitalList(hospitals);
    }

    public void tryMatch() {
        matching.startMatch();

        if(matching.getHasAnswer()) {
            System.out.println("The problem has an answer");

            if(matching.isStable()) {
                System.out.println("The matching is stable");
            }
            else {
                System.out.println("The matching isn't stable");
            }

            matching.printSolution();
        }
        else {
            System.out.println("The problem hasn't any answer");
        }
    }
}

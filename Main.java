package com.company;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Faker faker = new Faker();

        Resident[] r = IntStream.rangeClosed(0, 3).mapToObj(i -> new Resident("R" + i)).toArray(Resident[]::new);
        Hospital[] h = IntStream.rangeClosed(0, 2).mapToObj(i -> new Hospital("H" + i)).toArray(Hospital[]::new);

        List<Resident> residentList = new ArrayList<>(Arrays.asList(r));
        List<Hospital> hospitalList = new ArrayList<>(Arrays.asList(h));

        Map<Resident, List<Hospital>> residentPreferences = new HashMap<>();
        residentPreferences.put(residentList.get(0), Arrays.asList(h[0], h[1], h[2]));
        residentList.get(0).preferences.addPreferences(Arrays.asList(h[0], h[1], h[2]));

        residentPreferences.put(residentList.get(1), Arrays.asList(h[0], h[1], h[2]));
        residentList.get(1).preferences.addPreferences(Arrays.asList(h[0], h[1], h[2]));

        residentPreferences.put(residentList.get(2), Arrays.asList(h[0], h[1]));
        residentList.get(2).preferences.addPreferences(Arrays.asList(h[0], h[1]));

        residentPreferences.put(residentList.get(3), Arrays.asList(h[0], h[2]));
        residentList.get(3).preferences.addPreferences(Arrays.asList(h[0], h[2]));

        Map<Hospital,List<Resident>> hospitalPreferences = new TreeMap<>();
        hospitalPreferences.put(h[1], Arrays.asList(r[0], r[1], r[2]));
        hospitalList.get(1).preferences.addPreferences(Arrays.asList(r[0], r[1], r[2]));

        hospitalPreferences.put(h[2], Arrays.asList(r[0], r[1], r[3]));
        hospitalList.get(2).preferences.addPreferences(Arrays.asList(r[0], r[1], r[3]));

        hospitalPreferences.put(h[0], Arrays.asList(r[3], r[0], r[1], r[2]));
        hospitalList.get(0).preferences.addPreferences(Arrays.asList(r[3], r[0], r[1], r[2]));

        hospitalList.get(1).setCapacity(2);
        hospitalList.get(2).setCapacity(2);

        System.out.println("Residents:");
        for(Resident res: r) {
            res.setName("R-" + faker.name().firstName());
            System.out.println(res.getName());
        }

        System.out.println("Hospitals:");
        for(Hospital hosp: h) {
            hosp.setName("H-" + faker.name().lastName());
            System.out.println(hosp.getName());
        }

        /*System.out.println("Queries results:");
        System.out.println("All residents that contain H0 and H2");
        List<Hospital> target = Arrays.asList(h[0], h[2]);
        residentList.stream().filter(res -> residentPreferences.get(res).containsAll(target)).forEach(System.out::println);

        System.out.println("All hospitals that have R0 as their top preference");
        hospitalPreferences.entrySet().stream()
                .filter(hospitalListEntry -> hospitalListEntry.getValue().toArray()[0].equals(residentList.get(0)))
                .forEach(System.out::println);*/

        Problem pb = new Problem();
        pb.setHospitalList(hospitalList);
        pb.setResidentList(residentList);

        pb.tryMatch();
    }
}

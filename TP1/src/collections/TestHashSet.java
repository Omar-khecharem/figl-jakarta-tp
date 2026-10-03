package collections;

import java.util.HashSet;
import java.util.Set;

public class TestHashSet {

    public static void main(String[] args) {
        Set<String> countriesSet = new HashSet<>();
        countriesSet.add("USA");
        countriesSet.add("China");
        countriesSet.add("Japan");
        countriesSet.add("Germany");
        countriesSet.add("France");

        System.out.println("Taille de l'ensemble : " + countriesSet.size());

        System.out.println("Affichage de l'ensemble :");
        displaySet(countriesSet);

        if (countriesSet.contains("Germany")) {
            countriesSet.remove("Germany");
            countriesSet.add("Tunisia");
        }

        System.out.println("Après modification :");
        displaySet(countriesSet);

        countriesSet.clear();
        System.out.println("Taille après clear : " + countriesSet.size());
    }

    private static void displaySet(Set<String> set) {
        for (String s : set) {
            System.out.println(s);
        }
    }
}

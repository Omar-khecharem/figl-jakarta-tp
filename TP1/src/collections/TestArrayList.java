package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestArrayList {

    public static void main(String[] args) {
        List<String> countries_list = new ArrayList<>();
        countries_list.add("USA");
        countries_list.add("China");
        countries_list.add("Japan");
        countries_list.add("Germany");
        countries_list.add("France");

        System.out.println("Taille de la liste : " + countries_list.size());

        System.out.println("Affichage de la liste :");
        displayList(countries_list);

        countries_list.set(3, "Tunisia");

        Collections.sort(countries_list);
        System.out.println("Après tri :");
        displayList(countries_list);

        countries_list.clear();
        System.out.println("Taille après clear : " + countries_list.size());
    }

    private static void displayList(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }
}

import java.util.ArrayList;
//import java.util.Collections; // Needed before Java 8
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Guilherme
 */
public class SortStrings {
    public static void main(String[] args){
        List<String> phrases = new ArrayList<>();
        phrases.add("big phrase");
        phrases.add("phrase");
        phrases.add("bigger phrase");
        
//        Needed before Java 8
//        Collections.sort(phrases, comparator); // A new Comparator class would be needed to be created
        phrases.sort((o1, o2) -> Integer.compare(o1.length(), o2.length()));
        //or
        phrases.sort(Comparator.comparing(s -> s.length()));
        //or
        phrases.sort(Comparator.comparing(String::length));
        
        phrases.sort(Comparator.comparing(String::toString));
        
//        Needed before Java 8
//        for(String phrase:phrases){
//            System.out.println(phrase);
//        }
        phrases.forEach(t -> System.out.println(t));
        //or
        phrases.forEach(System.out::println);
    }
}
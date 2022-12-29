package functionalexamples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapExample {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Sergio","Sunil","Paul","Ana","Michelle");

        List<String> longNamesUpperCase = names.stream()
                .filter(name -> name.length() > 3)
                .map(name -> name.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(longNamesUpperCase);
    }

}

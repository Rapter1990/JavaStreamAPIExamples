package functionalexamples;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class SortedDistinctFlow {

    public static void main(String[] args) {

        Locale.setDefault(Locale.forLanguageTag("en-US"));

        List<String> names = Arrays.asList("Sergio","Sunil","Ana","Michelle",
                "Sunil","Sergio","Anita");

        List<String> result =

                names.stream()
                        .peek(e->System.out.println("Going to filter: " + e))
                        .filter(name -> name.length() >3)
                        .peek(e->System.out.println("Going to distinct: " + e))
                        .distinct()
                        .peek(e->System.out.println("Going to sort: " + e))
                        .sorted()
                        .peek(e->System.out.println("Done with sorting: " + e))
                        // .peek(e->System.out.println("Going to take distinct elements: " + e))
                        // .distinct()
                        // .peek(e -> System.out.println("Done with distinct"))
                        .peek(e->System.out.println("Going to map: " + e))
                        .map(name -> name.toUpperCase())
                        .peek(e->System.out.println("Going to collect: " + e))
                        .collect(Collectors.toList());

        System.out.println("Result is "+result);
        System.out.println("Original list is "+names);
    }
}

package functionalexamples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortedDistinctExample {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Sergio","Sunil","Paul","Ana","Michelle",
                "Sunil","Sergio","Anita");

        List<String> sortedNames = fetchLongNamesSorted(names);
        System.out.println("Names sorted :"+sortedNames);

        List<String> sortedDistinctNames = fetchDistinctLongNamesUpper(names);
        System.out.println("Distinct names sorted :"+sortedDistinctNames);

    }

    /**
     * Example showing sorted method on stream.Filter names with length >3 and
     * sort them.
     * @param names - List of names
     * @return - List of names having length > 3 and sorted alphabetically.
     */
    public static List<String> fetchLongNamesSorted(List<String> names) {
        return names.stream()
                .filter(name -> name.length() > 3)
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<String> fetchDistinctLongNamesUpper(List<String> names) {
        return names.stream()
                .filter(name -> name.length() > 3)
                .distinct()
                .map(name -> name.toUpperCase())
                .collect(Collectors.toList());
    }

}

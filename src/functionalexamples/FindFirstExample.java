package functionalexamples;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class FindFirstExample {

    public static void main(String[] args) {

        List<Integer> numbersList = List.of(5,1022,23,324,61,2);
        System.out.println("List elements " + numbersList);

        Optional<Integer> element = numbersList.stream()
                .filter(n -> n%2 == 0)
                .findFirst();

        System.out.println("From list : " +element.orElseThrow());

        Set<Integer> numbersSet = Set.of(5,1022,23,324,62,2);

        System.out.println("Set elements " + numbersSet);
        Optional<Integer> elementSet = numbersSet.stream()
                .sorted()
                .filter(n -> n%2 == 0)
                .findFirst();
        System.out.println("From set : " +elementSet.orElseThrow());

    }

}

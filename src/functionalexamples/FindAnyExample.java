package functionalexamples;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class FindAnyExample {

    public static void main(String[] args) {

        //If the stream has no encounter order, then any element may be returned

        List<Integer> numberList = List.of(1,2,3,4,5,6,7,8,9,10);

        System.out.println("Encounter Order List "+numberList);

        Optional<Integer> firstEven = numberList.stream()
                .filter( n -> n % 2 == 0)
                .findAny();

        System.out.println("Number list : " + firstEven.orElse(0));

        Set<Integer> numberSet = Set.of(1,2,3,4,5,6,7,8,9,10);
        System.out.println("Encounter Order Set"+numberSet);

        Optional<Integer> firstEvenSet = numberSet.stream()
                .peek(System.out::println)
                .filter( n -> n % 2 == 0)
                .findAny();

        System.out.println("Number Set : " + firstEvenSet.orElse(0));


    }

}

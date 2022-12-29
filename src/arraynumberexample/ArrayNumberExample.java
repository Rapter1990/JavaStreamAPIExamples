package arraynumberexample;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayNumberExample {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,7,8,9,5,2,36,4,78,222,24,9);

        // Exercise 1 : Given a list of numbers, return the sum of all numbers.
        sumOfAllNumbers(list);

        // Exercise 2 : Given a list of numbers, return the average of all numbers
        averageOfAllNumbers(list);

        // Exercise 3 : Given a list of numbers, square them and filter the numbers which are greater 100 and then find the average of them
        getNumbersSquareAndFilterAndAverage(list);

        // Exercise 4 : Given a list of numbers, return the even and odd numbers separately
        getNumbersEvenAndOddSeperately(list);

        // Exercise 5 : Given a list of numbers, find out all the numbers starting with 2
        getNumbersStartingWith2(list);

        // Exercise 6 : Given a list of numbers, print the duplicate numbers
        getDuplicateNumbers(list);

        // Exercise 7 : Given a list of numbers, print the maximum and minimum values
        getMaxAndMinValueInList(list);

        // Exercise 8 : Given a list of numbers, sort them in ASC and DESC order and print
        sortNumbersByASCandDESC(list);

        // Exercise 9 : Given a list of numbers, return the first 5 elements and their sum
        getFirst5ElementsAndSum(list);

        // Exercise 10 : Given a list of numbers, skip first 5 numbers and return the sum of remaining numbers
        getSumAfter5Numbers(list);

        // Exercise 11 : Given a list of numbers, return the cube of each number
        getCubeOfEachNumber(list);

    }

    private static void getCubeOfEachNumber(List<Integer> list) {
        List<Integer> cubes = list.stream().map(num -> num*num*num).collect(Collectors.toList());
        System.out.println("Exercise 11 : Cubes: "+cubes);

        // Exercise 11 : Cubes:  [1, 343, 512, 729, 125, 8, 46656, 64, 474552, 10941048, 13824, 729]
    }

    private static void getSumAfter5Numbers(List<Integer> list) {
        int sum1 = list.stream().skip(5).reduce((a,b) -> a+b).get();
        System.out.println("Exercise 10 : Sum after first 5 elements skip: "+sum1);

        // Exercise 10 : Sum after first 5 elements skip: 375
    }

    private static void getFirst5ElementsAndSum(List<Integer> list) {

        List<Integer> first5elements = list.stream().limit(5).collect(Collectors.toList());
        System.out.println("Exercise 9 : first5elements: "+first5elements);

        // Exercise 9 : first5elements: first5elements: [1, 7, 8, 9, 5]

        int first5sum = list.stream().limit(5).reduce((a,b) -> a+b).get();
        System.out.println("Exercise 9 : First way : first5elementsSum: "+first5sum);

        // Exercise 9 : First way : first5elementsSum:  30

        int sumSecondWay = list.stream().limit(5).reduce(0, Integer::sum);
        System.out.println("Exercise 9 : Second way : first5elementsSum: " + sumSecondWay);

        // Exercise 9 : Second way : first5elementsSum:  30
    }

    private static void sortNumbersByASCandDESC(List<Integer> list) {
        List<Integer> asc_order = list.stream().sorted().collect(Collectors.toList());
        System.out.println("Exercise 8 : ASC Order: "+asc_order);

        // Exercise 8 : ASC Order:  [1, 2, 4, 5, 7, 8, 9, 9, 24, 36, 78, 222]

        List<Integer> desc_order = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println("Exercise 8 : DESC Order: "+desc_order);

        // Exercise 8 : DESC Order:  [222, 78, 36, 24, 9, 9, 8, 7, 5, 4, 2, 1]
    }

    private static void getMaxAndMinValueInList(List<Integer> list) {

        int max = list.stream().max(Comparator.comparing(Integer::valueOf)).get();
        System.out.println("Exercise 7 : Maximum Value: "+max);

        // Exercise 7 : Maximum Value: 222

        int min = list.stream().min(Comparator.comparing(Integer::valueOf)).get();
        System.out.println("Exercise 7 : Minimum Value: "+min);

        // // Exercise 7 : Minimum Value: 1
    }

    private static void getDuplicateNumbers(List<Integer> list) {
        Set<Integer> duplicates = list.stream().filter(num -> Collections.frequency(list,num) > 1).collect(Collectors.toSet());
        System.out.println("Exercise 6 : First way : duplicates: "+duplicates);

        // Exercise 6 : First way : duplicates:  duplicates:  [9]

        Set<Integer> duplicates1 = new HashSet<>();
        Set<Integer> dup = list.stream().filter(num -> !duplicates1.add(num)).collect(Collectors.toSet());
        System.out.println("Exercise 6 : Second way : duplicates: "+dup);

        // Exercise 6 : Second way : duplicates:   [9]
    }

    private static void getNumbersStartingWith2(List<Integer> list) {

        List<Integer> startsWith2 = list.stream().map(num -> String.valueOf(num)).filter(num -> num.startsWith("2")).map(Integer::valueOf).collect(Collectors.toList());

        System.out.println("Exercise 5 : startsWith2: "+startsWith2);

        // Exercise 5 : startsWith2:  [2, 222, 24]

    }

    private static void getNumbersEvenAndOddSeperately(List<Integer> list) {
        List<Integer> evens = list.stream().filter(num->num%2==0).collect(Collectors.toList());
        System.out.println("Exercise 4 : evens: "+ evens);

        // Exercise 4 : evens:  [8, 2, 36, 4, 78, 222, 24]

        List<Integer> odds = list.stream().filter(num -> num%2!=0).collect(Collectors.toList());
        System.out.println("Exercise 4 : odds: "+ odds);

        // Exercise 4 : odds:  [1, 7, 9, 5, 9]
    }

    private static void getNumbersSquareAndFilterAndAverage(List<Integer> list) {
        double avg1 = list.stream().map(a->a*a).filter(num -> num > 100).mapToInt(a->a).average().orElse(0);
        System.out.println("Exercise 3 : average is: "+avg1);

        // Exercise 3 : average is:  14310.0
    }

    private static void averageOfAllNumbers(List<Integer> list) {
        double avg = list.stream().mapToInt(a->a).average().orElse(0);
        System.out.println("Exercise 2 : average is: "+avg);

        // Exercise 2 : average is:  33.75
    }

    private static void sumOfAllNumbers(List<Integer> list) {

        Optional<Integer> sum = list.stream().reduce((a, b) -> a+b);
        System.out.println("Exercise 1 : First way : sum is: "+sum.get());

        int sumSecondWay = list.stream().reduce(0, Integer::sum);
        System.out.println("Exercise 1 : Second way : sum is: " + sumSecondWay);

        // Exercise 1 : First way : sum is:  sum is: 405
        // Exercise 1 : Second way : sum is:  405
    }

}

package functionalexamples;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.ToIntFunction;

public class MethodReferenceExample {

    public static void main(String[] args) {

        methodReferenceInstanceMethodViaObject();

        methodReferenceInstanceMethodViaClass();

    }

    private static void methodReferenceInstanceMethodViaClass() {
        System.out.println("Method reference to instance method of arbitary type");

        String input = "Lambdas";

        //1.Length of string
        ToIntFunction<String> lengthLambdas = (String s) -> s.length();
        ToIntFunction<String> lengthMethodReference = String::length;

        System.out.println("Length of string using Lambda: "+lengthLambdas.applyAsInt(input));
        System.out.println("Length of string using MR: "+lengthMethodReference.applyAsInt(input));

        // 2.Find substring

        BiFunction<String, Integer, String> substringLambdas = (text, position) -> text.substring(position);
        BiFunction<String, Integer, String> substringMethodReference = String::substring;


        System.out.println("Substring using Lambdas : "+substringLambdas.apply(input, 3));
        System.out.println("Substring using MR : "+substringMethodReference.apply(input, 3));
    }

    private static void methodReferenceInstanceMethodViaObject() {

        //1.
        Consumer<String> printLambda = (s) -> System.out.println(s);
        Consumer<String> printMR = System.out::println;

        //2.
        List<String> list = Arrays.asList("a","b","c","d","e");
        list.forEach(System.out::println);
    }
}

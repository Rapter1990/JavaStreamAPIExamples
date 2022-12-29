package functionalexamples;

import java.util.Locale;
import java.util.function.Function;

public class FunctionExample {

    static Function<String,String> upperCase =  (name) -> name.toUpperCase();

    static Function<String,String> addSomeString =  (name) -> name.toUpperCase().concat("Something");

    static Function<String,Integer> strLength =  (name) -> name.length();

    public static void main(String[] args) {

        Locale.setDefault(Locale.forLanguageTag("en-US"));

        System.out.println("Result is : " + upperCase.apply("Stream"));

        System.out.println("Result of andthen : " + upperCase.andThen(addSomeString).apply("Stream"));

        System.out.println("Result of compose : " + upperCase.compose(addSomeString).apply("Stream"));

        System.out.println("Result of strLength : " + strLength.apply("Stream"));

        // Always returns its input argument
        Function<String,String> abc = Function.identity();

        System.out.println(abc.apply("Stream"));

        /*
            Result is : STREAM
            Result of andthen : STREAMSomething
            Result of compose : STREAMSOMETHING
            Result of strLength : 6
            Stream
         */
    }
}

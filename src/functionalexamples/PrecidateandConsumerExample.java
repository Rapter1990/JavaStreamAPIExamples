package functionalexamples;

import studentdata.Student;
import studentdata.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PrecidateandConsumerExample {

    static Predicate<Student> p1 = (s) -> s.getGradeLevel()>=3;

    static Predicate<Student> p2 = (s) -> s.getGpa()>=3.9;

    public static void main(String[] args) {

        getStudentsFilteredBy(p1.and(p2));
    }

    public static void getStudentsFilteredBy(Predicate<Student> predicatefilter) {

        List<Student> studentList = StudentDataBase.getAllStudents();

        BiConsumer<String, List<String>> studentBiConsumer = (name, activities) -> System.out.println(name + " : " + activities);

        Consumer<Student> studentConsumer = (student) -> {

            if(predicatefilter.test(student)){
                studentBiConsumer.accept(student.getName(),student.getActivities());
            }
        };

        studentList.forEach(studentConsumer);

        /*
            Janet : [swimming, gymnastics, aerobics]
            Dave : [swimming, gymnastics, soccer]
            James : [swimming, basketball, baseball, football]
         */
    }


}

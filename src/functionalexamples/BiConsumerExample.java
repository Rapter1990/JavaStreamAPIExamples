package functionalexamples;

import studentdata.Student;
import studentdata.StudentDataBase;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {

    public static void main(String[] args) {
        nameAndActivities();
    }

    public static void nameAndActivities(){

        BiConsumer<String, List<String>> studentBiConsumer = (name, activities) -> System.out.println(name + " : " + activities);

        List<Student> students = StudentDataBase.getAllStudents();

        students.forEach((s) -> studentBiConsumer.accept(s.getName(),s.getActivities()));

        /*

            Tomas : [swimming, basketball, volleyball]
            Emily : [swimming, gymnastics, soccer]
            Janet : [swimming, gymnastics, aerobics]
            Dave : [swimming, gymnastics, soccer]
            Sophie : [swimming, dancing, football]
            James : [swimming, basketball, baseball, football]

         */
    }
}

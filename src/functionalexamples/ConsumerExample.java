package functionalexamples;

import studentdata.Student;
import studentdata.StudentDataBase;

import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

public class ConsumerExample {

    static Consumer<Student> c1= p -> System.out.println(p);

    static Consumer<Student>  c2= p -> System.out.print(p.getName().toUpperCase());

    static Consumer<Student>  c3= p -> System.out.println(p.getActivities());

    public static void main(String[] args) {

        Locale.setDefault(Locale.forLanguageTag("en-US"));

        printName();
        printNameAndActivities();
        printNameAndActivitiesUsingCondition();
    }

    public static void printName(){

        List<Student> personList = StudentDataBase.getAllStudents();

        personList.forEach(c1);

        /*
            Student{name='Tomas', gradeLevel=2, gpa=3.6, gender='male', activities=[swimming, basketball, volleyball], notebooks=10}
            Student{name='Emily', gradeLevel=2, gpa=3.8, gender='female', activities=[swimming, gymnastics, soccer], notebooks=11}
            Student{name='Janet', gradeLevel=3, gpa=4.0, gender='female', activities=[swimming, gymnastics, aerobics], notebooks=12}
            Student{name='Dave', gradeLevel=3, gpa=4.0, gender='male', activities=[swimming, gymnastics, soccer], notebooks=15}
            Student{name='Sophie', gradeLevel=4, gpa=3.5, gender='female', activities=[swimming, dancing, football], notebooks=10}
            Student{name='James', gradeLevel=4, gpa=3.9, gender='male', activities=[swimming, basketball, baseball, football], notebooks=22}
         */
    }

    public static void printNameAndActivities(){
        System.out.println("printNameAndActivities : ");
        List<Student> personList = StudentDataBase.getAllStudents();
        personList.forEach(c2.andThen(c3));

        /*
            TOMAS[swimming, basketball, volleyball]
            EMILY[swimming, gymnastics, soccer]
            JANET[swimming, gymnastics, aerobics]
            DAVE[swimming, gymnastics, soccer]
            SOPHIE[swimming, dancing, football]
            JAMES[swimming, basketball, baseball, football]
         */
    }

    public static void printNameAndActivitiesUsingCondition(){
        System.out.println("printNameAndActivitiesUsingCondition : ");
        List<Student> personList = StudentDataBase.getAllStudents();
        personList.forEach((s) -> {
            if( s.getGradeLevel()>=3 && s.getGpa()>3.9){
                c2.andThen(c3).accept(s);
            }
        });

        /*

            JANET[swimming, gymnastics, aerobics]
            DAVE[swimming, gymnastics, soccer]

         */
    }
}

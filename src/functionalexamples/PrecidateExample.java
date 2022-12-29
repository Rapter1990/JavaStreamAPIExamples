package functionalexamples;

import studentdata.Student;
import studentdata.StudentDataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PrecidateExample {

    static Predicate<Student> p1 = (s) -> s.getGradeLevel()>=3;

    static Predicate<Student> p2 = (s) -> s.getGpa()>=3.9;

    public static void main(String[] args) {
        getStudentsFilteredBy(p1.and(p2));
    }

    public static void getStudentsFilteredBy(Predicate<Student> predicatefilter) {

        List<Student> students = StudentDataBase.getAllStudents();

        students.stream().filter(predicatefilter).forEach(System.out::println);

        /*
            Student{name='Janet', gradeLevel=3, gpa=4.0, gender='female', activities=[swimming, gymnastics, aerobics], notebooks=12}
            Student{name='Dave', gradeLevel=3, gpa=4.0, gender='male', activities=[swimming, gymnastics, soccer], notebooks=15}
            Student{name='James', gradeLevel=4, gpa=3.9, gender='male', activities=[swimming, basketball, baseball, football], notebooks=22}

         */

    }

}

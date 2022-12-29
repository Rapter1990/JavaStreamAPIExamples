package functionalexamples;

import employeedata.Designation;
import employeedata.Employee;
import employeedata.Skill;
import employeedata.Unit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

public class FilterConsumerPredicateExample {

    public static void main(String args[]) {

        // 1. Get a list of all employees in EDC.
        testEDCFilter();

        // 2.Get all the java developers.
        testJavaDevelopers();

        // 3. Get all senior professionals
        testSeniorProfessionals();

        // 4. Java developer in edc. Implement here.
        testJavaDevelopersInEDC();

        // 5. Sort By Name
        sortByName();

        // 6. Sort By InreasingExp and Name
        sortByInreasingExpAndThenName();

        // 7. Sort By DecreasingExp and Name
        sortByDecreasingExpAndThenName();

        // 8. get employees compared with their names
        getEmployees(Comparator.comparing(Employee::getName));
    }

    private static void testJavaDevelopersInEDC() {
        List<Employee> javaEdcEmployees = getEmployeesFilteredBy(edcFilter().and(javaFilter()));
        System.out.println("--------Java Developers in EDC--------");
        System.out.println(javaEdcEmployees);

        /*

            [Amit with 8 years of experience
            ]

         */

    }

    private static void testSeniorProfessionals() {
        int years = 10;
        List<Employee> seniorProfessionals = getEmployeesFilteredBy(seniorProfessionals(years));

        System.out.println("--------Senior Professionals-------");
        System.out.println(seniorProfessionals);

        /*

            [Jose with 15 years of experience
            , Pirlo with 13 years of experience
            ]
         */

    }

    private static void testJavaDevelopers() {

        List<Employee> javaDevelopers = getEmployeesFilteredBy(employee -> employee.getSkills().contains(Skill.JAVA));

        System.out.println("--------Java Developers--------");
        System.out.println(javaDevelopers);


        /*
            [
              Amit with 8 years of experience,
              Manoj with 3 years of experience
            ]

         */
    }

    private static void testEDCFilter() {

        List<Employee> edcEmployees = getEmployeesFilteredBy(edcFilter());

        System.out.println("--------EDC Employees--------");
        System.out.println(edcEmployees);

        /*

            [
                Amit with 8 years of experience,
                Rahul with 5 years of experience,
                Jose with 15 years of experience,
                Pirlo with 13 years of experience
            ]

         */
    }

    private static Predicate<Employee> seniorProfessionals(int years) {
        return employee -> employee.getExperience() > years;
    }

    private static Predicate<Employee> edcFilter() {
        return employee -> employee.getUnit() == Unit.EDC;
    }

    private static Predicate<Employee> javaFilter() {
        return employee -> employee.getSkills().contains(Skill.JAVA);
    }

    public static List<Employee> getEmployeesFilteredBy(Predicate<Employee> filter) {

        List<Employee> employees = initialize();

        return employees.stream().filter(filter).collect(Collectors.toList());

    }


    //retrieve a list of employees that are sorted alphabetically by name
    public static void sortByName(){

        System.out.println("--------sortByName--------");

        List<Employee> employees = initialize();

        List<Employee> filteredEmployees = employees.stream().sorted(BY_NAME_ALPHA).collect(Collectors.toList());

        System.out.println(filteredEmployees);

        /*

            [Amit with 8 years of experience
            , Jose with 15 years of experience
            , Manoj with 3 years of experience
            , Peter with 7 years of experience
            , Pirlo with 13 years of experience
            , Rahul with 5 years of experience
            , Stanley with 3 years of experience
            ]

         */

    }

    /**Sort the employees with increasing experience and if they have the same experience,
     then we sort them alphabetically by name.*/

    public static void sortByInreasingExpAndThenName(){

        System.out.println("--------sortByInreasingExpAndThenName--------");

        List<Employee> employees = initialize();

        List<Employee> filteredEmployees =employees.stream().sorted(BY_ASC_EXP_THEN_NAME).collect(Collectors.toList());

        System.out.println(filteredEmployees);

        /*

            [Manoj with 3 years of experience
            , Stanley with 3 years of experience
            , Rahul with 5 years of experience
            , Peter with 7 years of experience
            , Amit with 8 years of experience
            , Pirlo with 13 years of experience
            , Jose with 15 years of experience
            ]

         */

    }

    /**
     * Sort  the employees with decreasing experience
     * and if they have the same experience, then we sort them alphabetically by name.
     */
    public static void sortByDecreasingExpAndThenName(){

        System.out.println("--------sortByDecreasingExpAndThenName--------");

        List<Employee> employees = initialize();

        List<Employee> filteredEmployees =employees.stream().sorted(BY_DESC_EXP_THEN_NAME).collect(Collectors.toList());

        System.out.println(filteredEmployees);

        /*

            [Jose with 15 years of experience
            , Pirlo with 13 years of experience
            , Amit with 8 years of experience
            , Peter with 7 years of experience
            , Rahul with 5 years of experience
            , Manoj with 3 years of experience
            , Stanley with 3 years of experience
            ]

         */

    }

    /**
     * Exercise
     * Top 3 methods can be combined into one.
     * @param sorter - Pass behavior
     * @return -Sorted list.
     */
    public static void getEmployees(Comparator<Employee> sorter){

        System.out.println("--------getEmployees--------");

        List<Employee> employees = initialize();

        List<Employee> filteredEmployees =employees.stream().sorted(sorter).collect(Collectors.toList());

        System.out.println(filteredEmployees);

        /*

            [Amit with 8 years of experience
            , Jose with 15 years of experience
            , Manoj with 3 years of experience
            , Peter with 7 years of experience
            , Pirlo with 13 years of experience
            , Rahul with 5 years of experience
            , Stanley with 3 years of experience
            ]

         */
    }

    public static final Comparator<Employee> BY_NAME_ALPHA =
            comparing((Employee e) -> e.getName());


    // Comparator for sorting employee by experience.
    public static final Comparator<Employee> BY_EXPERIENCE =
            comparingInt((Employee e) -> e.getExperience());

    /**Sort the employees with increasing experience and if they have the same experience,
     then we sort them alphabetically by name.*/

    public static final Comparator<Employee> BY_ASC_EXP_THEN_NAME =
            BY_EXPERIENCE.thenComparing(BY_NAME_ALPHA);

    /**
     * Sort  the employees with decreasing experience
     * and if they have the same experience, then we sort them alphabetically by name.
     */
    public static final Comparator<Employee> BY_DESC_EXP_THEN_NAME =
            BY_EXPERIENCE.reversed().thenComparing(BY_NAME_ALPHA);

    public static List<Employee> initialize() {

        List<Employee> employees = new ArrayList<>();

        List<Skill> dev1Skills = new ArrayList<>();
        dev1Skills.add(Skill.JAVA);
        dev1Skills.add(Skill.JPA);

        // Amit is a developer with Java,Jpa
        employees.add(new Employee("Amit", 8, Designation.DEVELOPER, Unit.EDC, dev1Skills));

        // Rahul with .NET as a programmer
        List<Skill> dev2Skills = new ArrayList<>();
        dev2Skills.add(Skill.MICROSOFT);
        employees.add(new Employee("Rahul", 5, Designation.DEVELOPER, Unit.EDC, dev2Skills));

        // Peter with python as a programmer in FS
        List<Skill> dev3Skills = new ArrayList<>();
        dev3Skills.add(Skill.PYTHON);
        employees.add(new Employee("Peter", 7, Designation.DEVELOPER, Unit.FS, dev3Skills));

        // Stanley with angular/js as a programmer in oil gas
        List<Skill> dev4Skills = new ArrayList<>();
        dev4Skills.add(Skill.ANGULARJS);
        dev4Skills.add(Skill.JAVASCRIPT);
        employees.add(new Employee("Stanley", 3, Designation.DEVELOPER, Unit.OIL_GAS, dev4Skills));

        // Manoj with java and angular as a programmer in FS
        List<Skill> dev5Skills = new ArrayList<>();
        dev5Skills.add(Skill.ANGULARJS);
        dev5Skills.add(Skill.JAVA);
        employees.add(new Employee("Manoj", 3, Designation.DEVELOPER, Unit.FS, dev5Skills));

        // Jose as manager
        List<Skill> managerSkills = new ArrayList<>();
        managerSkills.add(Skill.PMP);
        employees.add(new Employee("Jose", 15, Designation.MANAGER, Unit.EDC, managerSkills));

        // Pirlo as architect in edc.
        List<Skill> architectSkills = new ArrayList<>();
        architectSkills.add(Skill.DESIGN);
        employees.add(new Employee("Pirlo", 13, Designation.ARCHITECT, Unit.EDC, architectSkills));

        return employees;
    }
}

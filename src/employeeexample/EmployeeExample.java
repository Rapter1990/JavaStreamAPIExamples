package employeeexample;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeExample {

    public static void main(String[] args) {

        List<Employee> employeeList = EmployeeLoadData.loadEmployee();

        // Exercise 1 : How many male and female employees are there in the organization?
        howManyMaleAndFemaleInTheOrganization(employeeList);

        // Exercise 2 : Print the name of all departments in the organization.
        printNameOfAllDepartmentsInTheOrganization(employeeList);

        // Exercise 3 : What is the average age of male and female employees?
        averageAgeOfAllMaleAndFemaleInTheOrganization(employeeList);

        // Exercise 4 : Get the details of highest paid employee in the organization
        getDetailsOfHighestReleasedEmployee(employeeList);

        // Exercise 5 : Get the names of all employees who have joined after 2015
        getNamesOfEmployeesWhoHaveJoinedAfter2015(employeeList);

        // Exercise 6 : Count the number of employees in each department
        countNumberEmployeeInEachDepartment(employeeList);

        // Exercise 7 : What is the average salary of each department?
        averageSalaryOfEachDepartment(employeeList);

        // Exercise 8 : Who has the most working experience in the organization?
        whoHasMostWorkingExperience(employeeList);

        // Exercise 9 : Get the details of youngest male employee in the each department.
        getDetailsOfYoungestMaleInEachDepartment(employeeList);

        // Exercise 10 : What is the average salary and total salary of the whole organization?
        whatIsTheAverageSalaryAndTotalSalaryOfWholeOrganization(employeeList);

        // Exercise 11 : Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years
        separateEmployeesFor25Years(employeeList);

        // Exercise 12 : Who is the oldest employee in the organization? What is his age and which department he belongs to?
        whoIsOldestEmployee(employeeList);

        // Exercise 13 : Find the second highest salary employee details
        findSecondHighestSalary(employeeList);

        // Exercise 14 : Get the maximum salary of an employee from each department
        getMaximumSalaryOfEmployeeFromEachDepartment(employeeList);

        // Exercise 15 : Get the employees count working in each department
        getEmployeesCountInEachDepartment(employeeList);

    }

    private static void getEmployeesCountInEachDepartment(List<Employee> employeeList) {
        Map<String, Long> noOfEmployeesInEachDepartment =
                employeeList.stream()
                        .collect(Collectors.groupingBy(Employee::getEmp_dept,Collectors.counting()));

        System.out.println("Exercise 15 : Employees in each department: "+ noOfEmployeesInEachDepartment);

        // Exercise 15 : Employees in each department: {Product Development=5, Security And Transport=2, Sales And Marketing=3, Infrastructure=3, HR=2, Account And Finance=2}
    }

    private static void getMaximumSalaryOfEmployeeFromEachDepartment(List<Employee> employeeList) {
        Map<String, Optional<Employee>> departmentWiseMaxSalary =
                employeeList.stream()
                        .collect(
                                Collectors.groupingBy(Employee::getEmp_dept,
                                Collectors.maxBy(Comparator.comparingDouble(Employee::getEmp_salary)))
                        );

        System.out.println("Exercise 14 : maximum salary of an employee from each department: "+departmentWiseMaxSalary);

        // Exercise 14 : maximum salary of an employee from each department:
        // {
        // Product Development=Optional[Employee{emp_id=277, emp_name='Anuj Chettiar', emp_age=31, emp_gender='Male', emp_dept='Product Development', emp_doj=2012, emp_salary=35700.0}],
        // Security And Transport=Optional[Employee{emp_id=200, emp_name='Jaden Dough', emp_age=38, emp_gender='Male', emp_dept='Security And Transport', emp_doj=2015, emp_salary=11000.5}],
        // Sales And Marketing=Optional[Employee{emp_id=122, emp_name='Paul Niksui', emp_age=25, emp_gender='Male', emp_dept='Sales And Marketing', emp_doj=2015, emp_salary=13500.0}],
        // Infrastructure=Optional[Employee{emp_id=133, emp_name='Martin Theron', emp_age=29, emp_gender='Male', emp_dept='Infrastructure', emp_doj=2012, emp_salary=18000.0}],
        // HR=Optional[Employee{emp_id=111, emp_name='Jiya Brein', emp_age=32, emp_gender='Female', emp_dept='HR', emp_doj=2011, emp_salary=25000.0}],
        // Account And Finance=Optional[Employee{emp_id=177, emp_name='Manu Sharma', emp_age=35, emp_gender='Male', emp_dept='Account And Finance', emp_doj=2010, emp_salary=27000.0}]
        // }
    }

    private static void findSecondHighestSalary(List<Employee> employeeList) {
        Optional<Employee> secondHighestSalaryEmployee =
                employeeList.stream()
                        .sorted(Comparator.comparingDouble(Employee::getEmp_salary).reversed())
                        .skip(1)
                        .findFirst();

        System.out.println("Exercise 13 : Second Highest Salary Employee: "+secondHighestSalaryEmployee.get());

        // Second Highest Salary Employee: Employee{emp_id=188, emp_name='Wang Liu', emp_age=31, emp_gender='Male', emp_dept='Product Development', emp_doj=2015, emp_salary=34500.0}
    }

    private static void whoIsOldestEmployee(List<Employee> employeeList) {
        Optional<Employee> oldestEmployee = employeeList.stream().max(Comparator.comparingInt(Employee::getEmp_age));
        System.out.println("Exercise 12 : Oldest employee in organization: "+ oldestEmployee.get().getEmp_name() +"  "+oldestEmployee.get().getEmp_age()+"  "+oldestEmployee.get().getEmp_dept());

        // Exercise 12 : Oldest employee in organization: Iqbal Hussain  43  Security And Transport
    }

    private static void separateEmployeesFor25Years(List<Employee> employeeList) {
        Map<Boolean, List<Employee>> partitionByAge =
                employeeList.stream()
                        .collect(Collectors.partitioningBy(e->e.getEmp_age() > 25));

        System.out.println("Exercise 11 : Partitioned employees: "+partitionByAge);

        // Partitioned employees: {
        // false=[Employee{emp_id=122, emp_name='Paul Niksui', emp_age=25, emp_gender='Male', emp_dept='Sales And Marketing', emp_doj=2015, emp_salary=13500.0}, Employee{emp_id=199, emp_name='Amelia Zoe', emp_age=24, emp_gender='Female', emp_dept='Sales And Marketing', emp_doj=2016, emp_salary=11500.0}, Employee{emp_id=222, emp_name='Nitin Joshi', emp_age=25, emp_gender='Male', emp_dept='Product Development', emp_doj=2016, emp_salary=28200.0}, Employee{emp_id=244, emp_name='Nicolus Den', emp_age=24, emp_gender='Male', emp_dept='Sales And Marketing', emp_doj=2017, emp_salary=10700.5}, Employee{emp_id=255, emp_name='Ali Baig', emp_age=23, emp_gender='Male', emp_dept='Infrastructure', emp_doj=2018, emp_salary=12700.0}],
        // true=[Employee{emp_id=111, emp_name='Jiya Brein', emp_age=32, emp_gender='Female', emp_dept='HR', emp_doj=2011, emp_salary=25000.0}, Employee{emp_id=133, emp_name='Martin Theron', emp_age=29, emp_gender='Male', emp_dept='Infrastructure', emp_doj=2012, emp_salary=18000.0}, Employee{emp_id=144, emp_name='Murali Gowda', emp_age=28, emp_gender='Male', emp_dept='Product Development', emp_doj=2014, emp_salary=32500.0}, Employee{emp_id=155, emp_name='Nima Roy', emp_age=27, emp_gender='Female', emp_dept='HR', emp_doj=2013, emp_salary=22700.0}, Employee{emp_id=166, emp_name='Iqbal Hussain', emp_age=43, emp_gender='Male', emp_dept='Security And Transport', emp_doj=2016, emp_salary=10500.0}, Employee{emp_id=177, emp_name='Manu Sharma', emp_age=35, emp_gender='Male', emp_dept='Account And Finance', emp_doj=2010, emp_salary=27000.0}, Employee{emp_id=188, emp_name='Wang Liu', emp_age=31, emp_gender='Male', emp_dept='Product Development', emp_doj=2015, emp_salary=34500.0}, Employee{emp_id=200, emp_name='Jaden Dough', emp_age=38, emp_gender='Male', emp_dept='Security And Transport', emp_doj=2015, emp_salary=11000.5}, Employee{emp_id=211, emp_name='Jasna Kaur', emp_age=27, emp_gender='Female', emp_dept='Infrastructure', emp_doj=2014, emp_salary=15700.0}, Employee{emp_id=233, emp_name='Jyothi Reddy', emp_age=27, emp_gender='Female', emp_dept='Account And Finance', emp_doj=2013, emp_salary=21300.0}, Employee{emp_id=266, emp_name='Sanvi Pandey', emp_age=26, emp_gender='Female', emp_dept='Product Development', emp_doj=2015, emp_salary=28900.0}, Employee{emp_id=277, emp_name='Anuj Chettiar', emp_age=31, emp_gender='Male', emp_dept='Product Development', emp_doj=2012, emp_salary=35700.0}]
        // }
    }

    private static void whatIsTheAverageSalaryAndTotalSalaryOfWholeOrganization(List<Employee> employeeList) {

        DoubleSummaryStatistics employeesTotalandAvgSalary =
                employeeList.stream()
                        .collect(Collectors.summarizingDouble(Employee::getEmp_salary));

        System.out.println("Average Salary of organization:  " + employeesTotalandAvgSalary.getAverage());
        System.out.println("Total Salary of organization:  "+employeesTotalandAvgSalary.getSum());

        // Exercise 10 : Average Salary of organization:  21141.235294117647
        // Exercise 10 : Total Salary of organization:  359401.0
    }

    private static void getDetailsOfYoungestMaleInEachDepartment(List<Employee> employeeList) {
        Map<String, Optional<Employee>> youngestEmployeesInEachDept =
                employeeList.stream()
                        .filter(e->e.getEmp_gender()=="Male")
                        .collect(
                                Collectors.groupingBy(Employee::getEmp_dept,
                                Collectors.maxBy(Comparator.comparingInt(Employee::getEmp_doj)))
                        );

        System.out.println("Exercise 9 : Youngest employee in each department: "+ youngestEmployeesInEachDept);

        // Exercise 9 : Youngest employee in each department: {Product Development=Optional[Employee{emp_id=222, emp_name='Nitin Joshi', emp_age=25, emp_gender='Male', emp_dept='Product Development', emp_doj=2016, emp_salary=28200.0}], Security And Transport=Optional[Employee{emp_id=166, emp_name='Iqbal Hussain', emp_age=43, emp_gender='Male', emp_dept='Security And Transport', emp_doj=2016, emp_salary=10500.0}], Sales And Marketing=Optional[Employee{emp_id=244, emp_name='Nicolus Den', emp_age=24, emp_gender='Male', emp_dept='Sales And Marketing', emp_doj=2017, emp_salary=10700.5}], Infrastructure=Optional[Employee{emp_id=255, emp_name='Ali Baig', emp_age=23, emp_gender='Male', emp_dept='Infrastructure', emp_doj=2018, emp_salary=12700.0}], Account And Finance=Optional[Employee{emp_id=177, emp_name='Manu Sharma', emp_age=35, emp_gender='Male', emp_dept='Account And Finance', emp_doj=2010, emp_salary=27000.0}]}
    }

    private static void whoHasMostWorkingExperience(List<Employee> employeeList) {
        Optional<Employee> mostWorkingExperience = employeeList.stream().min(Comparator.comparingInt(Employee::getEmp_doj));
        System.out.println("Exercise 8 : First Way : Most working experience: "+mostWorkingExperience);

        // Exercise 8 : First Way : Most working experience: Optional[Employee{emp_id=177, emp_name='Manu Sharma', emp_age=35, emp_gender='Male', emp_dept='Account And Finance', emp_doj=2010, emp_salary=27000.0}]

        Optional<Employee> mostWorkingExperience2 = employeeList.stream().sorted(Comparator.comparing(Employee::getEmp_doj)).findFirst();
        System.out.println("Exercise 8 : Second Way : Most working experience: "+mostWorkingExperience2);

        // Exercise 8 : Second Way : Most working experience: Optional[Employee{emp_id=177, emp_name='Manu Sharma', emp_age=35, emp_gender='Male', emp_dept='Account And Finance', emp_doj=2010, emp_salary=27000.0}]

    }

    private static void averageSalaryOfEachDepartment(List<Employee> employeeList) {
        Map<String, Double> avgSalaryOfEachDepartment =
                employeeList.stream()
                        .collect(
                                Collectors.groupingBy(Employee::getEmp_dept,Collectors.averagingDouble(Employee::getEmp_salary))
                        );

        System.out.println("Exercise 7 : Average salary of each department: "+ avgSalaryOfEachDepartment);

        // Exercise 7 : Average salary of each department: {Product Development=31960.0, Security And Transport=10750.25, Sales And Marketing=11900.166666666666, Infrastructure=15466.666666666666, HR=23850.0, Account And Finance=24150.0}
    }

    private static void countNumberEmployeeInEachDepartment(List<Employee> employeeList) {
        Map<String, Long> noOfEmployeesInEachDepartment =
                employeeList.stream()
                        .collect(
                                Collectors.groupingBy(Employee::getEmp_dept,Collectors.counting())
                        );

        System.out.println("Exercise 6 : Employees in each department: "+ noOfEmployeesInEachDepartment);

        // Exercise 6 : Employees in each department: {Product Development=5, Security And Transport=2, Sales And Marketing=3, Infrastructure=3, HR=2, Account And Finance=2}
    }

    private static void getNamesOfEmployeesWhoHaveJoinedAfter2015(List<Employee> employeeList) {
        List<String> whoJoinedAfter2015 =
                employeeList.stream()
                        .filter(emp -> emp.getEmp_doj()>2015)
                        .map(Employee::getEmp_name).collect(Collectors.toList());

        System.out.println("Exercise 5 : Employees who joined after 2015: " + whoJoinedAfter2015);

        // Exercise 5 : Employees who joined after 2015: [Iqbal Hussain, Amelia Zoe, Nitin Joshi, Nicolus Den, Ali Baig]
    }

    private static void getDetailsOfHighestReleasedEmployee(List<Employee> employeeList) {
        Optional<Employee> highestPaidEmployee =
                employeeList.stream()
                        .collect(
                                Collectors.maxBy(Comparator.comparingDouble(Employee::getEmp_salary))
                        );

        System.out.println("Exercise 4 : Highest paid employee: " +highestPaidEmployee);

        // Exercise 4 : Highest paid employee: Optional[Employee{emp_id=277, emp_name='Anuj Chettiar', emp_age=31, emp_gender='Male', emp_dept='Product Development', emp_doj=2012, emp_salary=35700.0}]


    }

    private static void averageAgeOfAllMaleAndFemaleInTheOrganization(List<Employee> employeeList) {
        Map<String, Double> avgAgeOfFemaleAndMaleEmployees =
                employeeList.stream()
                        .collect(
                                Collectors.groupingBy(Employee::getEmp_gender,Collectors.averagingInt(Employee::getEmp_age))
                        );

        System.out.println("Exercise 3 : Average age of male and female employees: "+avgAgeOfFemaleAndMaleEmployees);

        // Exercise 3 : Average age of male and female employees: {Male=30.181818181818183, Female=27.166666666666668}
    }

    private static void printNameOfAllDepartmentsInTheOrganization(List<Employee> employeeList) {
        Set<String> departmentNames = employeeList.stream().map(emp -> emp.getEmp_dept()).collect(Collectors.toSet());
        System.out.println("Exercise 2 : Department Names: "+departmentNames);

        // Exercise 2 : Department Names:  [Product Development, Sales And Marketing, Security And Transport, Infrastructure, HR, Account And Finance]
    }

    private static void howManyMaleAndFemaleInTheOrganization(List<Employee> employeeList) {

        Map<String, Long> noOfFemaleAndMaleEmployees =
                employeeList.stream()
                        .collect(
                                Collectors.groupingBy(Employee::getEmp_gender,Collectors.counting())
                        );

        System.out.println("Exercise 1 : No.of Females and Males: "+noOfFemaleAndMaleEmployees);

        // Exercise 1 : No.of Females and Males:  {Male=11, Female=6}
    }
}

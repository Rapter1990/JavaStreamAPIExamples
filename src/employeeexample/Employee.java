package employeeexample;

public class Employee {

    private int emp_id;
    private String emp_name;
    private int emp_age;
    private String emp_gender;
    private String emp_dept;
    private int emp_doj;
    private double emp_salary;

    public Employee(int emp_id, String emp_name, int emp_age, String emp_gender,
                    String emp_dept, int emp_doj, double emp_salary) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_age = emp_age;
        this.emp_gender = emp_gender;
        this.emp_dept = emp_dept;
        this.emp_doj = emp_doj;
        this.emp_salary = emp_salary;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public int getEmp_age() {
        return emp_age;
    }

    public String getEmp_gender() {
        return emp_gender;
    }

    public String getEmp_dept() {
        return emp_dept;
    }

    public int getEmp_doj() {
        return emp_doj;
    }

    public double getEmp_salary() {
        return emp_salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", emp_age=" + emp_age +
                ", emp_gender='" + emp_gender + '\'' +
                ", emp_dept='" + emp_dept + '\'' +
                ", emp_doj=" + emp_doj +
                ", emp_salary=" + emp_salary +
                '}';
    }
}

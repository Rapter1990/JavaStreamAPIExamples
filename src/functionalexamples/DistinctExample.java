package functionalexamples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctExample {

    public static void main(String[] args)
    {
        Customer c1 = new Customer(1,"Anil");
        Customer c2 = new Customer(2,"Bob");
        Customer c3 = new Customer(3,"Christie");
        Customer c4 = new Customer(4,"Danny");
        Customer c5 = new Customer(1,"Anil");
        Customer c6 = new Customer(1,"Anil");
        Customer c7 = new Customer(5,"Heather");

        List<Customer> customers = Arrays.asList(c1,c2,c3,c4,c5,c6,c7);
        List<String> uniqueCustomerNames =
                customers.stream()
                        .filter(customer ->customer.getName().length() > 3)
                        .distinct()
                        .map(customer -> customer.getName())
                        .collect(Collectors.toList());

        System.out.println(uniqueCustomerNames);
    }

}

class Customer {

    private int id;
    private String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Customer other = (Customer) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

}

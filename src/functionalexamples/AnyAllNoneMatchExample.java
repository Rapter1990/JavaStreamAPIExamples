package functionalexamples;

import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class AnyAllNoneMatchExample {

    public static void main(String[] args) {

        List<Order> orders = getOrders();
        LocalDate sixMonthsAgo = LocalDate.now().minusMonths(6);
        boolean anyOrdersInLastSix = orders.stream()
                .anyMatch(order -> order.getPlaced()
                        .isAfter(sixMonthsAgo)
                );

        System.out.println("anyOrdersInLastSix : " + anyOrdersInLastSix);

        // All transactions more than 1 million ?
        List<Transaction> transactions = getTransactions();

        BigDecimal oneMillion = BigDecimal.valueOf(1000000);

        Predicate<Transaction> highValue = (transaction) -> transaction.getValue()
                .compareTo(oneMillion) > 0;
        boolean taxAnalysis = transactions.stream()
                .allMatch(highValue);

        System.out.println("taxAnalysis : " + taxAnalysis);

        //process list of names where 'none' are blank.
        List<String> validNames = Arrays.asList("amit","ben","clark"," ","emily");

        boolean allValidNames = validNames.stream().noneMatch(String::isBlank);
        boolean allValidNamesAgain = !validNames.stream().anyMatch(String::isBlank);
        System.out.println("allValidNames : " + allValidNames);
        System.out.println("allValidNamesAgain : " + allValidNamesAgain);

        /*

            anyOrdersInLastSix : true
            taxAnalysis : true
            allValidNames : false
            allValidNamesAgain : false

         */

    }

    private static List<Order> getOrders() {

        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, LocalDate.now().minusMonths(7)));
        orders.add(new Order(2, LocalDate.now().minusMonths(3)));
        orders.add(new Order(3, LocalDate.now().minusMonths(9)));
        orders.add(new Order(4, LocalDate.now().minusMonths(8)));
        orders.add(new Order(5, LocalDate.now().minusMonths(10)));
        return orders;
    }

    private static List<Transaction> getTransactions() {

        List<Transaction> transactions = new ArrayList<>();

        Transaction t1 = new Transaction(1, BigDecimal.valueOf(9000000));

        Transaction t2 = new Transaction(2, BigDecimal.valueOf(1600000));

        Transaction t3 = new Transaction(3, BigDecimal.valueOf(1900000));

        Transaction t4 = new Transaction(4, BigDecimal.valueOf(1200000));

        Transaction t5  = new Transaction(5, BigDecimal.valueOf(1500000));
        transactions.add(t1);
        transactions.add(t2);
        transactions.add(t3);
        transactions.add(t4);
        transactions.add(t5);
        return transactions;
    }

}

class Transaction {

    private int id;
    private BigDecimal value;

    public Transaction(int id,BigDecimal value) {
        this.id = id;
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public int getId() {
        return id;
    }




}

class Order {
    private int id;
    private LocalDate placed;

    public Order(int id, LocalDate placed) {
        this.id = id;
        this.placed = placed;
    }

    public int getId() {
        return id;
    }

    public LocalDate getPlaced() {
        return placed;
    }
}

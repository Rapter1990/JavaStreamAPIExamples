package banktransactionxample;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class BankTransactionExample {

    public static List<BankTransaction> transactions = getTransactions();

    public static void main(String[] args) {

        //find the total  transactions done today
        long totalTransactions = getTotalTransactionsToday();
        System.out.println("Total transactions :" +totalTransactions);

        //find the max individual  transaction done today
        LocalDate when = LocalDate.now();
        Optional<BankTransaction> maxTransaction = getBiggestTransaction(when);

        System.out.println(maxTransaction.map(BankTransaction::getAccNumber)
                .orElse("No transactions done on : "+when));

        //find the minimum individual  transaction done today
        Optional<BankTransaction> minTransaction = getSmallestTransaction(when);

        System.out.println(minTransaction.map(BankTransaction::getAccNumber)
                .orElse("No transactions on : " +when));

        /*

            Total transactions :8
            123
            987

         */

    }

    private static Optional<BankTransaction> getBiggestTransaction(LocalDate when) {
        //find the maximum individual transaction done on a given date.
        Comparator<BankTransaction> byAmount = Comparator.comparing(BankTransaction::getAmount);
        return transactions.stream()
                .filter(transaction -> transaction.getDate().equals(when))
                .max(byAmount);
    }

    private static Optional<BankTransaction> getSmallestTransaction(LocalDate when) {

        //find the minimum individual transaction done on a given date.
        Comparator<BankTransaction> byAmount = Comparator.comparing(BankTransaction::getAmount);
        return transactions.stream()
                .filter(transaction -> transaction.getDate().equals(when))
                .min(byAmount);
    }

    public static long getTotalTransactionsToday() {
        return transactions.stream()
                .filter(transaction -> transaction.getDate().equals(LocalDate.now()))
                .count();
    }

    private static List<BankTransaction> getTransactions() {
        return Arrays.asList(
                new BankTransaction("123", BigDecimal.valueOf(250.00), LocalDate.now()),
                new BankTransaction("456", BigDecimal.valueOf(1250.00), LocalDate.now().minusDays(1)),
                new BankTransaction("789", BigDecimal.valueOf(2250.00), LocalDate.now()),
                new BankTransaction("987", BigDecimal.valueOf(550.00), LocalDate.now()),
                new BankTransaction("654", BigDecimal.valueOf(750.00), LocalDate.now()),
                new BankTransaction("123", BigDecimal.valueOf(4350.00), LocalDate.now()),
                new BankTransaction("789", BigDecimal.valueOf(150.00), LocalDate.now()),
                new BankTransaction("456", BigDecimal.valueOf(4250.00), LocalDate.now()),
                new BankTransaction("987", BigDecimal.valueOf(50.00), LocalDate.now()),
                new BankTransaction("456", BigDecimal.valueOf(850.00), LocalDate.now().minusDays(2))
        );
    }

}

class BankTransaction {

    private String accNumber;
    private BigDecimal amount;
    private LocalDate date;

    public BankTransaction(String accNo, BigDecimal amount, LocalDate date) {
        this.accNumber = accNo;
        this.amount = amount;
        this.date = date;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

}


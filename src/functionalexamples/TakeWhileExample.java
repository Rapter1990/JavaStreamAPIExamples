package functionalexamples;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TakeWhileExample {

    // takeWhile -> stream elements until the statement is false

    public static void main(String[] args) {
        List<Stock> stocks = getStocks();

        //take while example
        List<String> stockBelow1000 = getStocksBelowThousand(stocks);
        System.out.println(stockBelow1000);

        // [Instagram, Facebook, Amazon]
    }

    private static List<String> getStocksBelowThousand(List<Stock> stocks) {
        return stocks.stream()
                .takeWhile(stock -> isStockLessThanThousand(stock))
                .map(stock -> stock.getName())
                .collect(Collectors.toList());
    }

    private static boolean isStockLessThanThousand(Stock stock) {
        return stock.getValue().compareTo(BigDecimal.valueOf(1000)) < 0 ;
    }

    private static List<Stock> getStocks() {

        List<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock("Apple",BigDecimal.valueOf(1000)));
        stocks.add(new Stock("Amazon",BigDecimal.valueOf(800)));
        stocks.add(new Stock("Netflix",BigDecimal.valueOf(2000)));
        stocks.add(new Stock("Facebook",BigDecimal.valueOf(500)));
        stocks.add(new Stock("Instagram",BigDecimal.valueOf(100)));

        return stocks.stream()
                .sorted(Comparator.comparing(Stock::getValue))
                .collect(Collectors.toList());
    }
}

class Stock {

    private String name;
    private BigDecimal value;

    public Stock(String name, BigDecimal value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getValue() {
        return value;
    }


}

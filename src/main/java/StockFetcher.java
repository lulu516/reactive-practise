import java.util.Map;

public class StockFetcher {

    private static final Map<String, Integer> stockMap = Map.of("Google", 100, "Apple", 200, "Facebook", 300, "Intel", 400);

    public static StockInfo fetch(String symbol) {
        if (Math.random() > 0.5) {
            throw new RuntimeException("oh oh");
        }

        return new StockInfo(symbol, stockMap.getOrDefault(symbol, 0));
    }
}

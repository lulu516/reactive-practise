public class StockInfo {
    private final String ticker;
    private final Integer price;

    public StockInfo(String ticker, Integer price) {
        this.ticker = ticker;
        this.price = price;
    }

    @Override
    public String toString() {
        return "StockInfo{" +
                "ticker='" + ticker + '\'' +
                ", price=" + price +
                '}';
    }
}

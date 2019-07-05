import io.reactivex.Observable;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> companies = List.of("Google", "Apple", "Facebook", "Intel");


        Observable<StockInfo> feed = StockServer.getFeed(companies);

        System.out.println("got observable...");

        feed.doOnNext(System.out::println)
                .doOnError(throwable -> System.out.println("error " + throwable))
                .doOnComplete(() -> System.out.println("complete"))
                .takeUntil(stockInfo -> stockInfo.getTicker().equalsIgnoreCase("facebook") && stockInfo.getPrice() > 150)
                .subscribe();

        System.out.println("done");
    }
}

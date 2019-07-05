import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<String> companies = List.of("Google", "Apple", "Facebook", "Intel");


        Observable<StockInfo> feed = StockServer.getFeed(companies);

        System.out.println("got observable...");

        feed.subscribeOn(Schedulers.io())
                .subscribe(stockInfo -> {
                    System.out.println("Thread: " + Thread.currentThread());
                    System.out.println(stockInfo);
                });

        Thread.sleep(10000);
    }
}

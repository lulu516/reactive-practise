import io.reactivex.Observable;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> companies = List.of("Google", "Apple", "Facebook", "Intel");


        Observable<StockInfo> feed = StockServer.getFeed(companies);

        System.out.println("got observable...");

        feed.subscribe(System.out::println);
    }
}

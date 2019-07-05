import io.reactivex.Observable;

import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<String> companies = List.of("Google", "Apple", "Facebook", "Intel");


        Observable<StockInfo> feed = StockServer.getFeed(companies);

        System.out.println("got observable...");

        feed.onErrorResumeNext(
                throwable -> {
                    return callBack(throwable, companies);
                })
                .subscribe(System.out::println, System.out::println);

    }

    private static Observable<StockInfo> callBack(Throwable throwable, List<String> companies) {
        System.out.println(throwable);
        return StockServer.getFeed(companies); // Not recursive
    }
}

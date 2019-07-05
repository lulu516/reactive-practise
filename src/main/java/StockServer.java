import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

import java.util.List;

public class StockServer {
    public static Observable<StockInfo> getFeed(List<String> companies) {
        return Observable.create(subscriber -> processRequest(subscriber, companies));
    }

    private static void processRequest(ObservableEmitter<StockInfo> subscriber, List<String> companies) {
        System.out.println("processing...");

        int i = 0;

        while(i ++ < 5) {
            companies.stream()
                    .map(StockFetcher::fetch)
                    .forEach(subscriber::onNext);
        }
    }
}

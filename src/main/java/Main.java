import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<String> companies = List.of("Google", "Apple", "Facebook", "Intel");

        Observable<Integer> feed = StockServer.getData()
                .subscribeOn(Schedulers.io())
                .share();

        feed.subscribe(System.out::println);

        Thread.sleep(5000);

        feed.subscribe(System.out::println);

        Thread.sleep(5000);

        //outcome:
        //0
        //1
        //2
        //3
        //4
        //5
        //5
        //6
        //6
        //7
        //7
        //8
        //8
        //9
        //9
    }
}

package junseok.snr.redisplayground.study.string;

import java.util.List;
import java.util.function.Consumer;

public class Demo {

    public static void main(String[] args) {
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("hhhhhhhh");
        Consumer<Integer> consumer02 = System.out::println;
        consumer02.accept(356);
        Consumer<String> consumer03 = System.out::println;

        List<String> strList = List.of("A", "B", "C", "D");
        strList.forEach(action -> System.out.println(action + "k,,,,"));

        consumer.andThen(consumer03).accept("dksenfksdjsenf");


    }
}

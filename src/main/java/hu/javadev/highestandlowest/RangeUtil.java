package hu.javadev.highestandlowest;

import java.util.stream.Stream;

public class RangeUtil {

    public String highAndLow(String numbers) {
        var statistics = Stream.of(numbers.split(" "))
                .mapToInt(Integer::parseInt)
                .summaryStatistics();

        return statistics.getMax() + " " + statistics.getMin();
    }

}

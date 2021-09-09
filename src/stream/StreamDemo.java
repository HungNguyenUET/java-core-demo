package stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(2, 3, 4, 5);
        List<Integer> square = number.stream().map(x -> x*x).collect(Collectors.toList());
        System.out.println(square);

        Map<Integer, Integer> map = number.stream().collect(Collectors.toMap(x -> x, x -> x*x));
        System.out.println(map);

        List<String> names = Arrays.asList("Reflection", "Collection", "Stream");
        List<String> result = names.stream().filter(str -> str.startsWith("S")).collect(Collectors.toList());
        System.out.println(result);

        result = names.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
        System.out.println(result);

        number = Arrays.asList(2, 3, 4, 5, 3);
        Set<Integer> squareSet = number.stream().map(x -> x*x).collect(Collectors.toSet());
        System.out.println(squareSet);

        number.stream().map(x -> x*x).forEach(y -> System.out.print(y));

        int even = number.stream().filter(x->x%2==0).reduce(0, Integer::sum);
        System.out.println(even);
    }

}

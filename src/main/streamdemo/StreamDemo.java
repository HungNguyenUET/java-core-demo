package main.streamdemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {

    public void demo() {
        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println("Filtered List: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("Merged String: " + mergedString);

        List<Integer> number = Arrays.asList(2,6,4,5);
        int even = number.stream().filter(o -> o%2 == 0).reduce(0, Integer::sum);
        System.out.println(even);
    }

    public static void main(String[] args) {
        StreamDemo demo = new StreamDemo();
        demo.demo();
    }

}

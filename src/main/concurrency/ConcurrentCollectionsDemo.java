package main.concurrency;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentCollectionsDemo {
    public static void main(String[] args) {
        demo2();
    }

    private static void demo1() {
        var foodData = new HashMap<String, Integer>();
        foodData.put("penguin", 1);
        foodData.put("flamingo", 2);
        for (String key: foodData.keySet()) {
            foodData.remove(key);
        }
    }

    private static void demo2() {
        var foodData = new ConcurrentHashMap<String, Integer>();
        foodData.put("penguin", 1);
        foodData.put("flamingo", 2);
        for (String key: foodData.keySet()) {
            foodData.remove(key);
            System.out.println(foodData.size());
        }
    }
}

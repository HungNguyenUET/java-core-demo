package main.genericsdemo;

public class GenericsDemo {

    public static void main(String[] args) {
        //Generic Types
        Box<Integer, String> box = new Box<>();

        Pair<Integer, String> pair1 = new OrderedPair<>(8, "Hung");
        OrderedPair<String, String> pair2 = new OrderedPair<>("BestFriend", "Hieu");

        OrderedPair<Integer, Box<Integer, String>> pairBox = new OrderedPair<>(10, new Box<>());

        //Raw type
        Box box1 = new Box();
        Box<Integer, String> box2 = box1; //warning unchecked conversion

        Box<String, String> box3 = new Box<>();
        Box box4 = box3;
        box4.setT("hang"); //warning: unchecked invocation set(T)
        box4.setT(0);;

        //Generic Method
        Pair<Integer, String> p1 = new OrderedPair<>(1, "apple");
        Pair<Integer, String> p2 = new OrderedPair<>(2, "Amazon");
        Utils.compare(p1, p2);

        //Bounded types parameter
        Box<Long, String> box5 = new Box<>();
        box5.setT(0L);
        box5.inspect(10);
    }

}

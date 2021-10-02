package main.mapdemo;

public class MapDemo {

    interface PrintString {
        void printString(String str);
    }

    static PrintString notNull() {
        return MapDemo::test;
    }

    static void test(String str) {
        System.out.println(str);
    }
}

package main.variabledemo;

public class PrimitiveDataTypeDemo {

    private String name;
    private int number;

    public void demoInitial() {
        boolean result = true;
        char capitalC = 'C';
        byte b = 100;
        short s = 10000;
        int i = 100000;

        if (result)
            System.out.println("capitalC: " + capitalC + " b: " + b + " s: " + s + " i: " + i);
    }

    public void showInstanceVar() {
        System.out.println("name: " + name + ", number: " + number);
    }

}

package main;

import main.model.DemoObject;
import main.model.User;

public class Main {

    public static void main(String[] args) throws Exception{
        System.out.println("Hello, world!");

        DemoObject demoObj = new DemoObject();

        int age = 25;
        demoObj.updateAge(age); //26
        System.out.println("age 2: " + age); //25

        Integer newAge = 100;
        demoObj.updateAge(newAge); // 101
        System.out.println("new age: " + newAge); // 101

        String name = "Long";
        demoObj.updateName(name); // Mr.Long
        System.out.println("Hello!, " + name); // Long

        User user = new User("Long", 21);
        demoObj.updateAge(user); // 22
        System.out.println("User age 2: " + user.age); // 22
        demoObj.updateName(user); // Mr.Long
        System.out.println("Hello!," + user.name); // Mr.Long

        int x,y,d;

        x = 12*45-27;
        y = 74+5*x;
        d = y*x;
        System.out.println("x: " + x + " y " + y + " d " + d);
    }

}

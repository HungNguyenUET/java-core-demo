package main.model;

import java.io.FileNotFoundException;

public class DemoObject {

    public void updateAge(int age){
        age += 1;
        System.out.println("age: " + age);
    }

    public void updateAge(Integer age) throws FileNotFoundException {
        age += 1;
        System.out.println("new age: " + age);

    }

    public void updateAge(User user) {
//        user.age += 1;
//        System.out.println("User age: " + user.age);
        user = new User("Hung", 25);
    }

    public void updateName(User user) {
        user.name = "Mr." + user.name;
        System.out.println("Hello, " + user.name);
    }

    public void updateName(String name) {
        name = "Mr." + name;
        System.out.println("Hello, " + name);
    }

}

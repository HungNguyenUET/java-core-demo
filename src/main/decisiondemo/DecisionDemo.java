package main.decisiondemo;

public class DecisionDemo {
    public static void main(String[] args) {
        int dayOfWeek = 0;
        switch (dayOfWeek) {
            case 1:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Someday");
            case 2:
                System.out.println("Monday");
            case 3:
                System.out.println("Tuesday");
            case 4:
                System.out.println("Wednesday");
            case 5:
                System.out.println("Thursday");
            case 6:
                System.out.println("Friday");
            case 7:
                System.out.println("Saturday");
        }
    }
}

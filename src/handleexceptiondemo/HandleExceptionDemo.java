package handleexceptiondemo;

public class HandleExceptionDemo {
    public static void main(String[] args) {
        try {
            System.out.println("Try");
            String str = null;
            System.out.println(str.toString());
            System.out.println("Try success");
            return;
        } catch (Exception e) {
            System.out.println("catch");
            return;
        } finally {
            System.out.println("Finally");
        }
    }
}

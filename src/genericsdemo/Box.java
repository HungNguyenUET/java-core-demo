package genericsdemo;

public class Box<T, E> {

    private T t;
    private E e;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public E getE() {
        return e;
    }

    //Bounded types parameters
    public <U extends Number> void inspect(U u) {
        System.out.println("T Class name: " + t.getClass().getName());
        System.out.println("U Class name: " + u.getClass().getName());
    }

    //Multiple bounded
    public <E extends A & B1 & B2> void demo() {

    }
}

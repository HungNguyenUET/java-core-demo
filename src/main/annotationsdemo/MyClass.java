package main.annotationsdemo;

@ClassPreamble(
        author = "Hung Nguyen",
        date = "09/07/2021",
        currentRevision = 6,
        lastModified = "Toan Nguyen",
        lastModifiedBy = "Do Vu",
        reviewer = {"Hung", "Toan", "Dat"}
)
public class MyClass {

    @SuppressWarnings(value = "unchecked")
    public void myMethod() {
//        MyObject myObject = new @Interned MyObject();
    }

    private void typeCaseDemo() {
//        Integer number;
//        String myString = (@NonNull String) number;
//        System.out.println(myString);
    }

}

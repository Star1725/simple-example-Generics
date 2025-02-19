package simpleExample;

public class Main {
    public static void main(String[] args) {

        //Здесь Box<T> – обобщённый класс, который может работать с любым типом данных.
        Box<String> box = new Box<>();
        box.setValue("Hello");
        System.out.println(box.getValue());

        Box<Integer> box1 = new Box<>();
        box1.setValue(123);
        System.out.println(box1.getValue());
    }
}
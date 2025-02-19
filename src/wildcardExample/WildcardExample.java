package wildcardExample;

import java.util.ArrayList;
import java.util.List;

public class WildcardExample {
    //Wildcards (?) используются, когда неизвестен точный параметр типа, но нужно обеспечить гибкость кода.

    /*
     1 - ? extends T означает, что параметр может быть T или подклассом T (ограничение сверху)
    */

    //Если метод только читает данные (например, printNumbers), то ? extends T гарантирует, что список содержит объекты,
    //которые являются Number или его подклассами.
    static void printNumber(List<? extends Number> list) {
        for (Number n : list) {
            System.out.println(n);
        }
    }
    //Ограничение:
    //Нельзя добавлять элементы в List<? extends Number>, так как компилятор не знает, какой конкретный подкласс Number в списке.
//    static void insertNumber(List<? extends Number> list, Number n) {
//        list.add(n);
//    }

    /*
     2 - ? super T означает, что параметр может быть T или его суперклассом (ограничение снизу)
     */

    //Если метод добавляет данные (например, addNumbers), но не использует конкретный тип T, то ? super T обеспечивает гибкость.
    static void addNumbers(List<? super Integer> list, Integer n) {
        list.add(n);
    }

    //Ограничение:
    //Нельзя безопасно читать элементы (кроме Object), потому что компилятор не знает, какой конкретный суперкласс используется.
//    static void readNumbers(List<? super Number> list) {
//        for (Number n : list) {
//            System.out.println(n);
//        }
//    }

    /*
     3 - ? Означает "любой тип", используется, когда тип вообще не важен.
     */

    static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }


    public static void main(String[] args) {

        //1
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(1.1);
        doubleList.add(2.2);
        doubleList.add(3.3);

        printNumber(intList);
        printNumber(doubleList);
        //printNumber(new ArrayList<String>());//ошибка компиляции

        //2
        List<Integer> intList2 = new ArrayList<>();
        List<Number> numberList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();

        addNumbers(intList2, 1);
        addNumbers(numberList, 1);
        addNumbers(objectList, 1);

        Integer num = intList.get(0);
        //Integer num1 = numberList.get(0);//Ошибка компиляции
        Object object = numberList.add(0);//Кроме Object

        //3
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("World");

        List<Integer> intList3 = new ArrayList<>();
        intList.add(1);
        intList.add(2);

        printList(stringList);  // Работает
        printList(intList3);  // Работает
    }
}

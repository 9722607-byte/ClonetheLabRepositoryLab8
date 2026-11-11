package ua.opnu;

import java.util.Arrays;
import java.util.function.Predicate;

public class Main {

    // Завдання 4: Узагальнений метод filter
    public static <T> T[] filter(T[] input, Predicate<T> predicate) {
        int counter = 0;
        for (T i : input) {
            if (predicate.test(i)) {
                counter++;
            }
        }

        @SuppressWarnings("unchecked")
        T[] result = (T[]) java.lang.reflect.Array.newInstance(input.getClass().getComponentType(), counter);

        int index = 0;
        for (T i : input) {
            if (predicate.test(i)) {
                result[index++] = i;
            }
        }
        return result;
    }

    // Завдання 5: Узагальнений метод contains
    public static <T extends Comparable<T>, V extends T> boolean contains(T[] array, V element) {
        for (T str : array) {
            if (str.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("=== ЗАВДАННЯ 1: MyOptional ===");
        MyOptional<String> middleName = new MyOptional<>();
        System.out.println(middleName);
        System.out.println("isPresent: " + middleName.isPresent());
        System.out.println("orElse: " + middleName.orElse("немає"));

        MyOptional<String> username = new MyOptional<>("admin");
        System.out.println(username);
        System.out.println("isPresent: " + username.isPresent());
        System.out.println("get(): " + username.get());
        System.out.println("orElse: " + username.orElse("guest"));

        try {
            middleName.get();
        } catch (IllegalStateException ex) {
            System.out.println("Очікуваний виняток: " + ex.getMessage());
        }

        try {
            MyOptional<String> broken = new MyOptional<>(null);
        } catch (IllegalArgumentException ex) {
            System.out.println("Правильно не дозволив null: " + ex.getMessage());
        }

        System.out.println("\n=== ЗАВДАННЯ 2: BookData ===");
        BookData[] books = {
                new BookData("Java Programming", "Smith", 10, 40.0),
                new BookData("Advanced Java", "Doe", 5, 25.0),
                new BookData("Clean Code", "Martin", 20, 80.0)
        };
        Arrays.sort(books);
        for (BookData b : books) {
            System.out.println(b);
        }

        System.out.println("\n=== ЗАВДАННЯ 3: Printer ===");
        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "world"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);

        System.out.println("\n=== ЗАВДАННЯ 4: filter ===");
        Integer[] nums = {1, 2, 3, 4, 5, 6};
        Integer[] evenNums = filter(nums, n -> n % 2 == 0);
        System.out.println("Парні числа: " + Arrays.toString(evenNums));

        System.out.println("\n=== ЗАВДАННЯ 5: contains ===");
        String[] words = {"apple", "banana", "cherry"};
        boolean found = contains(words, "banana");
        System.out.println("Чи є banana в масиві? " + found);

        System.out.println("\n=== ЗАВДАННЯ 6: Тупли (Tuple) ===");
        GenericTwoTuple<String, Integer> studentPair = new GenericTwoTuple<>("Андрій", 95);
        System.out.println("GenericTwoTuple: " + studentPair);

        GenericThreeTuple<String, Integer, String> detailedStudent = new GenericThreeTuple<>("Андрій", 95, "АІ-253");
        System.out.println("GenericThreeTuple: " + detailedStudent);
    }
}
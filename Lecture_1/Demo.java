package Lecture_1;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        List<Integer> availableDivider = findSimpleNumber(7);
        for (Integer integer : availableDivider) {
            System.out.println(integer);
        }
    }

    public static List<Integer> findAvailableDivider(int number) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= number; i++) { // линейная сложность
            if (number % i == 0) {
                result.add(i);
            }
        }
        return result;
    }

    // Алгоритм поиска простых чисел
    public static List<Integer> findSimpleNumber(int max) {
        // заведем counter счетчик
        int counter = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= max; i++) { // для i ищем допустимые делители, на 1 все делится
            boolean simple = true; // ввели переменную, если есть остаток занчит флаг True
            for (int j = 2; j < i; j++) { // j делим на 2 // Это цикл в цикле - квадратичная сложность
                counter++;
                if (i % j == 0) { // если остатка от деления нет
                    simple = false; // в случае деления без остатка меняем флаг на False
                }
            }
            if (simple) { // Если Simple не поменялся
                result.add(i); // Значит заносим в result
            }
        }
        System.out.println("Counter" + counter);
        return result;
    }
}
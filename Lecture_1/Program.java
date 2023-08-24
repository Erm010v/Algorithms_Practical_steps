
package Lecture_1;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

// import javax.swing.plaf.synth.SynthScrollBarUI;

public class Program {
    public static void main(String[] args) {

        int lastNumber = 20;
        AtomicInteger counter = new AtomicInteger();
        // StringBuilder stringBuilder = new StringBuilder("AAAAA"); // динамическая
        // строка
        // int counter = 0;
        System.out.printf("Сумма всех чисел от 1 до %d равна %d\n", lastNumber, sum(lastNumber, counter));

        counter.set(0); // обнуление счетчика
        System.out.printf("Простые числа в диапозоне от 1 до %d: \n %s \n", lastNumber,
                findSimpleNumber(lastNumber, counter));

        System.out.println("Количество Итераций: " + counter);
        // System.out.println(stringBuilder.toString());
        System.out.println(counter.get());

        f(4);

        counter.set(0);

        long startTime = System.currentTimeMillis(); // секунды выполнения задачи ( начало)

        System.out.printf("Число Фибоначчи для номера %d равно: %d (РЕКУРСИЯ) \n", lastNumber,
                fb1(lastNumber, counter));
        System.out.println("Кол-во итераций:" + counter.get());

        long endTime = System.currentTimeMillis();
        System.out.printf("Операция выполнена за %d мс.", endTime - startTime);

        counter.set(0);
        startTime = System.currentTimeMillis();
        System.out.printf("Число Фибоначчи для номера %d равно: %d\n", lastNumber, fb2(lastNumber, counter));
        System.out.println("Кол-во итераций: " + counter.get());
        endTime = System.currentTimeMillis();
        System.out.printf("Операция выполнена за %d мс.", endTime - startTime);

    }

    /**
     * ЗАДАЧА_1
     * Необходимо написать алгоритм, считающий сумму всех чисел от 1 до N.
     * Согласно свойствам линейной сложности, количество итераций цикла
     * будет линейно изменяться относительно изменения размера N.
     */
    public static int sum(int lastNumber, AtomicInteger c) {
        // s.append("BBBBBBBBBBBBB");
        int sum = 0;
        for (int i = 1; 1 <= lastNumber; i++) {
            sum += i; // аналог sum = sum + i
            // c++; // c = c + i
            c.getAndIncrement(); // c++
        }
        return sum;
    }

    public static ArrayList<Integer> findSimpleNumber(int lastNumber, AtomicInteger counter) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 1; i <= lastNumber; i++) {
            boolean simple = true;
            for (int j = 2; j < i; j++) {
                counter.getAndIncrement();
                if (i % j == 0) {
                    simple = false;
                    break;
                }
            }
            if (simple) {
                arrayList.add(i);
            }
        }
        return arrayList;
    }

    // Рекурсия - вызов методом самого себя
    static void f(int n) {
        System.out.println(n);
        if (n >= 3) {
            f(n - 1);
            f(n - 2);
            f(n - 3);
        }
    }

    /**
     * ЗАДАЧА_4
     * 1. Пишем алгоритм поиска нужного числа последовательности Фибоначчи.
     * 2. Считаем, что 1 и 2 значения последовательности равны 1.
     * 3. Искать будем по формуле On=On-1+On-2
     * что предполагает использовать рекурсивного алгоритма.
     * 0 1 1 2 3 5 8 13 21 34 55
     * 0 1 2 3 4 5 6 7 8 9 10
     */
    public static long fb1(int num, AtomicInteger counter) {
        counter.getAndIncrement(); // каунтер/счетчик величиваем каждый раз при вызове рекурсивного метода fb1
        if (num == 0 || num == 1) // частный случай
            return num;
        return fb1(num - 1, counter) + fb1(num - 2, counter);
    }

    // Решение задачи через Массив
    public static int fb2(int num, AtomicInteger counter) {
        if (num == 0 || num == 1)
            return num;
        int[] array = new int[num + 1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < array.length; i++) { // проход по всем элементам массива
            array[i] = array[i - 1] + array[i - 2]; // вычисляем для каждого элемента значение
        }
        return array[num];
    }

}

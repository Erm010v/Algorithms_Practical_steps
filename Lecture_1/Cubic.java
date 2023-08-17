package Lecture_1;

import java.util.concurrent.atomic.AtomicInteger;

public class Cubic {
    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger(0);
        int fib = fib(10, counter);
        System.out.println("Fib number: " + fib);
        System.out.println("Counter:" + counter.get());

        counter = new AtomicInteger(0);
        fib = fib(11, counter);
        System.out.println("Fib number: " + fib);
        System.out.println("Counter:" + counter.get());

        counter = new AtomicInteger(0);
        fib = fib(12, counter);
        System.out.println("Fib number: " + fib);
        System.out.println("Counter:" + counter.get());

    }

    // Работа с Цифрами Фибоначи
    public static int fib(int position, AtomicInteger counter) {
        counter.incrementAndGet();
        if (position == 1) {
            return 0; // Если позиция = 1 тогда возвращаем 0
        }
        if (position == 2) {
            return 1; // Если позиция = 2 тогда возвращаем 1
        }
        return fib(position - 1, counter) + fib(position - 2, counter); // в противном случае сложим 2 числа предыдущей
                                                                        // позиции
    }
}

// // Для трех шестигранных кубиков
// // низка производительность
// // много вложенных циклов
// // экспонентальная зависимость
// public static double findSum(int sum) {
// int count = 0;
// int successResult = 0;
// for (int i = 1; i <= 6; i++){
// for (int j = 1; j <= 6; j++) {
// for (int k = 1; k <= 6; k++){
// if (i + j + k = sum) {
// successResult++;
// }
// count++;
// }
// }
// }
// return((double) successResult) / ((double) count);
// }

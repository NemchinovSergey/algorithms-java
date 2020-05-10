package com.nsergey.trainings.algorithms.otus.task1;

import com.nsergey.trainings.algorithms.Task;

import java.util.List;

/**
 * Счастливые билеты 20
 * <p>
 * Билет с 2N значным номером считается счастливым,
 * если сумма N первых цифр равна сумме последних N цифр.
 * Посчитать, сколько существует счастливых 2N-значных билетов.
 * <p>
 * Начальные данные: число N от 1 до 10.
 * Вывод результата: количество 2N-значных счастливых билетов.
 */
public class LuckyTicketsHardCodedN4 implements Task {

    public static void main(String[] args) {
        new LuckyTicketsHardCodedN4().run(null);
    }

    @Override
    public String run(List<String> data) {
        // n = 4
        int count = 0;
        for (int a1 = 0; a1 <= 9; a1++) {
            for (int a2 = 0; a2 <= 9; a2++) {
                for (int a3 = 0; a3 <= 9; a3++) {
                    for (int a4 = 0; a4 <= 9; a4++) {
                        System.out.println("" + a1 + a2 + a3 + a4);
                        if (a1 + a2 == a3 + a4) {
                            System.out.println("Lucky!");
                            count++;
                        }
                    }
                }
            }
        }
        return String.valueOf(count);
    }

}

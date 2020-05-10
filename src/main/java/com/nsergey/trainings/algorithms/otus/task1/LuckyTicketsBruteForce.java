package com.nsergey.trainings.algorithms.otus.task1;

import com.nsergey.trainings.algorithms.Task;

import java.util.Arrays;
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
public class LuckyTicketsBruteForce implements Task {

    @Override
    public String run(List<String> data) {
        int n = Integer.parseInt(data.get(0));

        int count = luckyTicketsWithBruteForce(n);
        return String.valueOf(count);
    }

    private int luckyTicketsWithBruteForce(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n cannot be less or equal zero");
        }

        int firstNumber = getFirstNumber(n);
        int lastNumber = getLastNumber(n);

        int countTickets = 1; // because of double zeros, ex. n=1, 00
        for (int number = firstNumber; number <= lastNumber; number++) {
            String str = String.valueOf(number);
            byte[] bytes = str.getBytes();

            System.out.println(number + ": " + Arrays.toString(bytes));

            int sum1 = sumOfFirstHalf(bytes, n);
            int sum2 = sumOfSecondHalf(bytes, n);

            if (sum1 == sum2) {
                System.out.println("Lucky!");
                countTickets++;
            }
        }
        return countTickets;
    }

    int getFirstNumber(int n) {
        int digits = n * 2;
        return (int) (1 * Math.pow(10, digits - 1));
    }

    int getLastNumber(int n) {
        int digits = n * 2;
        return (int) (1 * Math.pow(10, digits)) - 1;
    }

    int sumOfFirstHalf(byte[] bytes, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += bytes[i] - '0';
        }
        return sum;
    }

    int sumOfSecondHalf(byte[] bytes, int n) {
        int sum = 0;
        for (int i = bytes.length - 1; i >= n; i--) {
            sum += bytes[i] - '0';
        }
        return sum;
    }

}

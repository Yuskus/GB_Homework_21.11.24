/* Напишите функцию sortPhoneNumbers, которая сортирует номера телефонов 
в порядке возрастания с использованием поразрядной сортировки (RadixSort).*/

package lesson1;

import java.util.Arrays;
import java.lang.System;

public class Task2 {
    public static void main(String[] args) {
        long[] phoneNumbers = {
                9876543210L,
                1234567890L,
                5555555555L,
                1000000000L
        };
        execute(phoneNumbers);
        countTime(phoneNumbers, 10000000); // ~3911 (bin) vs ~5496 (dec)
    }

    public static long[] radixSortBinary(long[] array) {
        // Проверяем, является ли массив null или содержит менее 2 элементов
        if (array == null || array.length < 2)
            return array;

        // Создаём локальнуый массив, чтобы не изменять входные данные
        long[] localArr = Arrays.copyOf(array, array.length);
        // Создаём вспомогательный массив для сортировки
        long[] temp = new long[localArr.length];

        // Сортировка по битам
        for (int shift = 63, j = 0; shift > -1; --shift, j = 0) {
            for (int i = 0; i < localArr.length; ++i) {
                // Проверяем, переместить элемент в основной массив или во временный
                if (shift == 0 ^ (localArr[i] << shift) >= 0)
                    localArr[i - j] = localArr[i]; // Остается в основном
                else
                    temp[j++] = localArr[i]; // Перемещается во временный
            }
            // Перемещаем элементы из временного массива обратно в основной массив
            System.arraycopy(temp, 0, localArr, localArr.length - j, j);
        }
        return localArr;
    }

    public static long[] radixSortDec(long[] array) {
        long[] arr = Arrays.copyOf(array, array.length);
        long max = Arrays.stream(arr).max().getAsLong();
        for (int exp = 1; max / exp > 0; exp *= 10)
            countingSort(arr, exp);
        return arr;
    }

    private static void countingSort(long[] arr, int exp) {
        int n = arr.length;
        long[] output = new long[n];
        int[] count = new int[10];
        for (int i = 0; i < n; i++)
            count[(int) ((arr[i] / exp) % 10)]++;
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];
        for (int i = n - 1; i >= 0; i--) {
            output[count[(int) ((arr[i] / exp) % 10)] - 1] = arr[i];
            count[(int) ((arr[i] / exp) % 10)]--;
        }
        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }

    public static void execute(long[] array) {
        System.out.println(padRight("До сортировки: ", 25) + Arrays.toString(array));
        System.out.println(padRight("После сортировки (bin): ", 25) +
                Arrays.toString(radixSortBinary(array)));
        System.out.println(padRight("После сортировки (dec): ", 25) +
                Arrays.toString(radixSortDec(array)));
    }

    public static void countTime(long[] array, int cyclesCount) {
        // измерение скорости работы:
        // двоичная система
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < cyclesCount; i++) {
            radixSortBinary(array);
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Время выполнения поразрядной сортировки (двоичная система): " + duration);
        // десятичная система
        startTime = System.currentTimeMillis();
        for (int i = 0; i < cyclesCount; i++) {
            radixSortDec(array);
        }
        endTime = System.currentTimeMillis();
        duration = endTime - startTime;
        System.out.println("Время выполнения поразрядной сортировки (десятичная система): " + duration);
    }

    public static String padRight(String s, int n) {
        return (n < 0 || s == null || s.length() > n) ? s : String.format("%-" + n + "s", s);
    }
}

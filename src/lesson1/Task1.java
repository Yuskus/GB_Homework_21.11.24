/* Вам дан список задач, каждая из которых имеет приоритет (целое число). 
Напишите функцию sortTasksByPriority, которая сортирует задачи по 
убыванию приоритета с использованием сортировки кучей (HeapSort). */

package lesson1;

import java.util.Arrays;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        int[] tasks = null;
        execute(tasks);

        tasks = new Random().ints(10, 0, 100).toArray();
        execute(tasks);
    }

    public static int[] sortTasksByPriority(int[] tasks) {
        if (tasks == null || tasks.length < 2)
            return tasks;

        int n = tasks.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(tasks, n, i);

        for (int i = n - 1; i >= 0; i--) {
            int swap = tasks[0];
            tasks[0] = tasks[i];
            tasks[i] = swap;
            heapify(tasks, i, 0);
        }

        return tasks;
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;
        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    public static void execute(int[] array) {
        System.out.println(padRight("До сортировки: ", 20) + Arrays.toString(array));
        System.out.println(padRight("После сортировки: ", 20) + Arrays.toString(sortTasksByPriority(array)));
    }

    public static String padRight(String s, int n) {
        return (n < 0 || s == null || s.length() > n) ? s : String.format("%-" + n + "s", s);
    }
}

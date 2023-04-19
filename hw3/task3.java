package hw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class task3 {

    public static void main(String[] args) {
        int[] arr = {5, 1, 6, 2, 3, 4};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10));

        // №1.1: Сортировка слиянием
        System.out.println("[Сортировка слиянием]");
        System.out.println("До сортировки: " + Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("После сортировки: " + Arrays.toString(arr));

        // №1.2: Сортировка выборкой
        System.out.println("[Сортировка выборкой]");
        System.out.println("До сортировки: " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("После сортировки: " + Arrays.toString(arr));

        // №2: Удаление четных чисел
        System.out.println("[Удаление четных чисел]");
        System.out.println("До удаления четных чисел: " + list);
        removeEvenNumbers(list);
        System.out.println("После удаления четных чисел: " + list);

        // №3: ArrayList Min Max Avg
        System.out.println("[ArrayList Min Max Avg]");
        findMinMaxAvg(list);
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    public static void merge(int[] arr, int left, int middle, int right) {
        int[] tempArr = new int[right - left + 1];
        int i = left;
        int j = middle + 1;
        int k = 0;

        while (i <= middle && j <= right) {
            if (arr[i] <= arr[j]) {
                tempArr[k] = arr[i];
                i++;
            } else {
                tempArr[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            tempArr[k] = arr[i];
            i++;
            k++;
        }

        while (j <= right) {
            tempArr[k] = arr[j];
            j++;
            k++;
        }

        for (k = 0; k < tempArr.length; k++) {
            arr[left + k] = tempArr[k];
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void removeEvenNumbers(ArrayList<Integer> list) {
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            int num = iter.next();
            if (num % 2 == 0) {
                iter.remove();
            }
        }
    }

    public static void findMinMaxAvg(ArrayList<Integer> list) {
        int min = Collections.min(list);
        int max = Collections.max(list);
        double sum = 0.0;
        for (int num : list) {
            sum += num;
        }
        double avg = sum / list.size();
        System.out.println("Минимальное значение: " + min);
        System.out.println("Максимальное значение: " + max);
        System.out.println("Среднее значение: " + avg);
    }
}

package hw5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PhoneBook {
    public static void main(String[] args) throws IOException {
        // №1. Создание и заполнение телефонной книги из файла
        HashMap<String, List<String>> phoneBook = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader("hw5/phonebook.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String fullName = parts[0];
            String phoneNumber = parts[1];

            if (!phoneBook.containsKey(fullName)) {
                phoneBook.put(fullName, new ArrayList<>());
            }
            phoneBook.get(fullName).add(phoneNumber);
        }
        reader.close();

        // №2. Поиск повторяющихся имен и сортировка результатов
        HashMap<String, Integer> nameOccurrences = new HashMap<>();
        for (String fullName : phoneBook.keySet()) {
            String[] names = fullName.split(" ");
            String name = names[0];
            if (!nameOccurrences.containsKey(name)) {
                nameOccurrences.put(name, 0);
            }
            nameOccurrences.put(name, nameOccurrences.get(name) + 1);
        }

        List<Map.Entry<String, Integer>> sortedNameOccurrences = new ArrayList<>(nameOccurrences.entrySet());
        Collections.sort(sortedNameOccurrences, (e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        System.out.println("Повторяющиеся имена с количеством повторений:");
        for (Map.Entry<String, Integer> entry : sortedNameOccurrences) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // №3. Реализация алгоритма пирамидальной сортировки (HeapSort)
        int[] arr = {9, 5, 2, 8, 1, 6};
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("Отсортированный массив: " + Arrays.toString(arr));
    }

    // Метод для реализации пирамидальной сортировки
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Построение max-кучи
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Извлечение элементов из кучи и сортировка массива
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    // Метод для превращения подмассива в max-кучу
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно применяем heapify к затронутой подкуче
            heapify(arr, n, largest);
        }
    }
}



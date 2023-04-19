package hw2;

import java.util.HashMap;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод количества строк в книге
        System.out.print("Введите количество строчек в книге: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Считываем лишний символ новой строки

        // Ввод строк книги
        System.out.println("Введите строки книги:");
        String[] cookbook = new String[n];
        for (int i = 0; i < n; i++) {
            cookbook[i] = scanner.nextLine();
        }

        // Ввод количества аллергических продуктов
        System.out.print("Введите количество аллергических продуктов: ");
        int m = scanner.nextInt();
        scanner.nextLine(); // Считываем лишний символ новой строки

        // Создание словаря для хранения замен продуктов
        HashMap<String, String> replacements = new HashMap<>();
        System.out.println("Введите замены продуктов:");
        for (int i = 0; i < m; i++) {
            String[] line = scanner.nextLine().split(" - ");
            replacements.put(line[0], line[1]);
        }

        // Замена продуктов в книге
        for (int i = 0; i < n; i++) {
            String[] words = cookbook[i].split(" ");
            for (int j = 0; j < words.length; j++) {
                String word = words[j];
                if (replacements.containsKey(word)) {
                    words[j] = replacements.get(word);
                }
            }
            cookbook[i] = String.join(" ", words);
            System.out.println(cookbook[i]);
        }

        scanner.close();
    }
}

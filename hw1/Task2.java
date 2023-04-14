import java.util.Scanner;


public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод числа n
        System.out.print("Введите число n: ");
        int n = scanner.nextInt();

        int[] numbers = new int[n];

        // Ввод n чисел
        System.out.println("Введите " + n + " чисел, по одному на каждой строке:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Ввод числа, на которое нужно умножить все числа
        System.out.print("Введите число для умножения: ");
        int multiplier = scanner.nextInt();

        System.out.println("Результат умножения:");

        // Умножение и вывод результата построчно
        for (int i = 0; i < n; i++) {
            int result = numbers[i] * multiplier;
            System.out.println(result);
        }

        scanner.close();
    }
}

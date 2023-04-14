import java.util.Scanner;

public class CubeCalculator {
    public static void main(String[] args) {
        // Создаем массив для хранения кубов чисел
        int[] cubes = new int[1000];
        for (int i = 0; i < 1000; i++) {
            cubes[i] = (i + 1) * (i + 1) * (i + 1);
        }

        // Вводим числа
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число (от 1 до 1000):");
        int num1 = scanner.nextInt();
        System.out.println("Введите второе число (от 1 до 1000):");
        int num2 = scanner.nextInt();

        // Поиск кубов чисел в массиве
        int cube1 = cubes[num1 - 1];
        int cube2 = cubes[num2 - 1];

        // Вывод результатов
        System.out.println("Куб первого числа: " + cube1);
        System.out.println("Куб второго числа: " + cube2);
    }
}

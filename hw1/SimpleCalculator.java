import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Поддерживаемые операции: +, -, *, /");
        System.out.println("Введите первое целое число:");
        int num1 = scanner.nextInt();

        System.out.println("Введите операцию (+, -, *, /):");
        String operator = scanner.next();

        System.out.println("Введите второе целое число:");
        int num2 = scanner.nextInt();

        int result = 0;
        boolean isValidOperator = true;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    System.out.println("Ошибка: деление на ноль недопустимо!");
                    isValidOperator = false;
                } else {
                    result = num1 / num2;
                }
                break;
            default:
                System.out.println("Ошибка: неподдерживаемая операция!");
                isValidOperator = false;
        }

        if (isValidOperator) {
            System.out.println("Результат: " + result);
        }

        scanner.close();
    }
}

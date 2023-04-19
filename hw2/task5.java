package hw2;

import java.util.Scanner;
import java.util.logging.Logger;

public class task5 {
    private static final Logger LOGGER = Logger.getLogger(task5.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LOGGER.info("Поддерживаемые операции: +, -, *, /");
        LOGGER.info("Введите первое целое число:");
        int num1 = scanner.nextInt();

        LOGGER.info("Введите операцию (+, -, *, /):");
        String operator = scanner.next();

        LOGGER.info("Введите второе целое число:");
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
                    LOGGER.warning("Ошибка: деление на ноль недопустимо!");
                    isValidOperator = false;
                } else {
                    result = num1 / num2;
                }
                break;
            default:
                LOGGER.warning("Ошибка: неподдерживаемая операция!");
                isValidOperator = false;
        }

        if (isValidOperator) {
            LOGGER.info("Результат: " + result);
        }

        scanner.close();
    }
}

package hw2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getLogger("ErrorLogger");

        try {
            System.out.print("Введите число: ");
            byte number = scanner.nextByte();
            writeToFile(number);
        } catch (InputMismatchException e) {
            logger.log(Level.SEVERE, "Ошибка: введено неверное значение", e);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка: не удалось записать в файл", e);
        }

        scanner.close();
    }

    public static void writeToFile(byte number) throws IOException {
        FileWriter fileWriter = new FileWriter("result.txt");
        fileWriter.write(Byte.toString(number));
        fileWriter.close();
    }
}

package hw2;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class task4 {

    private static final Logger LOGGER = Logger.getLogger(task4.class.getName());

    public static void main(String[] args) {
        String fileUrl = "https://raw.githubusercontent.com/aksodar/JSeminar_2/master/src/main/resources/example.txt";
        String localFilename = "example.txt";
        String name = "Ваше имя";

        task4 t4 = new task4();

        // Скачиваем файл по указанной URL и получаем его содержимое
        String fileContent = t4.download(fileUrl, localFilename);

        // Изменяем содержимое файла подставляя имя
        String changedContent = t4.change(name, fileContent);

        // Сохраняем измененное содержимое файла локально
        t4.saveOnLocal(localFilename, changedContent);

        // Читаем сохраненный файл и выводим его содержимое в логгер
        t4.read(localFilename);

        // Удаляем сохраненный файл
        t4.removeFromLocale(localFilename);
    }

    public String download(String url, String localFilename) {
        String fileContent = "";
        try {
            // Открываем соединение по указанной URL
            URL urlObj = new URL(url);
            InputStream inputStream = urlObj.openStream();

            // Читаем содержимое файла
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
            }
            fileContent = stringBuilder.toString();

            // Закрываем соединение и поток чтения
            inputStream.close();
            reader.close();

        } catch (IOException e) {
            LOGGER.severe("Ошибка при скачивании файла: " + e.getMessage());
        }
        return fileContent;
    }

    public String change(String name, String fileContent) {
        // Заменяем маску "%s" на указанное имя
        return fileContent.replace("%s", name);
    }

    public void read(String localFilename) {
        try {
            // Читаем содержимое сохраненного файла
            BufferedReader reader = new BufferedReader(new FileReader(localFilename));
            String line;
            while ((line = reader.readLine()) != null) {
                LOGGER.info(line);
            }

            // Закрываем поток чтения
            reader.close();

        } catch (IOException e) {
            LOGGER.severe("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    public void saveOnLocal(String fileName, String fileContent) {
        try {
            // Записываем содержимое файла в локальный файл
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(fileContent);

            // Закрываем поток записи
            writer.close();

        } catch (IOException e) {
            LOGGER.severe("Ошибка при сохранении файла: " + e.getMessage());
        }
    }

    public boolean removeFromLocale(String fileName) {
        // Удаляем сохраненный файл
        File file = new File(fileName);
        if (file.delete()) {
            LOGGER.info("Файл успешно удален: " + fileName);
            return true;
        } else {
            LOGGER.severe("Ошибка при удалении файла: " + fileName);
            return false;
        }
    }
}

package hw2;

public class task1 {
    public static void main(String[] args) {
        // Входные данные: строка s и массив индексов index
        String s = "cba";
        int[] index = {2, 1, 0};

        // Создаем объект класса, содержащего метод shuffle
        // (если метод shuffle не статический)
        // ShuffleString shuffleString = new ShuffleString();

        // Вызываем метод shuffle и сохраняем результат
        String result = shuffle(s, index);

        // Выводим результат на экран
        System.out.println("Результат перетасовки: " + result);
    }

    public static String shuffle(final String s, final int[] index){
        // Проверяем наличие строкового ввода и массива индексов
        if(s == null || index == null || s.length() != index.length) {
            throw new IllegalArgumentException("Некорректные входные данные!");
        }

        // Создаем массив символов из строки s
        char[] charArray = s.toCharArray();
        // Создаем массив для результата
        char[] resultArray = new char[charArray.length];

        // Заполняем массив результатов перемещением символов на указанные индексы
        for(int i = 0; i < charArray.length; i++) {
            resultArray[index[i]] = charArray[i];
        }

        // Преобразуем массив результатов в строку и возвращаем ее
        return new String(resultArray);
    }
}
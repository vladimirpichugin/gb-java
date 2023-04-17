import java.util.ArrayList;
import java.util.List;

public class Task4 {
    static char[] data;
    static List<Integer> symbolIndex;
    static boolean solveFinded = false;

    public static void main(String[] args) {
        String inputData = "2 + ? = 4";
        findTrueNumber(inputData);
        if (solveFinded){
            System.out.println("Решено!");
        } else {
            System.out.println("Нет решения.");
        }
    }

    public static void findTrueNumber(String inputData) {
        data = inputData.replace(" ", "").toCharArray();
        char searchingSymbol = '?';
        symbolIndex = findSymbolIndex(data, searchingSymbol);
        combWithRec(new int[symbolIndex.size()], 0, 10);
    }

    public static void combWithRec(int[] comb, int index, int k) {
        if (index == comb.length) {
            checkComb(comb);
            return;
        }

        for (int i = 0; i < k; i++) {
            comb[index] = i;
            combWithRec(comb, index + 1, k);
        }
    }

    public static void checkComb(int[] comb) {
        for (int i = 0; i < comb.length; i++) {
            data[symbolIndex.get(i)] = Character.forDigit(comb[i], 10);
        }

        String[] numbers = String.valueOf(data).split("-");
        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[1]);
        int c = Integer.parseInt(numbers[2]);

        if (a + b == c) {
            System.out.printf("%d + %d = %d\n", a, b, c);
            solveFinded = true;
        }
    }

    public static List<Integer> findSymbolIndex(char[] data, char symbol) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            if (data[i] == '+' || data[i] == '=') {
                data[i] = '-';
            }
            if (data[i] == symbol) {
                result.add(i);
            }
        }
        return result;
    }
}

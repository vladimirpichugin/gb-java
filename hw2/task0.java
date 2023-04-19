package hw2;

public class task0 {
    public static void main(String[] args) {
        String jewels = "aB";
        String stones = "aaaAbbbB";
        String result = findJewelsInStones(jewels, stones);
        System.out.println(result);
    }

    public static String findJewelsInStones(String jewels, String stones) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < jewels.length(); i++) {
            char jewel = jewels.charAt(i);
            int count = 0;
            for (int j = 0; j < stones.length(); j++) {
                char stone = stones.charAt(j);
                if (jewel == stone) {
                    count++;
                }
            }
            result.append(jewel).append(count);
        }
        return result.toString();
    }
}

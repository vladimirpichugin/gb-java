package hw4;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class task2 {
    public static void main(String[] args) {
        Deque<Integer> d1 = new ArrayDeque<>(Arrays.asList(1, 2, 3));
        Deque<Integer> d2 = new ArrayDeque<>(Arrays.asList(5, 4, 7));
        Deque<Integer> result = new ArrayDeque<>();

        int carry = 0;

        while (!d1.isEmpty() || !d2.isEmpty() || carry != 0) {
            int sum = carry;

            if (!d1.isEmpty()) {
                sum += d1.removeFirst();
            }

            if (!d2.isEmpty()) {
                sum += d2.removeFirst();
            }

            carry = sum / 10;
            int digit = sum % 10;

            result.addLast(digit);
        }

        System.out.println(result); // [6, 6, 0, 1]
    }
}

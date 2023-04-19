package hw4;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class task1 {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        boolean isPalindrome = true;

        while (deque.size() > 1) {
            int first = deque.removeFirst();
            int last = deque.removeLast();

            if (first != last) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println(isPalindrome ? "Последовательность является палиндромом" : "Последовательность не является палиндромом");

    }
}
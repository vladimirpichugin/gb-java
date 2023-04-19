package hw4;

import java.util.ArrayDeque;
import java.util.Deque;


class task3 {
    public static void main(String[] args) {

        System.out.println(validate("()")); // true
        System.out.println(validate("()[]{}")); // true
        System.out.println(validate("(]")); // false
        System.out.println(validate("([)]")); // false
        System.out.println(validate("{[]}")); // true
    }

    public static boolean validate(String s){
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
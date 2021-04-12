package Solution;

import java.util.Stack;

/**
 * 移除K位数字
 * https://leetcode-cn.com/problems/remove-k-digits/
 */
public class RemoveKNumbers {
    public static String removeKdigits(String num, int k) {
        if(num == null || k >= num.length()) return "0";

        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int removed = 0;

        for(int i = 0;  i < num.length(); i++) {
            while(!stack.isEmpty() && stack.peek() > num.charAt(i) && removed < k) {
                stack.pop();
                removed++;
            }
            stack.push(num.charAt(i));
        }

        for(; removed < k && !stack.isEmpty(); removed++)
            stack.pop();

        for (Character character : stack) {
            if(ans.length() == 0 && character == '0')
                continue;
            ans.append(character);
        }

        return ans.toString();
    }
}

package Solution;

import org.junit.Test;

public class BasicCalculator {
    public static int calculate(String s) {
        int ans = 0;
        boolean positive = true;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;  i < s.length(); i++) {
            switch (s.charAt(i)) {
                case ' ':
                    break;
                case '+':
                    positive = true;
                    break;
                case '-':
                    positive = false;
                    break;
                case '(':
                    break;
                case ')':
                    break;
                default:
                    stringBuilder.append(s.charAt(i));
                    break;
            }
        }

        return ans;
    }
}

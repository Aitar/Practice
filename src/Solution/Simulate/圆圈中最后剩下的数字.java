package Solution.Simulate;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 */
public class 圆圈中最后剩下的数字 {
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++)
            list.add(i);

        for(int i = (m - 1) % n; n > 1; i = (i + m - 1) % n) {
            list.remove(i);
            n--;
        }

        return list.get(0);
    }

    @Test
    public void test() {
        System.out.println(lastRemaining(10, 17));
    }
}

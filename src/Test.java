import Entity.TreeNode;
import Solution.CountBitOne;
import Solution.RemoveKNumbers;
import Solution.SpiralOrder;

import java.util.*;

public class Test {

    @org.junit.Test
    public void spiralOrderTest() {
        int[][] test = {
                {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}
        };
        List<Integer> list = SpiralOrder.spiralOrder(test);
        System.out.println(list.toString());
    }

    @org.junit.Test
    public void removeKDigitsTest() {
        String str = "1432219";
        System.out.println(RemoveKNumbers.removeKdigits(str, 3));
    }

    @org.junit.Test
    public void unserializePreOrderTest() {
        String serie = "1,2,#,3,#,#,4,5,#,#,6,7,#,#,#";
        TreeNode node = TreeNode.unserializePreOrder(serie);
        if (node != null)
            System.out.println(node.serilaizePreeOrder().equals(serie));
        System.out.println();
    }

    @org.junit.Test
    public void zeroStartIntTest() {
        CountBitOne countBitOne = new CountBitOne();
        long before = System.currentTimeMillis();
        for(int i = 0; i < 10_000_000; i++)
            countBitOne.hammingWeight2(i);
        long cost = System.currentTimeMillis() - before;
        System.out.println("共用 " + cost + "毫秒");
    }

    @org.junit.Test
    public void listTest() {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        Integer[] integers = set.toArray(new Integer[0]);
        System.out.println();
    }
}


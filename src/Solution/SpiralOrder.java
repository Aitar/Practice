package Solution;

import java.util.LinkedList;
import java.util.List;

public class SpiralOrder {

    public static List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length <= 0) return null;

        int n = matrix.length, m = matrix[0].length, up = 0, left = 0;
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        LinkedList<Integer> ans = new LinkedList<>();
        int d = 0, x = 0, y = 0, total = n * m;

        while(ans.size() < total) {
            System.out.println("x: " + x + ", y: " + y);
            ans.addLast(matrix[x][y]);
            if((d == 0 && y == m - 1)
            || (d == 1 && x == n - 1)
            || (d == 2 && y == up)
            || (d == 3 && x == left)) {
                d = (d + 1) % 4;
                if(d == 3) {
                    n--;
                    m--;
                    up++;
                    left++;
                }
            }
            x += dir[d][0];
            y += dir[d][1];
        }

        return ans;
    }
}

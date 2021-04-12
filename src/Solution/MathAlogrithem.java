package Solution;

import org.junit.Test;

public class MathAlogrithem {

    /**
     * 打印n行的杨辉三角
     * @param n 杨辉三角的行数
     */
    public void printYangHuiTri(int n) {
        int[] ans = new int[(1 + n) * n / 2];
        for(int i = 0; i < n; i++) {
            int start = (1 + i) * i / 2, end = start + i;
            int preStart = (i - 1) * i / 2;
            for(int j = start; j <= end; j++) {
                if(j == start || j == end) ans[j] = 1;
                else ans[j] = ans[preStart + j - start - 1] + ans[preStart + j - start];
                System.out.print(ans[j] + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void printYangHuiTest(){
        printYangHuiTri(10);
    }

    /**
     * 判断是否为质数
     * 从n的根号开始判断是否能整除
     */
    public boolean isPrime(int n) {
        int max = (int) Math.sqrt(n) + 1;
        for(int i = 2; i < max; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    @Test
    public void isPrimeTest() {
        int count = 0;
        for(int i = 1081; i < 1512; i++) {
            if(isPrime(i)) {
                System.out.println(i);
                count++;
            }
        }
        System.out.println(count);
    }
}

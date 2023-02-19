package Assestment_2_1;

public class RecursionTest {
    public static void main(String[] args) {
        System.out.println(summa(4));
    }
    public static long summa(int n) {
        long sum = 1;
        for (int i = 1; i < n; i++) {
            sum = summa(i)*2;
            }
        return sum;
    }
}

package Assestment_2_1;

public class RecursionTest {
    public static int computePay(int day) {
        if (day == 1) {
            return 1;
        } else {
            return 2 * computePay(day - 1);
        }
    }

    public static long computeSavings(int day) {
        if (day == 1) {
            return 1;
        } else {
            return computePay(day) + computeSavings(day - 1);
        }
    }

    public static void main(String[] args) {
        int day = 39;
        int pay = computePay(day);
        long savings = computeSavings(day);
        System.out.println("Pay on day " + day + ": " + pay + " cents");
        System.out.println("Savings on day " + day + ": " + savings + " cents");
    }
}
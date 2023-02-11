import java.util.Scanner;

public class Assestment_1_2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = "sdsdVasiliy";
        String B = "ffffMKot";
        /* Enter your code here. Print output to STDOUT. */

        int numOfCharA = A.length();
        int numOfCharB = B.length();
        int sumOfAandB = numOfCharA + numOfCharB;
        System.out.println("Sum of the lengths of A and B is " + sumOfAandB);

        if (A.compareTo(B) > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        String a = A.substring(0, 1).toUpperCase() + A.substring(1);
        String b = B.substring(0, 1).toUpperCase() + B.substring(1);
        System.out.println(a +" "+ b);
    }
}


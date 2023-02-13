public class Recurrsion {
            public static void main(String[] args) {
                countDown(3);
            }
            public static void countDown (int n) {
                System.out.println(n);
                if(n > 1) {
                    countDown(n-1);
                }
            }
        }

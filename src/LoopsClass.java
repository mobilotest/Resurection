public class LoopsClass {
    public static void main(String[] args) {
        int [] a = {1, 2, 3, 4, 5};
        int sum = 0;
        for(int i=0; i<5; ++i){
            sum += a[i];
        }
        System.out.println("sum is = "+sum);
        System.out.println("= = = = = = =");

        int [] b = new int[5];
        int sum2 = 0;
        for(int i=0; i<b.length; ++i){
            sum2+=b[i];
        }
        System.out.println("Sum2 = "+sum2);
        System.out.println("= = = = = = =");

        int count = 0;
        for(int i=0; i<=10; ++i){
            for(int j=0; j<=10; j++){
                count++;
            }
        }
        System.out.println("Count = "+count);
        System.out.println("= = = = = = =");
        int sum3 = 0;
        int sum4 = 0;
        int sum5 = 0;
        int sum6 = 0;
        System.out.println("- - - - - - -");
        for(int i=0; i<=5; ++i) {
            sum3++;
            System.out.print("1");
        }
        System.out.println("- - - - - - -");
        for(int i=5; i>=0; --i) {
            sum4++;
            System.out.print("1");
        }
        System.out.println("- - - - - - -");
        for(int i=5; i<15; i+=2) {
            sum5++;
            System.out.print("1");
        }
        System.out.println("- - - - - - -");
        for(int i=-5; i<=0; ++i) {
            sum6++;
            System.out.print("1");
        }
        System.out.println("- - - - - - -");
        System.out.println("sum3 = "+sum3);
        System.out.println("sum3 = "+sum4);
        System.out.println("sum3 = "+sum5);
        System.out.println("sum3 = "+sum6);

        System.out.println("= = = = = = =");
        int x = 0;
        int c = 2;

        switch (c)
        {
            case 0:
                ++x;
            case 1:
                --x;
            case 2:
                ++x;
            case 3:
                x+=2;
            default:
                --x;
        }
        System.out.println("X = " + x);
        System.out.println("= = = = = = =");

        System.out.println("5%2 = "+5%2 + "... 5/4 = "+ 5/4);
        System.out.println(5%2 - 5/4);

        System.out.println("= = = = = = =");
        double balance = 19713.00d;
        double interest = 4.662d;
        double output = (((interest * balance) / 12) * 3) / 100;
        System.out.println(output - 100);

        System.out.println("= = = = = = =");
        int number=0;
        int count2 = 3;
        {
            System.out.println(count2);
            count2++;
        }
        while (count2 <= number)
        {
            System.out.println(count2);
            count2++;
        }
        System.out.println("= = = = = = =");
    }
}

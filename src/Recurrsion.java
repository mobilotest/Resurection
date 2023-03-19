public class Recurrsion {
    public static void main(String[] args) {
//        countDown(3);
        System.out.println(sumOf(3));
        System.out.println("##############################");

        System.out.println(mystery(9));
        System.out.println("##############################");

//        System.out.println(f(new int[]{3},1,3));
        System.out.println("##############################");

        System.out.println(unknown(4));

        System.out.println("##############################");
        recurse(3);
        System.out.print("---");
        recurse(2);
    }
        public static void recurse(int x)
        {
            if (x<=1)
                System.out.print("***");
            else if ((x % 2) == 0)
            {
                System.out.print("+++");
                recurse(x-2);
            }
            else
            {
                System.out.print(x);
                recurse(x-1);
            }
        }

    public static int max(int[] a) {           //public static int max(int[] a) {

        int max = a[0];                         //int max = a[0];

        int n = a.length;                       //int n = a.length;

        for(int i = 1; i < n; i++)              //for(int i = 1; i < n; i++)

            if(a[i] > max) max = a[i];          //if(a[i] > max) max = a[i];

        return max;                             //return max;

    }
    static int unknown(int n)
    {
        if (n > 0)
        {
            System.out.print("?");
            unknown(n-1);
        }
        return n;
    }
    public static int f(int [] a, int begin, int end) {
        if(begin == end) {
            return a[begin];
        }
        int mid = (begin + end)/2;
        int a1 =f(a, begin, mid);
        int a2 = f(a, mid + 1, end);

        return (a1 > a2) ? a1 : a2;
    }
    static int mystery(int n){
        if (n < 1)
            return 0;
        else if (n % 2 == 0)
            return mystery(n-1);
        else return 1 + mystery(n-1);
    }
    public static void countDown (int n) {
        System.out.println(n);
        if(n > 1) {
            countDown(n-1);
        }
    }

    public static int sumOf(int n) {
        int sum;
        if(n == 1) {
            sum = 1;
        }else{
            sum = sumOf(n - 1) + n;
        }
        return sum;
    }

//    public void displayBackward() {
//        displayChainBackward(topNode);
//    }
//    private void displayChainBackward(Node node) {
//        if(node == null)
//            return;
//        displayChainBackward(node.getNextNode());
//        System.out.println(node.getData());
//    }
}

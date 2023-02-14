public class Recurrsion {
    public static void main(String[] args) {
//        countDown(3);
        sumOf(3);
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

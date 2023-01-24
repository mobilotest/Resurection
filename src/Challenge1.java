public class Challenge1 {
    public static void main(String[] args) {
        byte varByte = 7;
        short varShrot = 333;
        int varInt = 1234;

        long varLong = 50000L + 10L * (varByte + varShrot + varInt);
        System.out.println(varLong);
    }
}

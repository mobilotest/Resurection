public class ByteShortIntLong {
    public static void main(String[] args) {
        int myValue = 10_000;
        int myMinIntValue = Integer.MIN_VALUE;
        int myMaxIntValue = Integer.MAX_VALUE;

        System.out.println("Integer min value = "+ myMinIntValue);
        System.out.println("Integer max value = "+ myMaxIntValue);
        System.out.println("Busted MAX value = "+ (myMaxIntValue + 1));
        System.out.println("Busted MIN value = "+ (myMinIntValue - 1));
        System.out.println(myValue);
        int myMaxIntTest = 2_147_483_647;

        byte myMinByteValue = Byte.MIN_VALUE;
        byte myMaxByteValue = Byte.MAX_VALUE;
        System.out.println("Byte min value = "+ myMinByteValue);
        System.out.println("Byte max value = "+ myMaxByteValue);

        short myMinShortValue = Short.MIN_VALUE;
        short myMaxShortValue = Short.MAX_VALUE;
        System.out.println("Short min value = "+ myMinShortValue);
        System.out.println("Short max value = "+ myMaxShortValue);

        long lyLongValue = 100L;
        long myMinLongValue = Long.MIN_VALUE;
        long myMaxLongValue = Long.MAX_VALUE;
        System.out.println("Long min value = "+ myMinLongValue);
        System.out.println("Long max value = "+ myMaxLongValue);
        long bigLongLiteralNum = 2_147_483_647L;
        System.out.println(bigLongLiteralNum);

        short bigShortLiteralNum = 32767;

        int newIntValue = (myMaxIntValue / 2);
        short newShortValue = (short) (myMaxShortValue / 2);
        byte newByteValue = (byte) (myMaxByteValue / 2);
    }
}

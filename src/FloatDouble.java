public class FloatDouble {
    public static void main(String[] args) {
//        float myFloatMinValue = Float.MIN_VALUE;
//        float myFloatMaxValue = Float.MAX_VALUE;
//        System.out.println("Float min value = "+myFloatMinValue);
//        System.out.println("Float max value = "+myFloatMaxValue);

        double myDoubleMinValue = Double.MIN_VALUE;
        double myDoubleMaxValue = Double.MAX_VALUE;
        System.out.println("Double min value = "+myDoubleMinValue);
        System.out.println("Double max value = "+myDoubleMaxValue);

        int myIntValue = 5 / 3;
        float myFloatValue = 5.25f / 3f;
        double myDoubleValue =5.25d / 3d; // 5.00 / 3.00

        System.out.println("My int value = "+myIntValue);
        System.out.println("My float value = "+myFloatValue);
        System.out.println("My double value = "+myDoubleValue);
    }
}

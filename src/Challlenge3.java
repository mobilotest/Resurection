public class Challlenge3 {
    public static void main(String[] args) {
        double var1 = 20.00d;
        double var2 = 80.00d;
        double varRes = (var1 + var2) * 100.00d;
        double varRem = varRes % 40.00d;
        System.out.println(varRem);

        boolean isRem = (varRem == 0) ? true : false;
        System.out.println(isRem);
        if(!isRem){
            System.out.println("Got some reminder");
        }
    }
}

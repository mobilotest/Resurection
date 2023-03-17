public class Sorting {
    public static void main(String[] args) {
        int[] a = {2, 3, 5, 7, 11, 13,17, 19, 23, 29, 31, 37};
        System.out.println(binarySearch(a, 2));
    }

    public static boolean binarySearch(int[] a, int item) {
        int first = 0;
        int last = a.length - 1;
        while( first <= last) {
            int mid = (first + last)/2;
            if(a[mid] == item) return true;
            else if (a[mid] < item) first = mid + 1;
            else                           last = mid - 1;
        }
        return false;
    }
}

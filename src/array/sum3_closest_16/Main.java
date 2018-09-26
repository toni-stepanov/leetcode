package array.sum3_closest_16;


public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {1,1,-1,-1,3};
        int sumClosest = s.threeSumClosest2(a,3);
        System.out.println("sumClosest = " + sumClosest);
    }
}
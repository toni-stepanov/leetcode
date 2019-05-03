package array.merge_intervals_56;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] res = s.merge(new int[][]{{1,2}, {1,3}});
        for(int[] r : res) {
            System.out.println(r[0] + " : " + r[1]);
        }
    }
}



package graph.course_schedule_207;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        //int[][] pre = new int[][]{{1,2}, {2,1}};
        //boolean result = s.canFinish2(3, pre);
        boolean result = s.canFinish(1, new int[][]{});
        System.out.println(result);
    }
}



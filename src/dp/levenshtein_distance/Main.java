package dp.levenshtein_distance;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.findMinEditDistance("intention", "execution") ;
        System.out.println(result);
    }
}



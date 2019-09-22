package backtracking.restore_IPA_adresses_93;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> res = s.restoreIpAddresses("25525511135");

        for (String ip : res) {
            System.out.println(ip);
        }
    }
}


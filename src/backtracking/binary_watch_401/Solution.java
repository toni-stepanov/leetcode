package backtracking.binary_watch_401;

import java.util.ArrayList;
import java.util.List;

/**
 Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

 Example:

 Input: n = 1
 Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 Note:
 The order of output does not matter.
 The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
 The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
 */
public class Solution {

    private List<String> res;

    List<String> readBinaryWatch(int num) {
        res = new ArrayList<>();
        bt(0, num, 0, 0);
        return res;
    }

    private void bt(int index, int num, int hours, int min) {
        if (hours > 11 || min > 59) return;
        if (num == 0) {
            res.add(getTime(hours, min));
        }
        for (int i = index; i < 10; i++) {
            if (i < 4) {
                bt(i+1, num-1, (int) (Math.pow(2, i) + hours), min);
            } else {
                bt(i+1, num-1, hours, (int) (Math.pow(2, (i-4)) + min));
            }
        }
    }

    private String getTime(int hours, int min) {
        return String.valueOf(hours) + ":" + (min < 10 ? "0" : "") + min;
    }
}
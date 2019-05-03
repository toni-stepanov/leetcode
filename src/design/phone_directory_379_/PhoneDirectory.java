package design.phone_directory_379_;

/*
379. Design Phone Directory
https://leetcode.com/problems/design-phone-directory/#/description

Design a Phone Directory which supports the following operations:

get: Provide a number which is not assigned to anyone.
check: Check if a number is available or not.
release: Recycle or release a number.
Example:

// Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
PhoneDirectory directory = new PhoneDirectory(3);

// It can return any available phone number. Here we assume it returns 0.
directory.get();

// Assume it returns 1.
directory.get();

// The number 2 is available, so return true.
directory.check(2);

// It returns 2, the only number that is left.
directory.get();

// The number 2 is no longer available, so return false.
directory.check(2);

// Release number 2 back to the pool.
directory.release(2);

// Number 2 is available again, return true.
directory.check(2);
* */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// https://discuss.leetcode.com/topic/53094/java-ac-solution-using-queue-and-set
public class PhoneDirectory {
    private Set<Integer> inUse = new HashSet<>();
    private Queue<Integer> readyToUse = new LinkedList<>();
    private int currentMaxNumber = 0;
    private int maxNumbers;

    /**
     * Initialize your data structure here
     *
     * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
     */
    PhoneDirectory(int maxNumbers) {
        this.maxNumbers = maxNumbers;
    }

    /**
     * Provide a number which is not assigned to anyone.
     *
     * @return - Return an available number. Return -1 if none is available.
     */
    public int get() {
        int nextNumber = -1;
        if (readyToUse.isEmpty() && (currentMaxNumber == maxNumbers)) {
            return nextNumber;
        }
        if (!readyToUse.isEmpty()) {
            nextNumber = readyToUse.remove();
        } else if (currentMaxNumber < maxNumbers) {
            nextNumber = currentMaxNumber;
            currentMaxNumber++;
        }
        inUse.add(nextNumber);
        return nextNumber;
    }

    /**
     * Check if a number is available or not.
     */
    public boolean check(int number) {
        return !inUse.contains(number);
    }

    /**
     * Recycle or release a number.
     */
    void release(int number) {
        if (inUse.contains(number)) {
            inUse.remove(number);
            readyToUse.add(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
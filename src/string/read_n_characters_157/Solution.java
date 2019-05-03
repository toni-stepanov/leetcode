package string.read_n_characters_157;

/*
https://leetcode.com/problems/read-n-characters-given-read4/description/
157. Read N Characters Given Read4

The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read.
For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n)
that reads n characters from the file.

Note:
The read function will only be called once for each Snake_3 case.
*/

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        boolean eof = false;
        int counter = 0;
        int offset = 0;
        while (!eof && counter < n) {
            int wasRead = read4(buffer); // read 4 chars from file and put them to the buffer
            int PART_LEN = 4;
            if (wasRead < PART_LEN) {
                eof = true;
            }
            int bytes = Math.min(wasRead, n-counter);
            System.arraycopy(buffer, 0, buf, offset, bytes);
            counter += bytes;
            offset += PART_LEN;
        }
        return counter;
    }
}

class Reader4 {
    int read4(char[] buf) {
        return 3;
    }
}

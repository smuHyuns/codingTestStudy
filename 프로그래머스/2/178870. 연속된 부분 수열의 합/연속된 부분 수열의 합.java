import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int len = sequence.length;
        int start = 0;
        int end = 0;
        int sum = sequence[0];

        int minStart = 0;
        int minEnd = len - 1;

        while (start <= end && end < len) {
            if (sum == k) {
                if ((end - start) < (minEnd - minStart)) {
                    minStart = start;
                    minEnd = end;
                }
                end++;
                if (end < len) sum += sequence[end];
            } else if (sum < k) {
                end++;
                if (end < len) sum += sequence[end];
            } else {
                sum -= sequence[start];
                start++;
            }
        }

        return new int[]{minStart, minEnd};
    }
}

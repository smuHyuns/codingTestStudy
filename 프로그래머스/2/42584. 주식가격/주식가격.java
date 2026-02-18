import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<int[]> stack = new Stack<>();
        
        int len = prices.length;
        int[] times = new int[len];
        
        for(int i=0; i<len; i++) {
            // 비어있지 않은 경우 - 가격이떨어진 경우 체크
            while(!stack.isEmpty() && stack.peek()[0] > prices[i]) {
                int[] info = stack.pop();
                int index = info[1];
                times[index] = i - index;
            }
            
            stack.push(new int[] {prices[i], i});
        }
        
        while(!stack.isEmpty()) {
            int[] info = stack.pop();
            int index = info[1];
            times[index] = len - 1 - index;
        }

        return times;
    }
}
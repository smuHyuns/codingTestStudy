import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = getQueue(queue1);
        Queue<Integer> q2 = getQueue(queue2);
        
        int maxTry = Math.max(q1.size(), q2.size()) * 3;
        
        long sum1 = getSum(queue1);
        long sum2 = getSum(queue2);
        
        for(int count = 0; count <maxTry; count++){
            if(sum1 == sum2) return count;
            else if(sum1 < sum2) {
                int poll = q2.poll();
                sum1 += poll;
                sum2 -= poll;
                q1.add(poll);
            }
            else if(sum1 > sum2) {
                int poll = q1.poll();
                sum1 -= poll;
                sum2 += poll;
                q2.add(poll);
            }
        }
        
        return -1;
    }
    
    public Queue<Integer> getQueue(int[] array) {
        Queue<Integer> q = new LinkedList<>();
        
        for(int num : array) {
            q.add(num);
        }
        
        return q;
    }
    
    public long getSum(int[] array) {
        long sum = 0;
        for(int num : array) {
            sum += num;
        }
        return sum;
    }
}
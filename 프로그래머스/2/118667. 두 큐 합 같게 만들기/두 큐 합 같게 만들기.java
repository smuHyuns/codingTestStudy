import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int count = 0;
        long frontSum = 0 , total=0, maxEl = 0;
        Queue<Integer> frontQ = new LinkedList<>();
        Queue<Integer> backQ = new LinkedList<>();
        for(int i=0; i<queue1.length; i++){
            frontSum += queue1[i];
            total += queue1[i] + queue2[i];
            frontQ.offer(queue1[i]);
             backQ.offer(queue2[i]);
        }
        
        long target = total/2;
        
        if(total%2 != 0) return -1;
        
        int limit =  (queue1.length) *4;
        
        while(true){
            if(count > limit){
                count = -1;
                break;
            }
            if(frontSum == target){
                break;
            } else if(target < frontSum){
                    int temp = frontQ.poll();
                    backQ.offer(temp);
                    frontSum -= temp;
            } else {
                    int temp = backQ.poll();
                    frontQ.offer(temp);
                    frontSum += temp;
            }
            count++;
        }
        
        return count;
    }
}
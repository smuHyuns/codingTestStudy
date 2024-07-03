import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int count = 0;
        long frontSum = 0 , backSum = 0, maxEl = 0;
        Queue<Integer> frontQ = new LinkedList<>();
        Queue<Integer> backQ = new LinkedList<>();
        for(int i=0; i<queue1.length; i++){
            frontSum += queue1[i];
            backSum += queue2[i];
            frontQ.offer(queue1[i]);
             backQ.offer(queue2[i]);
            if(maxEl < queue1[i]) maxEl = queue1[i];
            if(maxEl <  queue2[i]) maxEl =  queue2[i];
        }
        
        if(maxEl > (frontSum+backSum)/2) return -1;
        while(true){
            if(count > (queue1.length*3)){
                count = -1;
                break;
            }
            if(backSum == frontSum){
                break;
            } else if(backSum < frontSum){
                if(frontQ.peek() != null){
                    int temp = frontQ.poll();
                    backQ.offer(temp);
                    backSum += temp;
                    frontSum -= temp;
                }
            } else {
                if(frontQ.peek() != null){
                    int temp = backQ.poll();
                    frontQ.offer(temp);
                    backSum -= temp;
                    frontSum += temp;
                }     
            }
            count++;
        }
        
        
        
        System.out.println(frontSum);
        System.out.println(backSum);
        
        return count;
    }
}
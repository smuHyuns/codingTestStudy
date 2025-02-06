import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> q = new PriorityQueue<>();
        for(int s : scoville){
            q.offer(s);
        }
        
        int count = 0;
        
        while(q.peek() < K && q.size() >= 2) {
            int food1 = q.poll();
            int food2 = q.poll();
            int newFood = food1 + food2*2;
            q.offer(newFood);
            count++;
        }
        
        if(q.size() == 1 && q.peek() < K) return -1;
        
        return count;
    }
}
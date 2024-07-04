import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int[] answer = new int[progresses.length];
        
        for(int i=0; i<progresses.length; i++){
            int count = (100-progresses[i]) / speeds[i];
            if( (100-progresses[i]) % speeds[i] != 0 ) count++;
            q.offer(count);
        }
    
        
        int cnt = 1;
        int nowMax = q.poll();
        while(!q.isEmpty()){
            int top = q.poll();
            if(nowMax < top){
                nowMax = top;
                list.add(cnt);
                cnt = 1;
            } else {
                cnt++;
            }
        }
        
        if(cnt != 0){
            list.add(cnt);
        }
        
        int[] ans = new int[list.size()];
        
        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
    
        return ans;
    }
}
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        
        int len = progresses.length;
        int[] times = new int[len];
        
        for(int i=0; i<len; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            int spendTimes = (100 - progress) / speed;
            spendTimes += (100-progress) % speed == 0 ? 0 : 1;
            times[i] = spendTimes;
        }
        
        int count = 0;
        int top = times[0];
        for(int i=0; i<len; i++) {
            if(top >= times[i]) {
                count ++;
            }
            else if(top < times[i]) {
                list.add(count);
                
                top = times[i];
                count = 1;
            }
        }
        list.add(count);
        
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
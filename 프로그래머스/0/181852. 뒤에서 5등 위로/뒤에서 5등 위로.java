import java.util.*;
class Solution {
    public int[] solution(int[] num_list) {
        Arrays.sort(num_list);
        
        int len = num_list.length - 5;
        int[] answer = new int[len];
        
        for(int i=0; i<len; i++){
            answer[i] = num_list[i+5];
        }
        
        return answer;
    }
}
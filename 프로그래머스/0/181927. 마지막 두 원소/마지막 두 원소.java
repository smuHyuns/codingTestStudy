import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int len = num_list.length;
        int[] answer = new int[len+1];
        
        for(int i=0; i<len; i++){
            answer[i] = num_list[i];
        }
        
        int last = answer[len-1];
        int before = answer[len-2];
        int add = 0;
        if(last > before) {
            add = last-before;
        } else {
            add = last*2;
        }
        
        answer[len] = add;
        
        return answer;
    }
}
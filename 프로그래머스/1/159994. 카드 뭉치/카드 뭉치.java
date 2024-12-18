import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goals) {
        int len1 = cards1.length;
        int len2 = cards2.length;
        
        int Idx1 = 0;
        int Idx2 = 0;
        
        for(String goal : goals){       
            if(Idx1 < len1 && goal.equals(cards1[Idx1])) Idx1++;
            else if( Idx2 < len2 && goal.equals(cards2[Idx2])) Idx2++;
            else return "No";
        }
        
        return "Yes";
    }
}
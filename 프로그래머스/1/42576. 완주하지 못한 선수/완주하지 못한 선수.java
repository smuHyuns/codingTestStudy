import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String,Integer> map = new HashMap<>();
        for(String p : participant){
            if(map.containsKey(p)){
                map.replace(p,map.get(p)+1);
            }
            else map.put(p, 1);
        }
        
        for(String c : completion){
            map.replace(c,map.get(c)-1);
        }
        
        for(String p : map.keySet()){
            if(map.get(p) == 1) return p;
        }
        
        return "";
    }
}
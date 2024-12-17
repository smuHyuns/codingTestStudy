import java.util.*;


class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photos) {
        List<Integer> result = new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<name.length; i++){
            map.put(name[i],yearning[i]);
        }
        
        for(String[] photo : photos){
            int point = 0;
            for(String p : photo){
                if(map.containsKey(p)){
                    point += map.get(p);
                }
            }
            result.add(point);
        }
        
        int[] answer = new int[result.size()];
        
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}
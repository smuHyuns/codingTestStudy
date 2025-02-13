import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 바로 뒷번호에게만 체육복 빌려줄 수 있음
        // 최대한 많은 학생이 체육수업
        int answer = 0;
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=1; i<=n; i++){
            map.put(i, 1);
        }
        
        for(int l : lost){
            map.replace(l,map.get(l)-1);
        }
        
        for(int r : reserve){
            map.replace(r,map.get(r)+1);
        }
        
        // key value - 번호 1개 한후
        // lost 면 -1 해주고 reserve 면 +1 해준다음
        // 자기기준 앞 뒤 확인 후 빌릴 수 있으면 빌림 ( == 2 일때 )
        
        for(int key : map.keySet()){
            int front = key - 1;
            int back = key + 1;
            int clothes = map.get(key);
            
            if(clothes >= 1){
                answer++;
                continue;
            }
            
            if(front > 0 && map.get(front) == 2) {
                answer++;
                continue;
            }
            
            if(back <= n && map.get(back) == 2){
                map.replace(back,map.get(back)-1);
                answer++;
                continue;
            }
        }
        
        return answer;
    }
}
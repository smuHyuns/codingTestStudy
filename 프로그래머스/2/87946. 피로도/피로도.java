import java.util.*;

class Solution {
    int answer = 0;
    
    public int solution(int fatigue, int[][] dungeons) {
        dfs(fatigue, dungeons, new boolean[dungeons.length], 0);
        return answer;
    }
    
    public void dfs(int fatigue, int[][] dungeons, boolean[] visited, int cur){
        int count = cur;
        int N = dungeons.length;
        
        for(int i=0; i<N; i++){
            if(!visited[i] && fatigue >= dungeons[i][0]){
                visited[i] = true;
                dfs(fatigue - dungeons[i][1], dungeons, visited, cur+1);
                visited[i] = false;
            }
        }
        
        answer = Math.max(answer,count);
    }
}
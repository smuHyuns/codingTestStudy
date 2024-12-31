import java.util.*;

class Solution {
    
    int N;
    int MAX = Integer.MAX_VALUE;
    int[][] map;
    public int solution(int n, int s, int a, int b, int[][] fares) {        
        //인접행렬을 사용하자
        N = n;
        map = new int[n][n];
                                 
        //초기화
        for(int i=0; i<n; i++){
            Arrays.fill(map[i], MAX);
            map[i][i] = 0;
        }
                
        for(int[] f : fares){
            int u = f[0]-1;
            int v = f[1]-1;
            int w = f[2];
            map[u][v] = w;
            map[v][u] = w;
        }
        
        int[] together = dijkstra(s-1);
        int minCost = MAX;
        for(int i=0; i<n; i++){
            //일정 시작점으로부터 혼자 간 부분을 구하고
            //값이 가장 낮은 지점을 기록하고 return 해주면 된다.
            int[] alone = dijkstra(i);//i가 출발지
            int totalCost = together[i] + alone[a-1] + alone[b-1];
            minCost = Math.min(totalCost, minCost);
        }
        
        return minCost;
    }
    
    public int[] dijkstra(int start){
        Queue<int[]> q = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        boolean[] visited = new boolean[N];
        int[] distance = new int[N];
        Arrays.fill(distance, MAX);
        distance[start] = 0;
        q.offer(new int[] {start,0});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curIdx = cur[0];
            int curDist = cur[1];
            
            if(visited[curIdx]) continue;
            visited[curIdx] = true;
            
            for(int i=0; i<N; i++){
                if(map[curIdx][i] == MAX || visited[i]) continue;
                int nextDist =  curDist + map[curIdx][i];
                if(distance[i] > nextDist){
                    distance[i] = nextDist;
                    q.offer(new int[] {i,nextDist});
                }
            }
        }
        
        return distance;
    }
}
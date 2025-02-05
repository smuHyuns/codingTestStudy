import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int N = maps[0].length;
        int M = maps.length;
        //방문기록
        boolean[][] visited = new boolean[M][N];
       // 1 은 이동가능 0은 이동불가능
        // 거리기록
        int[][] distance = new int[M][N];
        
        // bfs 위한 덱
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        visited[0][0] = true;
        distance[0][0] = 1;
        
        //상화좌우 이동
        int[] xrr = {-1,1,0,0};
        int[] yrr = {0,0,-1,1}; 
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            
            for(int i=0; i<4; i++){
                int nextX = curX + xrr[i];
                int nextY = curY + yrr[i];
                if(isValid(visited, maps, N, M, nextX, nextY)){
                    // 방문처리 - 거리갱신 - 큐에넣기
                    visited[nextY][nextX] = true;
                    distance[nextY][nextX] = distance[curY][curX] + 1;
                    q.offer(new int[] {nextX, nextY});
                }
            }
        }
        
        int answer = distance[M-1][N-1];
        
        if(answer == 0) return -1;
        return answer;
    }
    
    public static boolean isValid(boolean[][] visited, int[][] maps, int N, int M, int x, int y){
        // 범위검사 - 벽 - 방문 - 순서
        return x < N && x >=0 && y<M && y >=0 && maps[y][x] == 1 && !visited[y][x];
    }
}
class Solution {
    
    boolean[] visited;
    int [][] graph;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n]; //방문여부
        graph = new int[n][n]; //관계연결
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(computers[i][j] == 1){
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
            }
        }
        
        int answer = 0;
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                answer++;
                dfs(i);
            }
        }
        
        
        return answer;
    }
    
    public void dfs(int start){
        int n = graph.length;
        if(!visited[start]){
            visited[start] = true;
        }
        
        for(int i=0; i<n; i++){
            if(graph[start][i] ==1 && !visited[i])
                dfs(i);
        }
    }
}
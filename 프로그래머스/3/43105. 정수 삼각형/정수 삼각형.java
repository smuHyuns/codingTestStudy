import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        // 거쳐간 숫자의 합이 가장 큰 경우
        // 아래칸으로 이동할때 오른쪽 또는 왼쪽으로만 이동 가능
        
        // dp로 푸는거니까
        
        // 좌표별 선입선출이기 때문에 Queue 를 사용하는게 맞는거같고
        // 자기값 / 자기값 + 1 까지 탐색이 가능하다 = 라고보는게 맞고
        // 그랬을때 거쳐간 숫자의 최대값을 리턴이라고 하는데.
        // 그러면 이건 배열이 아닌거같은데? 
        
        // dp로 [][] 두개해서 층별/index 를 해서 최대값만 넣어놓는거야
        // 값을 꺼냈을때 예를들어 3층의 2번째(1번째) 를 만났을때 얘이전값은 index-1 일거아니야 그치?
        // 자기하고, 자기-1인값에서 확인이 가능하지 그래서 그값과 비교해서 최대인값을 이제 해당 배열에 저장을해
        // 그다음에 마지막에 마지막 층만 돌면서 값을 탐색하면 dp 구현 끝
        
        int height = triangle.length;
        int[][] dp = new int[height][height];
        
        for(int h=0; h<height; h++){
            for(int v=0; v<triangle[h].length; v++){
                int before = v-1;
                int current = v;
                
                if(h ==0){
                    dp[h][v] = triangle[h][v];
                    continue;
                }
                
                if(isValid(before)){
                    dp[h][v] = Math.max(dp[h][v], dp[h-1][before] + triangle[h][v] );
                }
                dp[h][v] = Math.max(dp[h][v], dp[h-1][current] + triangle[h][v]);
            }
        }        
        
        // 정답찾기
        int answer = 0;
        for(int i=0; i<height; i++){
            answer = Math.max(answer, dp[height-1][i]);    
        }
        
        return answer;
    }
    
    public boolean isValid(int N){
        return 0<=N;
    }
}
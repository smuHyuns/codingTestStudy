import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
                
        // 우선 완전탐색 문제이므로 DFS를 사용해야함
        //순열 + dfs?
        //가능한 조합의 배치 ( 최대 2의 50제곱 = 1024*1024 = 시간복잡도 널널)
        
        List<List<Boolean>> isPlus = new ArrayList<>();
        makeList(0, numbers.length, new boolean[numbers.length], isPlus);

        for(List<Boolean> plus : isPlus){
            int sum = 0;
            for(int i=0; i<plus.size(); i++){
                if(plus.get(i)) sum += numbers[i];
                else sum -= numbers[i];
            }
            if(sum == target){
                answer++;
            }
        }
        
        return answer;
    }
    
    public void makeList(int start, int N, boolean[] visited, List<List<Boolean>> list) {
        if (start == N) {
            // boolean 배열을 Boolean 리스트로 변환 후 추가
            List<Boolean> visitedList = new ArrayList<>();
            for (boolean b : visited) {
                visitedList.add(b);
            }
            list.add(visitedList);
            return;
        }

        visited[start] = true;
        makeList(start + 1, N, visited, list);
        visited[start] = false; 
        makeList(start + 1, N, visited, list);
    }
    
}
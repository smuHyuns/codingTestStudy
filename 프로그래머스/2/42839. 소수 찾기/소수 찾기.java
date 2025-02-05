import java.util.*;

class Solution {
    public static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        // 차수 별로 더해버리자
        // 일단 string을 int 배열로 변환
        int N = numbers.length();
        int[] num = new int[N];
        for(int i=0; i<N; i++){
            num[i] = numbers.charAt(i) - '0';
        }
        
        search(num, N, 0, 0, new boolean[N]);
        
        int answer =0;
        
        for(int s : set){
            System.out.println(s);
            if(isPrime(s)) answer++;
        }
        
        return answer;
    }
    
    public static void search(int[] num, int MAX, int current, int diget, boolean[] visited){
        if(diget == MAX) return;
        
        for(int i=0; i<MAX; i++){
            if(!visited[i]){
                int next = current + num[i] * (int)Math.pow(10, diget);
                set.add(next);
                visited[i] = true;
                search(num, MAX, next, diget+1, visited);
                visited[i] = false;
            }
        }
    }
    
    
    public static boolean isPrime(int num){
        if(num <= 1) return false; 
        for(int i=2; i<num; i++){
            if(num%i == 0) return false;
        }
        return true;
    }
}
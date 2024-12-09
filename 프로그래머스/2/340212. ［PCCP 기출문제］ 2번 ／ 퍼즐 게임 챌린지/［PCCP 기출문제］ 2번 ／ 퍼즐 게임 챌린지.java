import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {            
        int left = 1;  // 최소 레벨
        int right = 100000;  // 최대 레벨
        int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;  // 중간 레벨
            int[] tries = findTry(diffs, times, mid);
            long time = findSol(times, tries);
            
            if (time <= limit) {
                answer = mid;  // 조건을 만족하면 정답 후보 갱신
                right = mid - 1;  // 더 낮은 레벨 탐색
            } else {
                left = mid + 1;  // 더 높은 레벨 탐색
            }
        }
        
        return answer;
    }
    
    public static long findSol(int[] times, int[] tries){
        int len = times.length;
        long time = 0;
        for (int i = 0; i < len; i++) {
            time += (long) times[i] * tries[i];  
        }
        return time;
    }
    
    public static int[] findTry(int[] diffs, int[] times, int level) {
        int len = diffs.length;
        int[] tries = new int[len];
        
        for (int i = 0; i < len; i++) {
            int diff = diffs[i];
            if (diff <= level) {
                tries[i] = 1;
            } else {
                tries[i] = diff - level + 1;
                if (i > 0) {  // i-1에 접근하기 전에 검사
                    tries[i - 1] += diff - level;
                }
            }
        }
        
        return tries;
    }
}

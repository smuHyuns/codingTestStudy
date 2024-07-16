import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        //target이 우선 words 안에 존재하는지 확인한다.
        int targetIdx = -1;
        for (int i = 0; i <words.length; i++) {
            if (words[i].equals(target)) targetIdx = i;
        }

        //words에 없는경우 = targetIdx == -1 이므로 return 0
        if (targetIdx == -1) return 0;

        //최소 변환 과정을 찾으므로 bfs를 사용
        return bfs(begin, target, words);
    }

    public int bfs(String start, String target, String[] words) {
        Set<String> visited = new HashSet<>();
        Deque<String> q = new ArrayDeque<>();
        
        q.offer(start);
        visited.add(start);
        
        int count = 0;
        
        while (!q.isEmpty()) {
            //큐의 사이즈 확인
            int size = q.size();
            count ++;
            
            for(int i=0; i<size; i++){
                String top = q.poll();
                for(String word : words){
                    if(!visited.contains(word) && checkWords(top,word)){
                        if(word.equals(target)) return count;
                        q.offer(word);
                        visited.add(word);
                    }
                }
            }
        }
        
        return 0;

    }

    public boolean checkWords(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                count++;
        }

        return count == 1;
    }

}
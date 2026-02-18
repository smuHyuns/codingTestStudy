import java.util.*;

class Solution {
    public int solution(String s) {
        if (s.length() % 2 == 1) return 0;

        Queue<Character> q = new ArrayDeque<>();
        for (char c : s.toCharArray()) q.offer(c);

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            q.offer(q.poll()); // 앞에서 하나 빼서 뒤에 붙임
            if (isCorrect(q)) count++;
        }

        return count;
    }

    public boolean isCorrect(Queue<Character> q) {
        Stack<Character> stack = new Stack<>();
        
        // q를 순회하되 원본 유지
        List<Character> list = new ArrayList<>(q);
        
        for (char c : list) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
            }
        }
        
        return stack.isEmpty();
    }
}
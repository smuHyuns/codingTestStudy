import java.util.*;

class Solution {
    public static char[] list = {'[', ']', '{', '}', '(', ')'};
    
    public int solution(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++){
            char front = s.charAt(0);
            s = s.substring(1,s.length());
            s += front;
            if(checkS(s)) count++;   
        }

        return count;
    }

    public static boolean checkS(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == list[0] || s.charAt(i) == list[2] || s.charAt(i) == list[4])
                stack.push(s.charAt(i));
            else{
                if(stack.isEmpty())
                    return false;
                
                char temp = stack.peek();
                  if((temp == list[0] && s.charAt(i) == list[1])
                  ||(temp == list[2] &&s.charAt(i) == list[3])
                  ||(temp == list[4] && s.charAt(i) == list[5])
                 ) stack.pop();
            }
        }
        
        return stack.isEmpty();
    }

}



/*
stack을 사용하는문제
이 문제에서 말하는 회전이란 맨앞의 원소가 뒤로 추가해주는것 ( 이걸보면 구조는 queue 인듯? )
stack을 통해 검증하고 queue를통해 회전시키는 구조로 접근해보자
올바른 괄호 문자열을 만들 수 없으면, 0을 return해야한다. (s만큼 회전시켯는데 안될시)
*/
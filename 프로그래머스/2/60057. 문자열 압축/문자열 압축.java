import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 1000;

        // 문자열을 1개 이상의 단위로 잘라서 압축하여 더 짧은 문자열로 표현할 수 있는지 방법
        //for문을 통해 잘라보기
        
        //길이가 1이라면, 1을 리턴한다
        if(s.length() == 1) return 1;
        
        //길이가 2일때부터 1단위로 자를수가 있음
        for(int i=1; i<= s.length()/2; i++){ // 끊는단위
            StringBuilder sb = new StringBuilder();
            String front = s.substring(0,i);
            int cnt = 1;
            
            for(int j=i; j<s.length(); j+=i){ //순회
                String back;
                if(j+i <= s.length()) back = s.substring(j,i+j);
                else back = s.substring(j);
                
                //단위로 끊은 단어가 앞부분과 동일할 경우
                if(front.equals(back)) cnt++;
                //단위로 끊은 단어가 동일하지 않을경우
                else{
                    if(cnt == 1){ //한번도 일치한적 없는 경우
                        sb.append(front);
                        front = back;
                    } else{ // 한번이라도 일치한 경우(최소2)
                        sb.append(cnt);
                        sb.append(front);
                        front = back;
                        cnt = 1;
                    }
                }
                
            }
            
             if(cnt == 1){ //1인경우는 중복되는 부분이 없었다는 뜻, 그러므로 그대로 더해준다
                sb.append(front);
             } else{ //1이 아닌경우는 앞선 front와 중복되어있었다는 뜻, 그러므로 cnt + front를 더해준다
                sb.append(cnt);
                sb.append(front);
             }
            
            answer = Math.min(answer,sb.length());
        }
        
        return answer;
    }
}
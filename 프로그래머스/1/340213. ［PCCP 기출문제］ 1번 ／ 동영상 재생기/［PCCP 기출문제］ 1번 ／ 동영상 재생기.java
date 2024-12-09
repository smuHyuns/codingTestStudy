import java.util.*;

/*
10초 전으로 이동 - prev
10초 후로 이동 - next
오프닝 건너뛰기 - 현재 재생위치 op_start <= 현재 <= op_end
*/

class Solution {
    //video_Len = 전체길이, pos = 현재위치, op_start = 오프닝 시작, op_end = 오프닝 엔드, commands 명령어
    public String solution(String video_lenC, String posC, String op_startC, String op_endC, String[] commands) {
        
        // 전체 길이, 현재 위치, 오프닝 시작, 오프닝 엔드를 초로 변환하는 과정 필요 -> minToSecond
        // 변환 시작
        int video_len = minToSecond(video_lenC);
        int pos = minToSecond(posC);
        int op_start= minToSecond(op_startC);
        int op_end = minToSecond(op_endC);

        //현재 위치가 오프닝 시작과 엔드 사이일경우 엔드로 값 전환
        if (pos >= op_start && pos <= op_end) pos = op_end;
        
        for(String command : commands){           
            if(command.equals("prev")){
                if(pos-10 <0) pos = 0;
                else pos -= 10;
            }
            else{
                if(pos+10 > video_len) pos = video_len;
                else pos += 10;
            }
            
            if (pos >= op_start && pos <= op_end) pos = op_end;
        }
        

        
        //동영상 형식 변환
        String answer = intToString(pos);
        return answer;
    }
    
    public static int minToSecond(String input){
        String[] str = input.split(":");
        int second = Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
        return second;
    }
    
    public static String intToString(int pos){
        StringBuilder sb = new StringBuilder();
        int hour = pos / 60;
        int min = pos % 60;
        
        if(hour<10) sb.append(0);
        sb.append(hour).append(':');
        if(min <10) sb.append(0);
        sb.append(min);
        return sb.toString();
    }
}


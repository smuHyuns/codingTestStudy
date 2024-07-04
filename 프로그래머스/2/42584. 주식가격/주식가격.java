import java.util.*;

        /*
        1. stack에 index를 보관함
        <스택상황> : x / for : 0
        <스택상황> : 0 / for : 1 // price[stack.peek] = 1, price[1]  = 2  , 상단가격이 현재가격보다 작으므로, 1도 푸시
        <스택상황> : 0 1 / for : 2 // price[stack.peek] = 2, price[2]  = 3 ,  상단가격이 현재가격보다 작으므로, 2도 푸시
        <스택상황> : 0 1 2/ for : 3 // price[stack.peek] = 3 , price[3]  = 2 ,  상단가격이 현재가격보다 크므로(값이 떨어짐), 2를꺼내고 3-2한값 저장, 3을푸시
        <스택상황> : 0 1 3 / for : 4 : // price[stack.peek] = 3 , price[4]  = 3 ,  상단가격이 현재가격과 동일하므로, 4도 푸시
        
        2. 최종 스택상황
        <스택상황> : 0 1 3 4
        
        3. 스택 인덱스 정리
        스택값들을 계속 꺼냄 // 길이 -1 (배열의크기) 에서, 본인의 배열 위치만 빼주면 됨(왜냐면 들어온 이후로 값이 변동되지 않았기 때문)
        answer[꺼낸값] = 5 - 1 - 4
        answer[꺼낸값] = 5 - 1 - 3 
        answer[꺼낸값] = 5 - 1 - 1 
        answer[꺼낸값] = 5 - 1 - 0 

        */

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>(); 

        for(int i=0; i<prices.length; i++){
            while(!stack.isEmpty()&& prices[stack.peek()] > prices[i]){
                int top = stack.pop();
                answer[top] = i-top;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int top = stack.pop();
            answer[top] = prices.length - 1 - top;
        }
        
        return answer;
    }
}

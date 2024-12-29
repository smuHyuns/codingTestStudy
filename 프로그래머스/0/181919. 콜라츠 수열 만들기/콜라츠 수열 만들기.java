import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = getList(n);
        int size = list.size();
        int[] answer = new int[size];
        for(int i=0; i<size; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public List<Integer> getList(int n){
        List<Integer> list = new ArrayList<>();
        int num = n;
        list.add(num);
        while(num != 1){
            if(num%2 ==0){
                num/= 2;
            } else {
                num = num*3+1;
            }
            list.add(num);
        }
        return list;
    }
}
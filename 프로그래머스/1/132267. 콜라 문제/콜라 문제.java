class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        //a = 빈병
        //b = a개를 가져다 주면 주는 값
        //n = 빈병 n개를 가져다주면?
        
        answer = findBottle(a,b,n);
        return answer;
    }
    
    public int findBottle(int bottle, int returnBottle, int myBottle){
        if(myBottle < bottle) return 0;
        
        int a = myBottle / bottle * returnBottle;
        int b = myBottle % bottle;
        
        
        return  a + findBottle(bottle, returnBottle, a+b);
    }
}
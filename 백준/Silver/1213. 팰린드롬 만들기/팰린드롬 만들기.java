import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;


public class Main {
    public static void main(String[] args) throws IOException {
        //1.입력받기
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        //2.조건확인하기
        //2-1 팔린드롬을 만들 수 있는 조건
        //모든 개수가 다 짝수이거나, 홀수가 한개이거나 짝수의개수가 같아야 함
        TreeMap<Character, Integer> map = new TreeMap<>();
        for(int i=0; i<input.length(); i++){
            if(!map.containsKey(input.charAt(i)))
                        map.put(input.charAt(i),1);
            else{
                map.put(input.charAt(i), map.get(input.charAt(i)) +1 );
            }
        }

        //2-2 팔린드롬을 만들 수 없는 조건
        boolean flag = isFlag(map); // 팔린드롬으로 만들 수 있는지 확인
        if(flag == false)
            System.out.println("I'm Sorry Hansoo");
        else{
            //3. 팔린드롬만들기
            String sol = makePal(input, map);
            //4. 출력
            System.out.println(sol);
        }

    }

    private static String makePal(String input, TreeMap<Character, Integer> map) {
        StringBuilder sol = new StringBuilder(input);
        Integer length = input.length();
        Character mid = null;
        if(length %2 != 0){
            if (length == 1)
                return sol.toString();

            else{
                for ( Map.Entry<Character,Integer> Map : map.entrySet()){
                    if(Map.getValue() %2 != 0){
                        mid = Map.getKey();
                        sol.setCharAt(length/2, mid);
                    }
                }
            }
        }

        Integer i=0;
        for ( Map.Entry<Character,Integer> Map : map.entrySet()){
            Integer val = Map.getValue();
            Character v = Map.getKey();
            if(v == mid) val--;
            while(val>0){
                sol.setCharAt(i,v);
                sol.setCharAt(length-1-i,v);
                val -=2;
                i++;
            }
        }
        return sol.toString();
    }

    private static boolean isFlag(TreeMap<Character, Integer> map) {
        int odd = 0;
        for(Map.Entry<Character,Integer> Map : map.entrySet()){
            if(Map.getValue() %2 != 0) odd ++;
        }
        if(odd >= 2)
            return false;

        else
            return  true;
    }
}

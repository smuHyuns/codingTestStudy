import java.util.*;
import java.io.FileInputStream;
 
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            List<String> list = new ArrayList<>();
            list.add("");
            int N = sc.nextInt(); // 암호문길이
            for(int i=0; i<N; i++){
                String input = sc.next();
                list.add(input);
            }
            int O = sc.nextInt(); // 명령 개수
            for(int i=0; i< O; i++){
                String order = sc.next();                 
                if(order.equals("D")){ // start 뒤의 num만큼 제거
                    int start = sc.nextInt();
               		int num = sc.nextInt();
                    for(int j=0; j<num; j++){
                        list.remove(start+1);
                    }
                } 
                 
                else if(order.equals("I")){ // 
                    int start = sc.nextInt();
               		int num = sc.nextInt();
                    for(int j=1; j<=num; j++){
                        String addString = sc.next();
                        list.add(start+j, addString);
                    }
                }
                
               else if(order.equals("A")){ // 
               		int num = sc.nextInt();
                    for(int j=1; j<=num; j++){
                        String addString = sc.next();
                        list.add(addString);
                    }
                }
            }
             
            sb.append("#").append(test_case);
            for(int j=0; j<= 10; j++){
                String next = list.get(j);
                sb.append(next).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
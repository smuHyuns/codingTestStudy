import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            List<String> list = new ArrayList<>();
            list.add(""); //1부터 계산하기 위함
            int N = sc.nextInt();
			//원본 암호문 입력
            for(int i=0; i<N; i++){
            	String input = sc.next();
                list.add(input);
            }
			int O = sc.nextInt();
            for(int j=0; j<O; j++){
            	String line = sc.next();
                int start = sc.nextInt();
                int fetch = sc.nextInt();
                for(int k=1; k<=fetch; k++){
                    String input = sc.next();
                	list.add(start+k, input);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case).append(" ");
            for(int i=1; i<=10; i++){
                String val = list.get(i);
                sb.append(val).append(" ");
            }
            System.out.println(sb);
		}
	}
}
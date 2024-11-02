import java.util.Scanner;
class Solution
{
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int T=sc.nextInt();
            int base = sc.nextInt();
            int digit = sc.nextInt();
            System.out.println("#"+T+" "+search(base,digit));
		}
	}
     public static int search(int base,int digit){
    	if(digit ==1){
            return base;
        }
        return base * search(base,digit-1);
    }
}

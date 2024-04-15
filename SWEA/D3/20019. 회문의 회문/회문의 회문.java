import java.io.BufferedReader;
import java.io.InputStreamReader;
class Solution
{
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        for(int i=0; i<N; i++){
            String input = bf.readLine();
            if(isPal(input) && isPal(input.substring(0,input.length()/2)) && isPal(input.substring(input.length()/2+1))){
                System.out.println("#"+ (i+1) + " YES");
            }
            else System.out.println("#"+ (i+1) + " NO");
        }

    }

    public static Boolean isPal(String input){
        Boolean flag = true;
        for(int i=0; i<input.length()/2; i++){
            if(input.charAt(i) != input.charAt(input.length()-1-i)){
                flag = false;
            }
        }
        return flag;
    }

}
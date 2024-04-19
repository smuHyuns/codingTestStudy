import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        /*입력*/
        int TC = Integer.parseInt(bf.readLine());

        for(int a =1; a<=TC; a++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            String Pal[] = new String[N];
            String notPal[] = new String[N];
            int p = 0;
            int np = 0;

            /*
             * 입력후 저장, 팔린드롬인 것과 아닌것으로 나눴음.
             * */
            for(int i=0; i<N; i++){
                String input = bf.readLine();
                if(!isPal(input)){
                    notPal[np] = input;
                    np++;
                }
                else{
                    Pal[p] = input;
                    p++;
                }
            }

            /*
             * 1. boolean used를 사용하여 사용여부를 판단한다.
             * 2. checkPal로 비교후 같을시 추가
             * 3. 마지막으로 p가 0보다 크고 M과 같거나 작을시 count에 M을 더해준다.
             * */

            int count = 0;



            boolean visited[] = new boolean[100];
            for(int i=0; i<np-1; i++){
                for(int j=i+1; j<np; j++){
                    if(checkPal(notPal[i],notPal[j]) && !visited[i] && !visited[j]){
                        visited[i] = true;
                        visited[j] = true;
                        count += 2*M;
                    }
                }
            }

            visited = new boolean[100];
            boolean flag = true;
            for(int i=0; i<p-1; i++){
                for(int j=i+1; j<p; j++){
                    if(Pal[i] == Pal[j] && !visited[i] && !visited[j]){
                        bw.write("진입\n");
                        visited[i] = true;
                        visited[j] = true;
                        count += 2*M;
                        flag = false;
                    }
                }
            }
            //깡으로 M을 더해야 하는 경우
            //flag가 true인상태로 유지되고 팔린드롬이 한개라도 존재해야함
            if(flag && p!=0)
                count+= M;

            bw.write("#" + a + " "+ count + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static boolean isPal(String input){
        int mid = input.length()/2;
        for(int i=0; i<mid; i++){
            if(input.charAt(i) != input.charAt(input.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static boolean checkPal(String input, String input2){
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i) != input2.charAt(input.length()-1-i)){
                return false;
            }
        }
        return true;
    }

}


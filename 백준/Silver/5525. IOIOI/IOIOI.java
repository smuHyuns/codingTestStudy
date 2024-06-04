import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int cnt = 0;

        String div = "I";
        //비교값 생성
        for(int i=0; i<N; i++){
            div += "OI";
        }

        // div.length 만큼 짤라서 개수 세기
        for(int i=0; i<M-div.length()+1; i++){
            String target = input.substring(i, i+div.length());
            if(target.equals(div)) cnt++;
        }

        System.out.println(cnt);
    }
}
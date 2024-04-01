import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String S = bf.readLine();
        System.out.println(cal(S));
    }

    // 자바의 substring을 통해 문자들을 잘라가며 isPal()을 통해
    // 그 문자들이 팔린드롬인지 확인합니다.
    // cal의 반복문을 통과할시에는 전체단어가 통으로 더 필요한 경우로, *2를 실시해 줍니다.

    static boolean isPal(String S){
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) != S.charAt(S.length()-i-1))
                return false;
        }

        return true;
    }

    static int cal(String S){
        int L = S.length();
        for(int i=0; i<S.length(); i++){
            if(isPal(S.substring(i)))
                return L+i;
        }

        return L*2;
    }

}

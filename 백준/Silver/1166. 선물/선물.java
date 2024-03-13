
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {

        //입력받기
        int num, low, width, height;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        num = Integer.parseInt(st.nextToken());
        low = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        //최대공약수를 찾자. 이진탐색 사용
        double left = 0;
        double right = Math.min(low, Math.min(width, height));
        double mid;

        while (left < right) {
            mid = (left + right) / 2;

            if ((long)(low / mid) * (long)(width / mid) * (long)(height / mid) < num) {
                if (right == mid) break;
                right = mid;
            } else {
                if (left == mid) break;
                left = mid;
            }

        }

        System.out.println(left);




    }
}



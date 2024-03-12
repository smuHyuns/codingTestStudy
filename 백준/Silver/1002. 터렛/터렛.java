import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        //1. 입력받기
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        StringTokenizer st;

        for(int i=0; i<T; i++){
            st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            //2. 거리계산하기
            //3. 출력하기
            System.out.println(getSolution(x1, y1, r1, x2, y2, r2));

        }

    }

    private static int getSolution(int x1, int y1, int r1, int x2, int y2, int r2) {
        int sol = 0;
        int distance = (int)(square(x1,x2) + square(y1,y2));

        //1. 중점이 같으면서 반지름도 같은경우
        if(x1 == x2 && y1 ==y2  && r1 == r2)
            sol = -1;

        //2. 두 원의 반지름 합보다 중점간 거리가 더 길 때
        else if(distance > Math.pow(r1 + r2,2))
            sol = 0;

        //3. 원 안에 원이 있으나 내접하지 않을 때
        else if(distance < Math.pow(r2-r1,2)){
            sol = 0;
        }

        //4. 내접할 때
        else if(distance == Math.pow(r2 - r1, 2)) {
            sol = 1;
        }

        //5. 외접할 때
        else if(distance == Math.pow(r1 + r2, 2)) {
            sol = 1;
        }

        //6.이외
        else {
            sol = 2;
        }

        return sol;
    }

    private static int square(int x1, int x2) {
        return (x1-x2)*(x1-x2);
    }

}
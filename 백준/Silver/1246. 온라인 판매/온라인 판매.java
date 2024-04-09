import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*입력구간*/
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int egg = Integer.parseInt(st.nextToken());
        int customer = Integer.parseInt(st.nextToken());
        int arr[] = new int[customer];
        for(int i=0; i < customer; i++){
            arr[i] = Integer.parseInt(bf.readLine());
        }
        /*
        * 경래는 영양란이라 속인 죄책감에 한 고객에게 두 개 이상의 달걀은 팔지 않기로 하였다. ( = 한고객당 1개의 달걀 )
        * 하지만 위의 규칙 하에 수익은 최대로 올리고 싶기에 얼마로 팔지 고민하고 있다.
        * 즉, A가격에 달걀을 판다고 하면 Pi가 A가격보다 크거나 같은 모든 고객은 달걀을 산다는 뜻이다. (arr[i] >= A 이면 달걀구매)
        * (물론 달걀 총 수량을 초과하여 팔 수 는 없다)
        * 문제는 이러한 경래를 도와 최대 수익을 올릴 수 있는 달걀의 가장 낮은 가격을 책정하는 것이다.
        * */

        Arrays.sort(arr);
        int index = customer-1;
        int count = 0;
        int one = 0;
        int max = 0;
        while(true){
            if(index < 0){break;}

            int now = 0;
            int end = customer;


            for(int i = index; i<customer; i++){
                now += arr[index];
            }

            if(customer - index >= egg)
                now = arr[index] * egg;

            if(now >= max){
                one = arr[index];
                max = now;
                count++;
            }
            index--;
        }
        System.out.printf(one + " " + max);


    }

}

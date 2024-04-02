import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] arr;
    static int P;
    static int Max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        P = Integer.parseInt(bf.readLine());
        arr = new int[P][P];

        for(int i=0; i<P; i++){
            for(int j=0; j<P; j++)
                arr[i][j] = 0;
        }


        /*1.입력받기*/
        for(int i=0; i<P; i++){
            String read = bf.readLine();
            for(int j=0; j<P; j++){
                if(read.charAt(j) == 'Y'){
                    arr[i][j] = 1; arr[j][i] = 1;
                }
            }
        }
        /*2.탐색*/
        for (int i=0; i<P; i++)
            search(0,i,0);

        System.out.println(Max);

    }

    /*
     * 어떤 사람 A가 또다른 사람 B의 2-친구가 되기 위해선, 두 사람이 친구이거나, A와 친구이고, B와 친구인 C가 존재해야 된다.
     * */
    private static void search(int sum, int start, int index) {
        //System.out.println("now : "+ sum + " " + start + " " + index );
        if(index<P){
            if(arr[start][index] == 1 || findBoth(start,index)){
                search(sum+1, start, index+1);
            }
            else{
                search(sum, start, index+1);
            }
        }

        else if(index == P){
            Max = Math.max(Max,sum);
        }
    }

    private static boolean findBoth(int A, int B) {
        for (int i = 0; i < P; i++) {
            if (arr[A][i] == 1 && i != A && i != B && A!=B) {
                if (arr[A][i] == arr[B][i]) {
                    return true;
                }
            }
        }
        return false;
    }

}

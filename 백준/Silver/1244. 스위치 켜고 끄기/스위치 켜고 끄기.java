import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] switches = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            switches[i] = sc.nextInt();
        }

        int S = sc.nextInt();

        for (int i = 0; i < S; i++) {
            int gender = sc.nextInt();
            int status = sc.nextInt();
            if (gender == 1) {
                boySwitch(switches, status);
            } else {
                girlSwitch(switches, status);
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(switches[i] + " ");
            if (i % 20 == 0) System.out.println();
        }
    }

    public static void boySwitch(int[] switches, int idx) {
        for (int i = idx; i < switches.length; i += idx) {
            switches[i] = (switches[i] == 1) ? 0 : 1;
        }
    }

    public static void girlSwitch(int[] switches, int idx) {
        int len = switches.length;
        switches[idx] = (switches[idx] == 1) ? 0 : 1;
        for (int i = 1; i < len; i++) {
            int left = idx - i;
            int right = idx + i;
            boolean valid = isValid(len, left) && isValid(len, right);
            if (!valid) {
                return;
            }
            if (switches[left] == switches[right]) {
                int change = switches[left] == 1 ? 0 : 1;
                switches[left] = change;
                switches[right] = change;
            } else {
                return;
            }
        }
    }

    public static boolean isValid(int len, int idx) {
        return idx >= 1 && idx <= len - 1;
    }
}

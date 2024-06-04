import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String input = br.readLine();

        // 패턴 생성
        StringBuilder patternBuilder = new StringBuilder("I");
        for (int i = 0; i < N; i++) {
            patternBuilder.append("OI");
        }
        String pattern = patternBuilder.toString();

        // KMP 알고리즘을 사용하여 패턴 찾기
        int[] lps = computeLPSArray(pattern);
        int count = KMPSearch(input, pattern, lps);

        System.out.println(count);
    }

    // LPS 배열을 계산하는 함수
    public static int[] computeLPSArray(String pattern) {
        int M = pattern.length();
        int[] lps = new int[M];
        int length = 0;
        int i = 1;

        lps[0] = 0;

        while (i < M) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    // KMP 알고리즘으로 패턴을 찾는 함수
    public static int KMPSearch(String text, String pattern, int[] lps) {
        int N = text.length();
        int M = pattern.length();
        int i = 0;
        int j = 0;
        int count = 0;

        while (i < N) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == M) {
                count++;
                j = lps[j - 1];
            } else if (i < N && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return count;
    }
}

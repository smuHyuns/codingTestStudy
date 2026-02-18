import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int sLen = 1; sLen <= s.length() / 2; sLen++) {
            int compressed = compress(s, sLen).length();
            answer = Math.min(answer, compressed);
        }

        return answer;
    }

    private String compress(String s, int sLen) {
        StringBuilder sb = new StringBuilder();
        String slice = s.substring(0, sLen);
        int count = 1;

        for (int i = sLen; i < s.length(); i += sLen) {
            String chunk = s.substring(i, Math.min(i + sLen, s.length()));

            if (chunk.equals(slice)) {
                count++;
            } else {
                if (count > 1) sb.append(count);
                sb.append(slice);
                slice = chunk;
                count = 1;
            }
        }

        // 마지막 조각 처리
        if (count > 1) sb.append(count);
        sb.append(slice);

        return sb.toString();
    }
}
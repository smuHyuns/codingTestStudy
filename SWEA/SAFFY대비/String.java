import java.util.Scanner;

class String_1216 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10; i++) {
            int N = sc.nextInt();
            String target = sc.next();
            String word = sc.next();

            int sum = 0;
            int len = target.length();

            for (int j = 0; j <= word.length() - len; j++) {
                if (word.substring(j, j + len).equals(target)) sum++;
            }

            System.out.print("#" + i + " " + sum + "\n");
            //sb.append("#" + i + " " + sum + "\n");
        }

        System.out.println(sb);
    }
}
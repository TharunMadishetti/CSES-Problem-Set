import java.io.*;

public class DiceComb {
    static long[] dp;
    static long mod = (long) Math.pow(10, 9) + 7;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        dp = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == 1)
                dp[i] = 1;
            else {
                long a = 0;
                for (int k = 1; i - k >= 0; k++)
                    a = (a % mod + dp[i - k] % mod) % mod;
                dp[i] = a % mod;
            }
        }
        System.out.println(dp[n]);
    }
}

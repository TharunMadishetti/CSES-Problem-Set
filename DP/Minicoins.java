import java.io.*;
import java.util.*;

public class Minicoins {
    static int[][] dp;
    static long mod = (long) Math.pow(10, 9) + 7;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int x = Integer.parseInt(st[1]);
        st = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st[i]);
        dp = new int[n][x + 1];
        for (int[] k : dp)
            Arrays.fill(k, -1);
        mini(a, n - 1, x);
        if (dp[n - 1][x] != Integer.MAX_VALUE)
            System.out.println(dp[n - 1][x]);
        else
            System.out.println(-1);
    }

    public static int mini(int[] arr, int i, int t) {
        if (t == 0)
            return 0;
        if (i < 0)
            return Integer.MAX_VALUE;
        if (dp[i][t] != -1)
            return dp[i][t];
        int take = Integer.MAX_VALUE, nontake = Integer.MAX_VALUE;
        if (t >= arr[i]) {
            take = mini(arr, i, t - arr[i]);
            if (take < Integer.MAX_VALUE)
                take += 1;
        }
        nontake = mini(arr, i - 1, t);
        System.out.println(i + " " + t + " " + take);
        dp[i][t] = Math.min(take, nontake);
        return dp[i][t];
    }
}

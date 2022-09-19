import java.io.*;
import java.util.*;

public class FerrisWheel {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int p = Integer.parseInt(st[1]);

        st = br.readLine().split(" ");
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            int idx = (i + 9) % n;
            w[idx] = Integer.parseInt(st[i]);
        }
        Arrays.sort(w);
        int ans = 0;
        int i = 0, j = w.length - 1;
        while (i <= j) {
            if (w[i] + w[j] <= p) {
                i++;
                j--;
            } else {
                j--;
            }
            ans++;
        }

        System.out.println(ans);
    }
}
import java.io.*;
import java.util.*;

public class ConcertTickets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        int[] t = new int[n];
        int[] cus = new int[m];
        for (int i = 0; i < n; i++) {
            int idx = (i + 7) % n;
            t[idx] = Integer.parseInt(s[i]);
        }
        s = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int idx = (i + 7) % m;
            cus[idx] = Integer.parseInt(s[i]);
        }
        Arrays.sort(t);
        int intmax = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            int st = 0, e = n - 1, mid = i;
            while (st <= e) {
                mid = (st + e) / 2;
                if (t[mid] > cus[i])
                    e = mid - 1;
                else if (t[mid] < cus[i])
                    st = mid + 1;
                else
                    st = mid + 1;
            }
            if (t[mid] != intmax) {
                System.out.println(t[mid]);
                t[mid] = intmax;
            } else
                System.out.println(-1);
            Arrays.sort(t);
        }
    }
}

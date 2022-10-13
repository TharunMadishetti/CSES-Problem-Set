import java.io.*;
import java.util.*;

public class ConcertTickets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        st = br.readLine().split(" ");
        int[] p = new int[n];
        int[] t2 = new int[m];
        int[] t = new int[m];
        for (int i = 0; i < n; i++) {
            int idx = (i + 9) % n;
            p[idx] = Integer.parseInt(st[i]);
        }
        st = br.readLine().split(" ");
        for (int i = 0; i < m; i++)
            t2[i] = t[i] = Integer.parseInt(st[i]);
        Arrays.sort(p);
        Arrays.sort(t2);
        HashMap<Integer, Integer> h = new HashMap<>();
        int i = n - 1, j = m - 1;
        while (i >= 0 && j >= 0 && p[i] > t2[j]) {
            i--;
            j--;
        }
        if (i < 0 || j < 0) {
            System.out.println(-1);
            return;
        }
        h.put(t2[j], p[i]);
        i--;
        j--;
        while (i >= 0 && j >= 0) {
            if (p[i] <= t2[j]) {
                h.put(t2[j], p[i]);
                i--;
                j--;
            } else
                i--;
        }
        for (i = 0; i < m; i++)
            System.out.println(h.containsKey(t[i]) ? h.get(t[i]) : -1);
    }
}
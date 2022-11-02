import java.io.*;
import java.util.*;

public class ConcertTickets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        TreeMap<Integer, Integer> t = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(s[i]);
            t.put(x, t.getOrDefault(x, 0) + 1);
        }
        s = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int k = Integer.parseInt(s[i]);
            if (t.floorKey(k) != null) {
                int ck = t.floorKey(k);
                System.out.println(ck);
                t.put(ck, t.get(ck) - 1);
                if (t.get(ck) == 0)
                    t.remove(ck);
            } else if (t.ceilingKey(k) != null && t.ceilingKey(k) == k) {
                System.out.println(k);
                t.put(k, t.get(k) - 1);
                if (t.get(k) == 0)
                    t.remove(k);
            } else
                System.out.println(-1);
        }

    }
}

import java.io.*;
import java.io.IOException;
import java.util.*;

class TwoSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int p = Integer.parseInt(s[1]);
        String st = br.readLine();
        s = st.split(" ");
        HashMap<Integer, String> h = new HashMap<>();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(s[i]);
            h.put(w[i], h.getOrDefault(w[i], "") + (i + 1) + " ");
        }
        Arrays.sort(w);
        int ans = 0;
        int i = 0, j = w.length - 1;
        while (i < j) {
            if (w[i] + w[j] < p)
                i++;
            else if (w[i] + w[j] > p)
                j--;
            else {
                break;
            }

        }
        if (w[i] + w[j] == p && i != j) {
            if (w[i] != w[j])
                System.out.println(h.get(w[i]) + " " + h.get(w[j]));
            else {
                s = h.get(w[i]).split(" ");
                System.out.println(s[0] + " " + s[1]);
            }
        } else
            System.out.println("IMPOSSIBLE");
    }
}
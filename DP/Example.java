import java.util.*;

public class Example {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1.minCost("abaac", new int[] { 1, 2, 3, 4, 5 }));
    }
}

class Solution {
    public int minCost(String c, int[] t) {
        if (t.length == 1)
            return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        pq.add(t[0]);
        int ans = t[0];
        for (int i = 1; i < t.length; i++) {
            System.out.println(i + "s " + pq + " " + ans);

            if (c.charAt(i - 1) == c.charAt(i)) {
                pq.add(t[i]);
            } else {
                ans -= pq.poll();
                System.out.println(i + " " + pq + " " + ans);
                pq.clear();
                pq.add(t[i]);
            }
            ans += t[i];

        }
        ans -= pq.poll();
        return ans;
    }
}

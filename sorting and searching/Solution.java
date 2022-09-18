import java.util.*;

class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    long[] a = new long[n];
    int c = 1;
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextLong();
    }
    Arrays.sort(a);
    long prev = a[0];
    for (int i = 0; i < n; i++) {
      if (prev != a[i])
        c++;
      prev = a[i];
    }

    System.out.println(c);
  }
}

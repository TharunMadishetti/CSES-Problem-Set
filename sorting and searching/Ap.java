import java.util.*;

public class Ap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        int[] ap = new int[m];
        for (int i = 0; i < n; i++) {
            int idx = (i + 9) % n;
            a[idx] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int idx = (i + 9) % n;
            ap[idx] = sc.nextInt();

        }
        int c = 0, j = m - 1;
        Arrays.sort(a);
        Arrays.sort(ap);
        for (int i = n - 1; i >= 0; i--) {
            if (j < 0)
                break;
            if (a[i] + k >= ap[j] && a[i] - k <= ap[j]) {
                // System.out.println(a[i]+" "+c+" "+ap[j]);
                j--;
                c++;
            }
            while (j >= 0 && i - 1 >= 0 && a[i - 1] + k < ap[j])
                j--;

        }
        System.out.println(c);
    }
}
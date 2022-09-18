import java.util.*;

public class Apartments {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        int[] ap = new int[m];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < m; i++)
            ap[i] = sc.nextInt();
        int c = 0, j = 0;
        Arrays.sort(a);
        // Arrays.sort(ap);
        for (int i = 0; i < n; i++) {
            if (j == ap.length)
                break;
            if (a[i] + k >= ap[j] && a[i] - k <= ap[j]) {
                j++;
                c++;
            }
            if (j<m &&  a[i]-k>ap[j])
                j++;
        }
        System.out.println(c);
    }
}

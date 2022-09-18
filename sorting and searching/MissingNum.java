import java.util.*;

public class MissingNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        int c = 0;
        for (int i = 0; i < n - 1; i++) {
            a[sc.nextInt()]++;
        }
        int i = 1;
        for (i = 1; i < n; i++) {
            if (a[i] != 1)
                break;
        }
        System.out.println(i);
    }

}

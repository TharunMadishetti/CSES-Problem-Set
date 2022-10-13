import java.util.Scanner;

class SegmentTreeNode {
    long val;

    SegmentTreeNode() {
    }

    SegmentTreeNode(int v) {
        val = v;
    }
}

class Segmentree {
    SegmentTreeNode[] sg;

    Segmentree(int n) {
        sg = new SegmentTreeNode[4 * n];
        for (int i = 0; i < 4 * n; i++)
            sg[i] = new SegmentTreeNode();
    }

    public void build(int[] a, int l, int r, int i) {
        if (l == r) {
            sg[i].val = a[l];
            return;
        }
        int mid = (l + r) / 2;
        build(a, l, mid, 2 * i + 1);
        build(a, mid + 1, r, 2 * i + 2);
        sg[i].val = sg[2 * i + 1].val + sg[2 * i + 2].val;
    }

    public void update(int[] a, int l, int r, int i) {
        if (l == r) {
            sg[i].val = a[l];
            return;
        }
        int mid = (l + r) / 2;

        update(a, l, mid, 2 * i + 1);
        update(a, mid + 1, r, 2 * i + 2);
        sg[i].val = sg[2 * i + 1].val + sg[2 * i + 2].val;
    }

    public long query(int l, int r, int low, int high, int i) {
        if (r < low || l > high) {
            return 0;
        }
        if (low >= l && high <= r)
            return sg[i].val;
        int mid = (low + high) / 2;

        return query(l, r, low, mid, 2 * i + 1) + query(l, r, mid + 1, high, 2 * i + 2);

    }
}

public class Sum {
    static int int_max = Integer.MAX_VALUE;
    static int int_min = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int q = s.nextInt();
        int i = 0;
        int a[] = new int[n];
        while (i < n)
            a[i++] = s.nextInt();
        Segmentree sg = new Segmentree(n);
        sg.build(a, 0, n - 1, 0);
        while (q > 0) {
            int l = s.nextInt();
            int r = s.nextInt();
            l--;
            r--;
            System.out.println(sg.query(l, r, 0, n - 1, 0));
            q--;
        }
        s.close();
    }
}
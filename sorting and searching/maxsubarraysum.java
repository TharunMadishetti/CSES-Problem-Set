import java.io.*;

class maxsubarraysum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        String st = br.readLine();
        s = st.split(" ");
        int nmx = 0;
        long cm = 0, mx = 0;
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(s[i]);
            cm += w[i];
            mx = Math.max(mx, cm);
            if (cm < 0)
                cm = 0;
            if (w[nmx] < w[i])
                nmx = i;
        }
        System.out.println(mx == 0 ? w[nmx] : mx);
    }
}
import java.io.IOException;

import java.io.*;

public class Weird {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder(n + " ");
        while (n != 1) {

            if (n % 2 == 0)
                n /= 2;
            else
                n = n * 3 + 1;
            sb.append(n + " ");
        }
        System.out.println(sb);
    }
}
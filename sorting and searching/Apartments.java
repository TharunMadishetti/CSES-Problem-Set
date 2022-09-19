import java.io.*;
import java.io.IOException;
import java.util.PriorityQueue;

public class Apartments {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
        int k = Integer.parseInt(st[2]);

        st = br.readLine().split(" ");
        PriorityQueue<Integer> req = new PriorityQueue<>(n);
        for (int i = 0; i < n; i++) {
            req.add(Integer.parseInt(st[i]));
        }
        st = br.readLine().split(" ");
        PriorityQueue<Integer> av = new PriorityQueue<>(m);
        for (int i = 0; i < m; i++) {
            av.add(Integer.parseInt(st[i]));
        }
        int c = 0;
        while (!req.isEmpty() && !av.isEmpty()) {
            while (!av.isEmpty() && av.peek() < req.peek() - k)
                av.poll();
            if (!av.isEmpty() && av.peek() <= req.peek() + k) {
                c++;
                av.poll();
            }
            req.poll();
        }
        System.out.println(c);
    }
}
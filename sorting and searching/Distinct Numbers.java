import java.util.*;
class Solution
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    HashSet<Long>  h = new HashSet<>();
    for(int i=0;i<n;i++)
      h.add(sc.nextLong());
    System.out.println(h.size());
  }
}

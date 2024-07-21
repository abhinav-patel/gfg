//{ Driver Code Starts
import java.util.*;

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) list.add(sc.nextInt());

            Solution obj = new Solution();
            long ans = obj.findMaxProduct(list);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    public long findMaxProduct(List<Integer> arr) 
    {
        int n=arr.size();
        if (n == 1) return arr.get(0);

        long ans = 1;
        long mod = (long) Math.pow(10, 9) + 7;
        int mx = Integer.MIN_VALUE;
        int c = 0;
        int z = 0;

        for (int i = 0; i < n; i++) {
            if (arr.get(i) < 0) {
                c++;
                mx = Math.max(mx, arr.get(i));
            }
            if (arr.get(i) != 0) {
                ans = (ans * arr.get(i)) % mod;
            } else {
                z++;
            }
        }

        if ((c == 1 && z == n - 1) || z == n) return 0;
        return c % 2 != 0 ? ans / mx : ans;
    }
}
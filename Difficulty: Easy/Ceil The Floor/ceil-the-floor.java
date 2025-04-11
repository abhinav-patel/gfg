//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            int[] ans = ob.getFloorAndCeil(x, arr);
            System.out.println(ans[0] + " " + ans[1]);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution 
{
    //Unsorted
    //Since For a single query (one x value), 
    //Simple For Loop is faster and more efficient (O(n) < O(n log n))
    //Sort + Binary Search only makes sense if you have multiple queries 
    //for different x values. Because then sorting once (O(n log n)) 
    //and doing binary search (O(log n)) for each query becomes overall efficient.
    
    public int[] getFloorAndCeil(int x, int[] arr) 
    {
        int ans[]=new int[2];
        ans[0]=-1;
        ans[1]=Integer.MAX_VALUE;
        int flag=0;
        
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<=x && arr[i]>ans[0])
               ans[0]=arr[i];
               
            if(arr[i]>=x && arr[i]<ans[1])
            {
                flag=1;
               ans[1]=arr[i];
            }
        }
        if(flag==0)
           ans[1]=-1;
        return ans;
    }
}

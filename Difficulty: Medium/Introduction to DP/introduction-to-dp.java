//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Solution obj = new Solution();
            long topDownans = obj.topDown(n);
            long bottomUpans = obj.bottomUp(n);
            if (topDownans != bottomUpans)
                System.out.println(-1);
            else
                System.out.println(topDownans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    static long topDown(int n) 
    {
        if(n==0)
            return 0;
        if(n==2||n==1)
           return 1;
        long memo[]=new long[n+1];
        Arrays.fill(memo,-1);
        memo[0]=0;
        memo[1]=1;
        memo[2]=1;
        return top(n,memo);
    }
    
    static long top(int n, long[] memo)
    {
        if(memo[n]!=-1)
            return memo[n];
        memo[n]=(top(n-1,memo)+top(n-2,memo))%1000000007;
        return memo[n];
    }

    static long bottomUp(int n) 
    {
        long a=1;
        long b=1;
        if(n==0)
            return 0;
        if(n==2||n==1)
           return b;
        long c=a+b;
        for(int i=3;i<=n;i++)
        {
            c=(a+b)%1000000007;            
            a=b;
            b=c;
        }
        return c;
        
    }
}

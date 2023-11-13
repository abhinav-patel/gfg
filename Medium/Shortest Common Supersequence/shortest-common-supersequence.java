//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		
		sc.nextLine();
		while(t-->0)
		{
		   //taking String X and Y
		   String S[]=sc.nextLine().split(" ");
		   String X=S[0];
		   String Y=S[1];
		   
		   //calling function shortestCommonSupersequence()
		   System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
		}
	}




       
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        int k=longestCommonSubsequence(X,Y);
        return (k+(m-k)+(n-k));
    }
    public static int longestCommonSubsequence(String t1, String t2) 
    {
        int[] memo = new int[t2.length() + 1];
        char[] t1c = t1.toCharArray(), t2c = t2.toCharArray();
        for (int i = t1c.length - 1; i > -1; i--) {
            int previousRigth = 0, newRight = 0;
            for (int j = t2c.length - 1; j > -1; j--) {
                int tmp = memo[j];
                int max;
                if (t1c[i] == t2c[j]) max = previousRigth + 1;
                else max = Math.max(tmp, newRight);
                memo[j] = newRight = max;
                previousRigth = tmp;
            }
        }
        return memo[0];
    }
}
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) 
    {
        Arrays.sort(arr);
        int k[]=new int[2];
        int c=0;
        for(int i=0;i<n;i++)
        {
            if(arr[i]!=i+1)
            {
                k[1]=i+1;
                for(int j=i;j<n-1;j++)
                {
                    if(arr[j]==arr[j+1])
                    {   
                        k[0]=arr[j];
                        break;
                        
                    }
                }
                if(k[1]==0)
                    k[1]=n;
                return k;
            }
            if(arr[i]==arr[i+1])
            {
                k[0]=arr[i];
                for(int j=i+2;j<n;j++)
                {
                    if(j!=arr[j])
                    {
                        k[1]=j;
                        break;
                    }
                }
                if(k[1]==0)
                    k[1]=n;
                return k;
            }
            
        }
        return k;
        
    }
}
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t;
		t = sc.nextInt();
		String s12 = sc.nextLine();
		for(int i=0; i<t; i++){
		    String s1 = sc.nextLine();
		    String s2 = sc.nextLine();
		    
		    Solution obj = new Solution();
		    
		    boolean flag = obj.isRotated(s1, s2);
		    
		    if(flag == true) System.out.println("1");
		    else System.out.println("0");
		    
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to check if a string can be obtained by rotating
    //another string by exactly 2 places.
    public static boolean isRotated(String a, String b)
    {
        if(a.length()!=b.length())
            return false;
            
         String clockWise = b.substring(b.length()-2,b.length())
                           + b.substring(0,b.length()-2);
       //anti clock wise
       String antiClockWise = b.substring(2,b.length())+b.substring(0,2);
       return a.equals(clockWise) || a.equals(antiClockWise);
    }
    
}
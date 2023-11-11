//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;


public class Driver {
    
    public static void main(String[] args)throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0)
        {
            String s1 = br.readLine();
            String s2 = br.readLine();
            
            Solution obj = new Solution();
            
            boolean a = obj.areIsomorphic(s1,s2);
            if(a)
            System.out.println(1);
            else
            System.out.println(0);
        }
    }
    
}

// } Driver Code Ends


class Solution
{
    //Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String s1,String s2)
    {
        if(s1.length()!=s2.length())
            return false;
        
        Map<Character,Integer> m1=new HashMap<>();
        Map<Character,Integer>m2=new HashMap<>();
        
        for(Integer i=0;i<s1.length();i++)
        {
            if(m1.put(s1.charAt(i),i)!=m2.put(s2.charAt(i),i))
                return false;
        }
        return true;
    }
}
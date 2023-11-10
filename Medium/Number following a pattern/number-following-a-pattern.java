//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.printMinNumberForPattern(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static String printMinNumberForPattern(String s)
    {
        String str="";
        Stack<Integer> st=new Stack<>();
        int num=1;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='D')
            {
                st.push(num);
                num++;
            }
            else
            {
                st.push(num);
                num++;
                while(!st.isEmpty())
                {
                    str=str+st.pop()+"";
                }
            }
        }
        st.push(num);
        while(!st.isEmpty())
        {
            str=str+st.pop()+"";
        }
        return str;
    }
}

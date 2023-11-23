//{ Driver Code Starts
import java.io.*;
import java.util.*;

class pair
{
    int first;
    boolean second;
    pair(int first, boolean second)
        {
            this.first = first;
            this.second = second;
        }
}
class Node
{
    int data, height;
    Node left, right;
    
    Node(int x)
    {
        data=x;
        left=right=null;
        height=1;
    }
}
class GfG
{
    public static boolean isBST(Node n, int lower, int upper)
    {
    	if(n==null) return true;
    	if( n.data <= lower || n.data >= upper ) return false;
    	return isBST(n.left, lower, n.data) && isBST(n.right, n.data, upper) ;
    }
    
    public static pair isBalanced(Node n)
    {
    	if(n==null)
    	    {
    	        return new pair(0,true);
    	    }
        
    	pair l = isBalanced(n.left);
    	pair r = isBalanced(n.right);
    
    	if( Math.abs(l.first - r.first) > 1 ) return new pair (0,false);
    
    	return new pair( 1 + Math.max(l.first , r.first) , l.second && r.second );
    }
    
    public static boolean isBalancedBST(Node root)
    {
    	if( isBST(root, Integer.MIN_VALUE , Integer.MAX_VALUE) == false )
    		System.out.print("BST voilated, inorder traversal : ");
    
    	else if ( isBalanced(root).second == false)
    		System.out.print("Unbalanced BST, inorder traversal : ");
    
    	else return true;
    	return false;
    }
    
    public static void printInorder(Node n)
    {
    	if(n==null) return;
    	printInorder(n.left);
    	System.out.print(n.data + " ");
    	printInorder(n.right);
    }


    public static void main(String args[])
        {
            int ip[] = new int[2000];
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    for(int i = 0; i < n; i++)
                        {
                            ip[i] = sc.nextInt();
                        }
                        
                    Node root = null;
                    Solution obj = new Solution();
                    for(int i=0; i<n; i++)
                    {
                        root = obj.insertToAVL( root, ip[i] );
                        
                        if ( isBalancedBST(root) == false )
                            break;
                    }
                    
                    printInorder(root);
                    System.out.println();
                    
                }
            
                
        }
}
// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node left;
    Node right;
    int height;
};
*/
class Solution
{
    int height(Node node){
        if(node == null){
            return 0;
        }
        
        return node.height;
    }
    
    int getbalance(Node node){
        if(node==null){
            return 0;
        }
        
        return height(node.left) - height(node.right);
    }
    
    Node rightRo(Node node){
        Node x = node.left;
        Node y = x.right;
        
        x.right = node;
        node.left = y;
       
        node.height = 1 + Math.max(height(node.left), height(node.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));
        
        return x;
    }
    
    Node leftRo(Node node){
        Node x = node.right;
        Node y = x.left;
        
        x.left = node;
        node.right = y;
        
        node.height = 1 + Math.max(height(node.left), height(node.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));
        
        return x;
    }
    
    public  Node insertToAVL(Node node,int data)
    {
        //code here
        if(node==null){
            return new Node(data);
        }
        
        if(data < node.data){
            node.left = insertToAVL(node.left, data);
        }else if(data > node.data){
            node.right = insertToAVL(node.right, data);
        }else{
            return node;
        }
        
        node.height = 1 + Math.max(height(node.left), height(node.right));
        
        int bal = getbalance(node);
        
        if(bal > 1 && data < node.left.data){
            return rightRo(node);
        }
        
        if(bal < -1 && data > node.right.data){
            return leftRo(node);
        }
        
        if(bal > 1 && data > node.left.data){
            node.left = leftRo(node.left); 
            return rightRo(node);
        }
        
        if(bal < -1 && data < node.right.data){
            node.right = rightRo(node.right); 
            return leftRo(node);
        }
        
        return node;
    }
}    
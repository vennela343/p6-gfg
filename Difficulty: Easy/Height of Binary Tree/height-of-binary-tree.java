/*
class Node {
    int data;
    Node left, right;

    Node(int val)
    {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public int height(Node root) {
        // code here
        return root==null?-1:1+Math.max(height(root.left),height(root.right));
    }
}
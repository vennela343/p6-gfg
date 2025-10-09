/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
} */

class Solution {
    int fans = 0;  

    public int diameter(Node root) {
        depth(root);
        return fans;
    }

    int depth(Node root) {
        if (root == null)
            return 0;

        int l = depth(root.left);
        int r = depth(root.right);

        fans = Math.max(fans, l + r);

        return 1 + Math.max(l, r);
    }
}

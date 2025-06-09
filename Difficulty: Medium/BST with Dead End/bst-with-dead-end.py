class Solution:
    def isDeadEnd(self, root):
        # Code her
    
        def check(node, min_val, max_val):
            if not node:
                return False

            # Dead end found
            if min_val == max_val:
                return True

            # Check recursively for left and right subtrees
            return (check(node.left, min_val, node.data - 1) or
                    check(node.right, node.data + 1, max_val))

        return check(root, 1, float('inf'))

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    /**
        TC -> O(N) where N is the number of nodes in the tree
        SC -> O(H), Used DFS, so height of the tree

        We start with -infinity to +infinity as ranges for root. 
        Traversing left, the min remians same as root and max becomes root.
        Traversing right, the max remians same as root and min becomes root.
        Any time the current value is not within the range, return false.
     */

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        
    }

    private boolean helper(TreeNode root, long min, long max){
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}

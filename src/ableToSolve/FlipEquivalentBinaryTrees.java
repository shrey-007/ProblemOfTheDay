package ableToSolve;

/**
 * For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child
 * subtrees.
 *
 * A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of
 * flip operations.
 *
 * Given the roots of two binary trees root1 and root2, return true if the two trees are flip equivalent or false otherwise.
 * */
public class FlipEquivalentBinaryTrees {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // if both are null return true
        if(root1==null && root2==null){return true;}
        // if one is null other is not return false
        if(root1==null || root2==null){return false;}

        // if their value are not same return false
        if(root1!=root2){return false;}

        // if both roots are same then we have to check whether their subtrees are equal or not
        // either their left,left and right,right subtrees should match or their left,right and right,left subtrees should match
        boolean faith1 = flipEquiv(root1.left,root2.left) && flipEquiv(root1.right,root2.right);
        boolean faith2 = flipEquiv(root1.left,root2.right) && flipEquiv(root1.right,root2.left);

        // if either of them match then return true
        return faith1 || faith2;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}



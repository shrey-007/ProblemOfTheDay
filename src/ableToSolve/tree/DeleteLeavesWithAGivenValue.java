package ableToSolve.tree;

public class DeleteLeavesWithAGivenValue {
    /**
     * Given a binary tree root and an integer target, delete all the leaf nodes with value target.
     *
     * Note that once you delete a leaf node with value target, if its parent node becomes a leaf node and has the value
     * target, it should also be deleted (you need to continue doing that until you cannot).
     */
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root==null) return null;
        // check if current is leaf or not
        // if it is leaf node and equal to target means it has to be deleted so just return null
        if(root.left==null && root.right==null && root.val==target){return null;}

        // check left subtree, maybe left subtree has leaf node with target node so it can change, so root.left = krke call kro
        if(root.left!=null) root.left = removeLeafNodes(root.left,target);
        if(root.right!=null) root.right = removeLeafNodes(root.right,target);

        // ab left and right dono subtree mai change ho gye maybe ye khud leaf ban gya ho toh ise bhi delete krna hai
        if(root.left==null && root.right==null && root.val==target){return null;}
        return root;
    }
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

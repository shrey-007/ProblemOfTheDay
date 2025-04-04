package ableToSolve.tree;

import java.util.HashSet;

public class LowestCommonAncestorOfDeepestLeaves{

    public class TreeNode {
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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        HashSet<TreeNode> ans = new HashSet<>();
        deepestNodes(root,0,new int[1],ans);
        // System.out.println(ans);
        return lca(root,ans);
    }

    // function to find lca of all all nodes in hashset, it is ditto same as lca of two nodes
    public TreeNode lca(TreeNode root,HashSet<TreeNode> ans){
        if(root==null) return null;
        if(ans.contains(root)) return root;

        TreeNode faith1 = lca(root.left,ans);
        TreeNode faith2 = lca(root.right,ans);

        if(faith1!=null && faith2!=null) return root;
        if(faith1!=null) return faith1;
        if(faith2!=null) return faith2;
        return null;
    }

    // this is the function to find lca of two nodes root1 and root2

//    public TreeNode lca(TreeNode root,TreeNode root1,TreeNode root2){
//        if(root==null) return null;
//        if(root==root1 || root==root2) return root;
//
//        TreeNode faith1 = lca(root.left,root1,root2);
//        TreeNode faith2 = lca(root.right,root1,root2);
//
//        if(faith1!=null && faith2!=null) return root;
//        if(faith1!=null) return faith1;
//        if(faith2!=null) return faith2;
//        return null;
//    }

    // function to find all leaf nodes of deepest level.
    // Ans is stored in hashset
    public void deepestNodes(TreeNode root,int level,int maxLevel[],HashSet<TreeNode> ans){
        if(root==null) return;
        if(root.left!=null) deepestNodes(root.left,level+1,maxLevel,ans);
        if(root.right!=null) deepestNodes(root.right,level+1,maxLevel,ans);
        if(root.left==null && root.right==null){
            if(level==maxLevel[0]){
                ans.add(root);
            }
            else if(level>maxLevel[0]){
                ans.clear();
                ans.add(root);
                maxLevel[0] = level;
            }
        }
    }
}

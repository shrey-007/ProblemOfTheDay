package ableToSolve.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecoverATreeFromPreorderTraversal {
    public TreeNode recoverFromPreorder(String traversal) {
        int n = traversal.length();
        // level-> nodes on that level
        HashMap<Integer, List<TreeNode>> hm = new HashMap<>();
        int level = 0;

        int i=0;
        while(i<n){
            char curr = traversal.charAt(i);
            if(curr=='-') level++;
            else{
                int j=i;
                while(j+1<n && traversal.charAt(j+1)!='-'){
                    j++;
                }
                int nodeVal = Integer.parseInt(traversal.substring(i,j+1));
                List<TreeNode> nodesOnCurrentLevel = hm.getOrDefault(level,new ArrayList<>());
                TreeNode currNode = new TreeNode(nodeVal);
                nodesOnCurrentLevel.add(currNode);
                hm.put(level,nodesOnCurrentLevel);
                level=0;
                i=j;
            }
            i++;
        }
        System.out.println(hm);

        // hashmap if filled now

        return null;
    }

    public static void main(String[] args) {
        RecoverATreeFromPreorderTraversal r = new RecoverATreeFromPreorderTraversal();
        r.recoverFromPreorder("1-2--3--4-5--6--7");
    }
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }
}

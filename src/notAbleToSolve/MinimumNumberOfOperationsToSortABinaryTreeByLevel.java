package notAbleToSolve;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class MinimumNumberOfOperationsToSortABinaryTreeByLevel {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        int ans = 0;

        while (!queue.isEmpty()){
            int sizeOfCurrentLevel = queue.size();
            // store all value os current level
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < sizeOfCurrentLevel; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            // get the number of swaps to sort the current level
            ans = ans + countSwaps(list);
        }

        return ans;
    }

    public int countSwaps(ArrayList<Integer> arr) {
        int n = arr.size();
        ArrayList<ElementWithIndex> list = new ArrayList<>();

        // Step 1: Pair elements with their original indices
        for (int i = 0; i < n; i++) {
            list.add(new ElementWithIndex(arr.get(i), i));
        }

        // Step 2: Sort based on the element values
        Collections.sort(list);

        // Step 3: Traverse and fix mismatches
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            // Skip if the element is already in the correct position
            if (list.get(i).index == i) {
                continue;
            }

            // Swap the element with the one at its original position
            swap(list, i, list.get(i).index);
            swaps++;

            // Decrement the index to check the swapped element
            i--;
        }

        return swaps;
    }

    public void swap(ArrayList<ElementWithIndex> list, int i, int j) {
        ElementWithIndex temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    class ElementWithIndex implements Comparable<ElementWithIndex>{
        int element;
        int index;

        public ElementWithIndex(int element, int index) {
            this.element = element;
            this.index = index;
        }

        @Override
        public int compareTo(ElementWithIndex o) {
            return this.element-o.element;
        }
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
  }
}

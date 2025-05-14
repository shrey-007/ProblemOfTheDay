//package notAbleToSolve;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MakeLexicographicallySmallestArrayBySwappingElements {
//    /**
//     * You are given a 0-indexed array of positive integers nums and a positive integer limit.
//     *
//     * In one operation, you can choose any two indices i and j and swap nums[i] and nums[j] if |nums[i] - nums[j]| <= limit.
//     *
//     * Return the lexicographically smallest array that can be obtained by performing the operation any number of times.
//     *
//     * An array a is lexicographically smaller than an array b if in the first position where a and b differ, array a
//     * has an element that is less than the corresponding element in b. For example, the array [2,10,3] is lexicographically
//     * smaller than the array [10,2,3] because they differ at index 0 and 2 < 10.
//     * */
//
//    // we have a limit, we can't keep swapping . So ho skta hai ki limit number of swaps krne ke baad jo array aaya voh sorted nhi hai
//    // Toh we want Lexicographically Smallest Array, toh leftmost index ko fix krne se start kro.
//    public int func()
//    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
//        int n = nums.length;
//        int isPlaced[] = new int[n];
//
//        for (int i = 0; i < n; i++) {
//
//        }
//    }
//
//    class Node{
//        int element;
//        int index;
//
//        public Node(int element, int index) {
//            this.element = element;
//            this.index = index;
//        }
//    }
//
//     class DisjointSet {
//        List<Integer> rank = new ArrayList< >();
//        List<Integer> parent = new ArrayList<>();
//        public DisjointSet(int n) {
//            // initially sabke parent vo khud hi hai, means kisi ka koi chidren nhi hai , sabka group alag hai
//            // and sabki rank 0 hai initially
//            for (int i = 0; i <= n; i++) {
//                rank.add(0);
//                parent.add(i);
//            }
//        }
//
//        public int findUPar(int node) {
//            // if node ka parent vo khud hi hai means ki ya toh voh abhi akela node hai us group mai toh vahi parent hai
//            // or uske group mai nodes kaafi hai , but un sabka parent vo khud hi hai, toh us case mai bhi vahi parent hai toh node ko return krdo
//            if (node == parent.get(node)) {
//                return node;
//            }
//
//            // hume parent nhi dena ultimate parent dena hai toh, find ultimate parent ko parent
//            int ulp = findUPar(parent.get(node));
//            // jo parent ka ultimate parent hai voh iska bhi ultimate parent hai, toh simply update krdo  kiuki parent store
//            // krne ka mtlb nhi hai agar apan ko ultimate parent pata hai.
//            // agar ultimate parent pata hai toh vahi parent mai store krdo
//            parent.set(node, ulp);
//            // return parent
//            return parent.get(node);
//        }
//
//        // we have to connect u and v through this function
//        public void unionByRank(int u, int v) {
//            // find ultimate parent of u and v
//            int ulp_u = findUPar(u);
//            int ulp_v = findUPar(v);
//
//            // if ultimate parent of u and v are same means they are already connected, they r in same group , so just return
//            if (ulp_u == ulp_v) return;
//
//            // smaller guy gets connected to bigger guy, just for optimization
//            // you can also connect larger to smaller, but it will not be optimized
//
//            if (rank.get(ulp_u) < rank.get(ulp_v)) {
//                // here rank of u is smaller so it gets connected to v
//                // So in order to connect u to v , u ka parent v banado
//                // there will no change in rank, since smaller is going to attach with bigger
//                parent.set(ulp_u, ulp_v);
//            } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
//                // here rank of v is smaller so it gets connected to u
//                // So in order to connect v to u , v ka parent u banado
//                // there will no change in rank, since smaller is going to attach with bigger
//                parent.set(ulp_v, ulp_u);
//            } else {
//                // now if the rank of ultimate parent of u == rank of ultimate parent of v toh us case mai kisi ko bhi kisi se connect krdo
//                // yaha humne v ko u mai joda
//
//                // toh since v ko u mai joda hai toh v ka parent u hoga
//                parent.set(ulp_v, ulp_u);
//
//                // or since dono same rank ke the and combine hue toh parent ki rank bada do
//                int rankU = rank.get(ulp_u);
//                rank.set(ulp_u, rankU + 1);
//
//            }
//        }
//
//
//    }
//}

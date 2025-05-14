Here are some classic and high-quality problems that use the **range count** technique (often combined with sorting, binary search, or advanced data structures like Segment Trees, Fenwick Trees, or Balanced BSTs).

---

### ✅ **1. Count of Smaller Numbers After Self**

* **Leetcode #315**
* **Problem**: Given an integer array `nums`, return an array where each element is the count of numbers smaller than it to its right.
* **Idea**: Process elements from right to left, maintain a sorted list of seen elements, and count how many elements are smaller (i.e., range count problem with `(-∞, nums[i] - 1]`).

🔗 [Leetcode 315](https://leetcode.com/problems/count-of-smaller-numbers-after-self/)

---

### ✅ **2. Count of Range Sum**

* **Leetcode #327**
* **Problem**: Given an integer array `nums` and integers `lower` and `upper`, return the number of range sums that lie in `[lower, upper]`.
* **Idea**: Use prefix sums + divide and conquer or a BST/Multiset. For each prefix sum, you find how many earlier prefix sums are in the range `[current - upper, current - lower]`.

🔗 [Leetcode 327](https://leetcode.com/problems/count-of-range-sum/)

---

### ✅ **3. Reverse Pairs**

* **Leetcode #493**
* **Problem**: Count the number of pairs `(i, j)` such that `i < j` and `nums[i] > 2 * nums[j]`.
* **Idea**: Sort + modified merge sort or use a BST/Fenwick tree to count how many values lie in a certain range.

🔗 [Leetcode 493](https://leetcode.com/problems/reverse-pairs/)

---

### ✅ **4. Number of Subsequences That Satisfy the Given Sum Condition**

* **Leetcode #1498**
* **Problem**: Count the number of non-empty subsequences such that the sum of the minimum and maximum elements is ≤ target.
* **Idea**: Sort the array and for each index `i`, use binary search to find the maximum `j` such that `nums[i] + nums[j] <= target`. This is a range count.

🔗 [Leetcode 1498](https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/)

---

### ✅ **5. Count of Pairs With Sum in a Given Range**

* **Your current problem**: Count number of pairs `(i, j)` such that `lower <= nums[i] + nums[j] <= upper`.
* **Idea**: Sort and use binary search for each `i` to find valid `j` such that `nums[j]` lies in a range.

---

### ✅ **6. Count the Number of Good Subarrays**

* **Leetcode Biweekly 104, Problem D**
* **Problem**: Given an array of integers and a target value, count how many subarrays have a number of elements greater than or equal to the target.
* **Idea**: Again, a prefix sum with a counting technique — range counting using a TreeMap, Fenwick Tree, or sorted list.

---

### 🔧 Tools Often Used for Range Count Problems:

* `Arrays.binarySearch()` + custom lower/upper bound
* `TreeMap` or `TreeSet` (Java)
* Fenwick Tree (Binary Indexed Tree)
* Segment Tree
* Multiset or Ordered Set (in C++)
* Merge Sort (in counting inversions, reverse pairs, etc.)

---

Would you like me to sort these by difficulty or give you a progressive list to practice from easy to hard?

//// Pros and Cons of Using LinkedList for Inventory Management
////
//// Pros:
//// 1. Fast Insertions/Deletions:
////    - LinkedLists handle insertions and deletions quickly, especially at the start or middle of the list.
////    - Ideal for dynamic inventory systems where items are frequently added or removed without needing to shift elements.
////
//// 2. Flexible Size:
////    - LinkedLists grow and shrink as needed, so no initial capacity is required, which suits variable inventory sizes.
////
//// Cons:
//// 1. Slow Traversal:
////    - Accessing an item by index is slow, as it requires moving through nodes sequentially, making LinkedLists less efficient for searches.
////
//// 2. Higher Memory Usage:
////    - Each item needs additional memory for pointers, resulting in higher memory consumption than array structures.
////
//// Summary:
//// LinkedLists are great for frequent additions/removals but not ideal if fast access or large datasets are needed.
//
//
//// Why MergeSort is Suitable for Linked Lists:
//// 1. MergeSort efficiently handles linked lists as it does not require random access. Unlike QuickSort,
////    which relies on element swapping (difficult in linked lists without direct indexing), MergeSort
////    splits the list into halves and merges them back, making it a natural fit for linked list structures.
////
//// 2. MergeSort is stable, meaning it maintains the relative order of equal elements. Stability is valuable
////    in cases where maintaining order based on initial input is essential, as linked lists often involve
////    multi-criteria sorting.
////
//// Why QuickSort is Less Efficient for Linked Lists:
//// 1. QuickSort's partitioning requires frequent element swapping, which is inefficient for linked lists
////    due to lack of direct access to elements by index. QuickSort is thus slower and more complex to
////    implement with linked lists compared to MergeSort.
////
//// Real-World Scenario where MergeSort’s Stability is Essential:
//// - Imagine a list of orders in an e-commerce inventory system, where orders are sorted first by
////   delivery date, and within each date, by customer priority. Using a stable sorting algorithm like
////   MergeSort ensures that within orders of the same delivery date, high-priority customers appear
////   first, preserving the intended order without re-sorting.



/*
An AVL tree offers efficient 
O(logn) search times by maintaining a balanced structure, making it ideal for large datasets where frequent searches are required. In contrast:
Linked List: Has a linear O(n) search time due to sequential access, making it inefficient for searching but suitable for quick insertions and deletions.
Unsorted Array: Also has O(n) search time, requiring a linear scan, but allows quick insertions and random access by index.
*/

/*
Bubble Sort has an average and worst-case time complexity of 
O(n 2), making it inefficient for large datasets. It works by repeatedly "bubbling" the largest unsorted element to the end of the list. Despite its inefficiency, Bubble Sort is simple, easy to implement, and can be useful for small or nearly sorted datasets, where early termination can improve performance.
*/

/*
Quick Sort is an efficient, scalable sorting algorithm with an average time complexity of 
O(nlogn). It works by partitioning the data around a pivot and recursively sorting each partition. Quick Sort is especially well-suited for large datasets, requires minimal additional memory, and can adapt to different scenarios with variations in pivot selection.
*/

/*
Insertion Sort is a simple, in-place sorting algorithm with a best-case time complexity of 
O(n) and an average/worst-case time complexity of 
O(n 2). It is efficient for small or nearly sorted datasets and is easy to implement. Insertion Sort is stable (preserves the order of equal elements) and requires minimal additional memory. However, it becomes inefficient for large datasets compared to more advanced algorithms like Quick Sort or Merge Sort.
*/

/*
Selection Sort is a simple, in-place sorting algorithm with a time complexity of 
O(n 2), making it inefficient for large datasets. It performs fewer swaps than algorithms like Bubble Sort or Insertion Sort but is still slow due to its quadratic comparison count. While it is easy to implement and requires minimal additional memory, it is mainly suited for small datasets or situations where minimizing swaps is important.
*/

/*
Merge Sort is a stable, divide-and-conquer sorting algorithm with a time complexity of 
O(nlogn), making it efficient for large datasets. It requires additional space for merging, resulting in a space complexity of 
O(n). While it performs consistently and is stable, it can be slower than simpler algorithms for small datasets due to its overhead. Merge Sort is ideal for large datasets but may not be the most memory-efficient option compared to in-place algorithms like Quick Sort.
*/

/*
Bubble Sort:
Time Complexity: 
O(n 2 ) in average and worst cases.
Advantages: Simple to implement, good for small or nearly sorted datasets.
Disadvantages: Inefficient for large datasets, no adaptive behavior for unsorted data.

Quick Sort:
Time Complexity: 
O(nlogn) on average, 
O(n 2 ) in the worst case (with poor pivot choice).
Advantages: Fast for large datasets, in-place sorting, good average performance.
Disadvantages: Can degrade to 
O(n 2 ) in the worst case, not stable, recursion overhead.

Insertion Sort:
Time Complexity: 
O(n 2 ) in average and worst cases, 
O(n) in the best case (nearly sorted data).
Advantages: Simple to implement, good for small or nearly sorted datasets, stable sort.
Disadvantages: Inefficient for large datasets, quadratic time complexity.

Selection Sort:
Time Complexity: 
O(n 2 ) in all cases (doesn't adapt to data order).
Advantages: Simple, minimal memory usage, few swaps.
Disadvantages: Inefficient for large datasets, not stable, too many comparisons.

Merge Sort:
Time Complexity: 
O(nlogn) in all cases.
Advantages: Stable sort, efficient for large datasets, consistent performance.
Disadvantages: Requires extra memory 
O(n), not as fast as Quick Sort for small datasets.

*/

/*
Insertion Sort is the most advantageous for small or nearly sorted datasets.
Quick Sort is the best for large datasets in terms of speed, assuming a good pivot selection.
Merge Sort is the best for consistent 
O(nlogn) performance, regardless of data order, though it requires extra space.
*/

/*
ArrayList:

Time Complexity:
Access (get/set): 
O(1)
Add (at the end): 
O(1) (amortized)
Insert/remove (in the middle): 
O(n)
Advantages:
Fast random access by index.
Automatically resizes as elements are added.
Cache-friendly and suitable for frequent index-based access.
Disadvantages:
Slower insertions and deletions (except at the end) due to shifting elements.
LinkedList:

Time Complexity:
Access (get/set): 
O(n) (requires traversal)
Add/remove (at the beginning or end): 
O(1)
Advantages:
Efficient insertions/removals at the beginning and middle (if position is known).
No resizing needed; elements can be added dynamically without reallocation.
Disadvantages:
Slower random access (requires traversal).
Higher memory usage due to storing pointers in each node.
Queue (implemented by LinkedList or PriorityQueue):

Time Complexity:
Add: 
O(1) (enqueue)
Remove: 
O(1) (dequeue)
Advantages:
Follows FIFO (First-In-First-Out) order, ideal for tasks like task scheduling, buffering, and processing in order.
Efficient for adding and removing elements at the ends.
Disadvantages:
Less efficient for random access or arbitrary element removal.
Not suitable for situations requiring frequent access to elements in the middle.
Stack (a subclass of Vector):

Time Complexity:
Push (add to top): 
O(1)
Pop (remove from top): 
O(1)
Advantages:
Follows LIFO (Last-In-First-Out) order, useful for backtracking, undo operations, and maintaining function calls.
Thread-safe (synchronized) in a multithreaded environment.
Disadvantages:
Performance overhead due to synchronization (in the case of the original Stack class).
Not as efficient for operations that require access to elements in the middle or random access.

*/
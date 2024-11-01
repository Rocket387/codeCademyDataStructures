Data Structures is about how data can be stored in different structures

Trees

How to traverse a tree and display its content
1. Depth-first-search (DFS) is a technique that visits the first child in the children list and that node’s children recursively before visiting all the first child’s siblings and then their children recursively
2. breadth-first (BFS) is a technique in a tree that visits all children of a node first before visiting any further levels.


Binary Search Tree
- A Binary Search Tree is an efficient value structure for fast (O(log N)) data storage and retrieval. 
It is a specialized tree data structure that is made up of a root node, and at most two child branches or subtrees.
- Each Binary Search Tree node has the following properties:

1. a value
2. a depth value, where a depth of 1 indicates the top level of the tree and a depth greater than 1 is a level somewhere lower in the tree
3. a left pointer that points to a left child which is itself a Binary Search Tree, and must have a data lesser than its parent node’s data
4. a right pointer that points to a right child which is itself a Binary Search Tree, and must have a data greater than or equal to its parent node’s data
   
* Inorder is when we perform an action on the left child node first, followed by the current node and the right child node
  *      15
      /------+-----\
      12            20
     /   \          /   \   
    10     13     18     22
    / \   /  \    / \   /  \
  8  11 12  14  16 19 21  25

first traversal = 8, 10, 11
second traversal = 12, 12, 13, 14 We ascend one level up to visit root node 12 before we descend back to the bottom where the right subtree resides


Heaps
- Parent is always the MIN
- Children are always greater than or equal to parent
- max heaps 
* min heaps (picture as binary trees)- root = min value of dataset, every childs value is greater than or equal to its parent
  The location of each child or parent derives from a formula using the index
left child: (index * 2) + 1
right child: (index * 2) + 2
parent: (index - 1) / 2 — not used on the root!
* Heapify Up = adding an element to the bottom of the tree and moving upwards to restore violations of low values being children of higher values
  (children must be greater than or equal to parents)
* Heapify down = how to retrieve the minimum value without orphaning children and not violating the heap (minimum value at the root)
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
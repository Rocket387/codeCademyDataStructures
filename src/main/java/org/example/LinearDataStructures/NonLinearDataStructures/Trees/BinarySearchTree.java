package org.example.LinearDataStructures.NonLinearDataStructures.Trees;

/* for binary Search Trees if value is less than root or depth + 1, add value to the left
if value greater than root or depth + 1, add value to the right

 */
public class BinarySearchTree {

    public int value;
    public int depth;
    public BinarySearchTree left;
    public BinarySearchTree right;

    public BinarySearchTree(int value, int depth) {
        this.value = value;
        this.depth = depth;
        this.left = null;
        this.right = null;
    }

    public BinarySearchTree(int value) {
        this.value = value;
        this.depth = 1;
        this.left = null;
        this.right = null;
    }

    public void insert(int value) {
        //checks if value is less than current nodes value
        if (value < this.value) {
            //checks if left child node already exists and creates one if it doesn't (null) at a new depth to the root (depth +1)
            if (this.left == null) {
                this.left = new BinarySearchTree(value, this.depth + 1);
                System.out.printf("Tree node %d added to the left of %d at depth %d \n", value, this.value, this.depth + 1);
            } else {
                //if left child node does exist, add the value (if less than current value) to the left
                this.left.insert(value);
            }
        } else {
            if (this.right == null) {
                this.right = new BinarySearchTree(value, depth + 1);
                System.out.printf("Tree node %d added to the right of %d at depth %d \n", value, this.value, this.depth + 1);
            }
        }
    }

    //retrieving a node by value
    //traverses correct branch of the tree by comparing target value
    //to the current nodes value
    public BinarySearchTree getNodeByValue(int value) {
        //base case, when values match, return current node
        //compare target value with root value (this.value)
        if (value == this.value) {
            //if values are the same return 'this' node
            return this;
        } else if (value < this.value && this.left != null) {
            //if value is not found in the node traverse left child node if target value is less than root node
            //recursive call to method itself
            return left.getNodeByValue(value);
        } else if (value > this.value && this.right != null) {
            //if value is greater than root node value traverse right child node
            //recursive call to method itself
            return right.getNodeByValue(value);
        }
        return null;
    }
    public static void main(String[] args) {

        BinarySearchTree root = new BinarySearchTree(100);
        root.insert(50);
        root.insert(125);
        root.insert(75);
        root.insert(25);

        //get nodes by value
        System.out.println(root.getNodeByValue(75));
        System.out.println(root.getNodeByValue(55));
    }
}

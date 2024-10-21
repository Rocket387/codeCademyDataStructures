package org.example.LinearDataStructures.NonLinearDataStructures.Trees;

import java.util.Queue;
import java.util.LinkedList;

public class Tree {

    //Instance variable
    public TreeNode root;

    //Constructor
    public Tree(TreeNode root) {
        this.root = root;
    }

    public void print() {
        print(this.root, 0);
    }

    public void print(TreeNode current, int level) {
        String levelMarks = "";
        for (int i = 0; i < level; i++) {
            levelMarks += "-- ";
        }
        System.out.println(levelMarks + current.data);

        for(TreeNode child : current.children) {
            print(child, level + 1);
        }
    }

    public void depthFirstTraversal(TreeNode current) {
        System.out.print(current.data + " ");
        for (TreeNode child : current.children) {
            depthFirstTraversal(child);
        }
    }

    public void breadthFirstTraversal() {
        TreeNode current = root;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(current);
        while (!queue.isEmpty()) {
            current = queue.poll();
            System.out.print(current.data + " ");
            queue.addAll(current.children);
        }

    }

    public static void main(String[] args) {
        TreeNode treeRoot = new TreeNode("S");
        TreeNode child1 = new TreeNode("N");
        TreeNode child2 = new TreeNode("O");
        TreeNode grandchild1 = new TreeNode("W");
        TreeNode grandchild2 = new TreeNode("Y");

        //addChild operations
        treeRoot.addChild(child1); //add child1 and child2 to treeRoots children
        treeRoot.addChild(child2);
        child1.addChild(grandchild1); //add grandchild1 and grandchild2 to child1 and child2 children
        child2.addChild(grandchild2);

        //create tree
        Tree letters = new Tree(treeRoot);

        //print tree
        letters.print();

        Tree tree = new Tree(treeRoot);
        tree.print();
        tree.depthFirstTraversal(treeRoot);

        tree.breadthFirstTraversal();
    }
}

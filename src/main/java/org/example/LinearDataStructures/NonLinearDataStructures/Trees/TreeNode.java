package org.example.LinearDataStructures.NonLinearDataStructures.Trees;

import java.util.ArrayList;
public class TreeNode {

    public Object data;
    public ArrayList<TreeNode> children;

    public TreeNode(Object data) {
        this.data = data;
        this.children = new ArrayList<TreeNode>();
    }

    //addChild method with parameter TreeNode child
    public void addChild(TreeNode child) {
        this.children.add(child);
    }

    // addChild method with parameter Object data
    public void addChild(Object childData) {
        this.children.add(new TreeNode(childData));
    }

    public void removeChild(TreeNode childToRemove) {
        if (this.children.isEmpty()) {
            return;
        } else if (this.children.contains(childToRemove)) {
            this.children.remove(childToRemove);
            return;
        } else {
            for (TreeNode child : this.children) {
                child.removeChild(childToRemove);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.addChild(15);
        System.out.println(root.children.size());

        TreeNode biggerChild = new TreeNode(30);
        root.addChild(biggerChild);
        System.out.println(root.children.size());
    }
}

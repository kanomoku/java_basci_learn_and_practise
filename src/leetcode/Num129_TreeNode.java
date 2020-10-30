package leetcode;

import javax.swing.tree.TreeNode;

public class Num129_TreeNode {
    int val;
    Num129_TreeNode left;
    Num129_TreeNode right;

    public Num129_TreeNode getLeft() {
        return left;
    }

    public void setLeft(Num129_TreeNode left) {
        this.left = left;
    }

    public Num129_TreeNode getRight() {
        return right;
    }

    public void setRight(Num129_TreeNode right) {
        this.right = right;
    }

    Num129_TreeNode(int x) {
        val = x;
    }
}

package leetcode;

import javax.swing.tree.TreeNode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Num129_sumNumbers {
    public static void main(String[] args) {

        Num129_TreeNode treeNode1 = new Num129_TreeNode(4);
        Num129_TreeNode treeNode2 = new Num129_TreeNode(9);
        Num129_TreeNode treeNode3 = new Num129_TreeNode(0);
        Num129_TreeNode treeNode4 = new Num129_TreeNode(5);
        Num129_TreeNode treeNode5 = new Num129_TreeNode(1);
        treeNode1.setLeft(treeNode2);
        treeNode1.setRight(treeNode3);
        treeNode2.setLeft(treeNode4);
        treeNode2.setRight(treeNode5);
        System.out.println(sumNumbers(treeNode1));
    }


    public static int sumNumbers(Num129_TreeNode root) {
        return dfs(root, 0);
    }

    public static int dfs(Num129_TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }


}




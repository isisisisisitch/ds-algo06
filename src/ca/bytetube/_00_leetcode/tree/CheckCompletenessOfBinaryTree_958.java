package ca.bytetube._00_leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/
 * @author dal
 */
public class CheckCompletenessOfBinaryTree_958 {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return false;

        boolean leaf = false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            //如果leaf status = true，之后遇到的所有节点必须都是叶节点
            if (leaf && !(node.left == null && node.right == null))return false;

            if (node.left != null && node.right != null) {//1
                queue.offer(node.left);
                queue.offer(node.right);
            }
            else if (node.left == null && node.right != null)  return false;//2

            else if (node.left != null && node.right == null) {//3
                queue.offer(node.left);
                leaf = true;

            }

            //4  node.left == null && node.right == null
            else  leaf = true;


        }

        return true;
    }
}

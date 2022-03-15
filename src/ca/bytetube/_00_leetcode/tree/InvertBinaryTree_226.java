package ca.bytetube._00_leetcode.tree;


import ca.bytetube._05_binaryTree.TreeTraversal;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree_226 {

    public TreeNode invertTreeByPre(TreeNode root) {
        if (root == null) return root;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTreeByPre(root.left);
        invertTreeByPre(root.right);


        return root;

    }

    public TreeNode invertTreeByPost(TreeNode root) {
        if (root == null) return root;


        invertTreeByPost(root.left);
        invertTreeByPost(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    public TreeNode invertTreebyIn(TreeNode root) {
        if (root == null) return root;


        invertTreebyIn(root.left);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTreebyIn(root.left);


        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){

            TreeNode poll = queue.poll();
            TreeNode temp = poll.left;
            poll.left = poll.right;
            poll.right = temp;

            if (poll.left != null)  queue.offer(poll.left);
            if (poll.right != null) queue.offer(poll.right);
        }

        return root;
    }
}

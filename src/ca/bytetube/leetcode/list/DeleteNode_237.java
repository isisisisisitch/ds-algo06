package ca.bytetube.leetcode.list;
/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 * @author dal
 */


public class DeleteNode_237 {

    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }


}

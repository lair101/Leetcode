package com.leetcode.tree.Beans;

import com.leetcode.tree.Beans.BTree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Traveral {

    /**
     * Different traverals approaches
     *
     */

    /**
     * recursively traverse
     */
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        preOrderHelper(res, root);
        return res;
    }

    private void preOrderHelper(List<Integer> res, TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        preOrderHelper(res, root.left);
        preOrderHelper(res, root.right);
    }

    public List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        inOrderHelper(res, root);
        return res;
    }

    private void inOrderHelper(List<Integer> res, TreeNode root) {
        if (root == null) return;
        inOrderHelper(res, root.left);
        res.add(root.val);
        inOrderHelper(res, root.right);
    }

    public List<Integer> postOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        postOrderHelper(res, root);
        return res;
    }

    private void postOrderHelper(List<Integer> res, TreeNode root) {
        if (root == null) return;
        postOrderHelper(res, root.left);
        postOrderHelper(res, root.right);
        res.add(root.val);
    }

    @Test
    public void testRecursive() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        BTree b = new BTree();
        TreeNode root = b.buildTree(arr);
        b.print(root);
        Traveral t = new Traveral();
        System.out.println("pre order traverse....");
        System.out.println(t.preOrder(root));
        System.out.println(t.preOrder2(root));
        System.out.println("in order traverse....");
        System.out.println(t.inOrder(root));
        System.out.println(t.inOrder2(root));
        System.out.println("post order traverse....");
        System.out.println(t.postOrder(root));
        System.out.println(t.postOrder2(root));

    }


    /***
     * non-recursively
     */
    public List<Integer> preOrder2(TreeNode root){
        List<Integer> res = new ArrayList<>();
        // Base Case
        if (root == null) {
            return res;
        }

        // Create an empty stack and push root to it
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);

        /* Pop all items one by one. Do following for every popped item
         a) print it
         b) push its right child
         c) push its left child
         Note that right child is pushed first so that left is processed first */
        while (nodeStack.empty() == false) {

            // Pop the top item from stack and print it
            TreeNode mynode = nodeStack.peek();
            res.add(mynode.val);
            nodeStack.pop();

            // Push right and left children of the popped node to stack
            if (mynode.right != null) {
                nodeStack.push(mynode.right);
            }
            if (mynode.left != null) {
                nodeStack.push(mynode.left);
            }
        }

        return res;
    }

    public List<Integer> inOrder2(TreeNode root){
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        //keep the nodes in the path that are waiting to be visited
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;

        //first node to be visited will be the left one
        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        // traverse the tree
        while (stack.size() > 0) {

            // visit the top node
            node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                node = node.right;

                // the next node to be visited is the leftmost
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        return res;
    }

    public List<Integer> postOrder2(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> S = new Stack<>();

        // Check for empty tree
        if (root == null)
            return res;
        S.push(root);
        TreeNode prev = null;
        while (!S.isEmpty())
        {
            TreeNode current = S.peek();

            /* go down the tree in search of a leaf an if so process it
            and pop stack otherwise move down */
            if (prev == null || prev.left == current ||
                    prev.right == current)
            {
                if (current.left != null)
                    S.push(current.left);
                else if (current.right != null)
                    S.push(current.right);
                else
                {
                    S.pop();
                    res.add(current.val);
                }

                /* go up the tree from left node, if the child is right
                   push it onto stack otherwise process parent and pop
                   stack */
            }
            else if (current.left == prev)
            {
                if (current.right != null)
                    S.push(current.right);
                else
                {
                    S.pop();
                    res.add(current.val);
                }

                /* go up the tree from right node and after coming back
                 from right node process parent and pop stack */
            }
            else if (current.right == prev)
            {
                S.pop();
                res.add(current.val);
            }

            prev = current;
        }

        return res;
    }

}

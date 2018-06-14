package com.leetcode.tree.Beans;

import org.junit.jupiter.api.Test;

import java.util.*;

public class BTree {

    TreeNode root;

    //Build BTree
    TreeNode BTree(int val) {
        return new TreeNode(val);
    }


    TreeNode buildTree(int[] arr) {
        Arrays.sort(arr);
        int start = 0, end = arr.length - 1;
        if (arr.length == 0) return null;
        return buildBTree(start, end, arr);
    }

    private TreeNode buildBTree(int start, int end, int[] nums) {
        if (start > end) return null;
        int mid = (end + start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.right = buildBTree(mid + 1, end, nums);
        node.left = buildBTree(start, mid - 1, nums);
        return node;
    }


    //print tree

    /**
     * There is n layers.
     * every layer has 2.power(n-1) nodes
     * total has 2.power(n)-1 nodes
     *
     * The i th node should have. 2.power(n-i) space + number
     * @param root
     */
    /**
     * Print a tree
     *
     * @param root
     *            tree root node
     */
    public void print(TreeNode root)
    {
        List<List<String>> lines = new ArrayList<List<String>>();

        List<TreeNode> level = new ArrayList<TreeNode>();
        List<TreeNode> next = new ArrayList<TreeNode>();

        level.add(root);
        int nn = 1;

        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<String>();

            nn = 0;

            for (TreeNode n : level) {
                if (n == null) {
                    line.add(null);

                    next.add(null);
                    next.add(null);
                } else {
                    String aa = String.valueOf(n.val);
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.left);
                    next.add(n.right);

                    if (n.left != null) nn++;
                    if (n.right != null) nn++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<TreeNode> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '└';
                        }
                    }
                    System.out.print(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }

            // print line of numbers
            for (int j = 0; j < line.size(); j++) {

                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            perpiece /= 2;
        }
    }
    /**
     * get the height of Btree
     *
     * @param node
     * @return
     */
    private int getHeight(TreeNode node) {
        int height = 0;
        if (node == null) {
            height = -1;
        } else {
            height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        }
        return height;
    }

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }


    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


    @Test
    public void testBuildTree() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        TreeNode node = buildTree(arr);

        print(node);
    }

}

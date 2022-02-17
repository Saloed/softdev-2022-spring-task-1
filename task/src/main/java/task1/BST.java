package task1;


import java.util.ArrayList;
import java.util.List;

public class BST {


    BST(String str) {
        String[] array = str.split(" ");
        for (String s : array) {
            add(Integer.parseInt(String.valueOf(s)));
        }
    }

    static class Node {
        int value;
        Node parent;
        Node left;
        Node right;

        Node(int value, Node parent) {
            this.parent = parent;
            this.value = value;
            right = null;
            left = null;
        }

        public Node showParent() {
            return parent;
        }

        public Node showLeft() {
            return left;
        }

        public Node showRight() {
            return right;
        }

    }

    private Node root;

    public void add(int val) {
        addRec(root, val, null);
    }


    private void addRec(Node cur, int val, Node par) {
        if (root == null) {
            root = new Node(val, null);
            return;
        }
        if (cur == null) {
            cur = new Node(val, par);
            if (cur.value < par.value) par.left = cur;
            else par.right = cur;
            return;
        }
        if (val < cur.value) {
            addRec(cur.left, val, cur);
        } else if (val > cur.value) {
            addRec(cur.right, val, cur);
        }
    }

    public Node search(int val) {
        Node cur = root;
        while (cur != null) {
            if (cur.value == val) return cur;
            else if (val < cur.value) cur = cur.left;
            else cur = cur.right;
        }
        return null;
    }

    public void delete(int val) {
        Node cur = search(val);
        if (cur == null) return;
        boolean isLeft = true;
        if (cur != root) {
            isLeft = cur.parent.left == cur;
        }
        Node del = cur;
        if (cur.left == null && cur.right == null) {
            if (cur == root) {
                root = null;
                return;
            }
            if (isLeft) {
                cur.parent.left = null;
            } else cur.parent.right = null;
        } else if (cur.right == null) {
            if (cur == root) {
                root = cur.left;
                return;
            }
            if (isLeft) cur.parent.left = cur.left;
            else cur.parent.right = cur.left;
            cur.left.parent = cur.parent;
        } else if (cur.left == null) {
            if (cur == root) {
                root = cur.right;
                return;
            }
            if (isLeft) cur.parent.left = cur.right;
            else cur.parent.right = cur.right;
            cur.right.parent = cur.parent;
        } else {
            cur = cur.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            int between = cur.value;
            delete(cur.value);
            del.value = between;
        }
    }


    @Override
    public String toString() {
        treeCounter(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        String result = sb.toString();
        sb.delete(0, sb.length());
        return result;
    }

    StringBuilder sb = new StringBuilder();

    private void treeCounter(Node cur, StringBuilder sb) {
        if (cur != null) {
            sb.append(cur.value);
            sb.append(" ");
            treeCounter(cur.left, sb);
            treeCounter(cur.right, sb);
        }
    }

}


package task1;

public class BST {

    static class Node {
        int value;
        Node parent;
        Node left;
        Node right;

        Node(int value, Node parent) {
            this.parent = null;
            this.value = value;
            right = null;
            left = null;
        }
    }

    Node root;

    public void add(int val) {
        root = addRec(root, val, null);
    }


    private Node addRec(Node cur, int val, Node par) {
        if (cur == null) {
            cur = new Node(val, par);
            if (cur.value < par.value) par.right = cur;
            else par.left = cur;
            return cur;
        }
        if (val < cur.value) {
            cur.left = addRec(cur.left, val, cur);
        } else if (val > cur.value) {
            cur.right = addRec(cur.right, val, cur);
        } else {

            return cur;
        }

        return cur;
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
        if (this.search(val) != null) return;
        boolean DNK = true;
        Node cur = search(val);
        if (cur.parent.right == cur) DNK = false;
        Node del = cur;
        if (cur.left == null && cur.right == null) {
            if (DNK) cur.parent.left = null;
            else cur.parent.right = null;
        }
        else if (cur.right == null) {
            if (DNK) cur.parent.left = cur.left;
            else cur.parent.right = cur.left;
            cur.left.parent = cur.parent;
        } else if (cur.left == null) {
            if (DNK) cur.parent.left = cur.right;
            else cur.parent.right = cur.right;
            cur.right.parent = cur.parent;
        } else {
            cur = cur.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            del.value = cur.value;
        }
    }
    public String findNeighbour(int val){
        Node cur = search(val);
        return "Предок: " +
                cur.parent +
                ",\nЛевый потомок: " +
                cur.left +
                ",\nПравый потомок: " +
                cur.right +
                ".";
    }
}



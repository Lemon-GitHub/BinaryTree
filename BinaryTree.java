package BinaryTree;

import java.util.List;
import java.util.ArrayList;

class Node {
    public char val;
    public Node left;
    public Node right;

    public Node(char val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}

public class BinaryTree {
    private static Node root = null;

    public static Node build() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = G;
        C.right = F;
        return A;
    }

    public static void prevOrder(Node root) {
        if(root == null){
            return;
        }

        System.out.print(root.val);
        prevOrder(root.left);
        prevOrder(root.right);
    }

    public static void inOrder(Node root) {
        if(root == null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.val);
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if(root == null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val);
    }

    public static int size(Node root) {
        if(root == null){
            return 0;
        }
        //树的节点个数 = 1 + 左子树节点个数 + 右节点个数
        return 1 + size(root.left) +size(root.right);
    }

    public static int getLeafSize(Node root) {
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 1;
        }
        //叶子结点个数 = 左子树叶子结点数 + 右子树叶子节点数
        return getLeafSize(root.left) + getLeafSize(root.right);
    }

    public static Node find(Node root, char toFind){
        if(root == null){
            return null;
        }
        if(root.val == toFind){
            return root;
        }
        Node ret = find(root.left, toFind);
        if(ret != null){
            return ret;
        }
        return find(root.right, toFind);
    }

    public static void main(String[] args) {
        root = build();
        //prevOrder(root);
        //inOrder(root);
        //postOrder(root);
        //System.out.print(size(root));
        //System.out.print(getLeafSize(root));
        System.out.println(find(root, 'E'));
    }
}

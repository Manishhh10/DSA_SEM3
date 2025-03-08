public class AVLTree {
    public static class Node{
        Node left;
        Node right;
        int data;
        int height;
        Node(int data){
            this.data = data;
            this.height = 1;
            this.left = this.right=null;
        }
    }
    Node createBST(Node root, int data){
        if (root==null) {
            return new Node(data);   
        }
        if (data<root.data) {
            root.left=createBST(root.left, data);
        }
        else if(data>root.data){
            root.right=createBST(root.right, data);
        }
        else{
            return root;
        }
        root.height=Math.max(getHeight(root.left),getHeight(root.right));
        int balancefactor = getBalanceFactor(root);
        if (balancefactor>1 && data<root.left.data) {
            //ll
            return rightRotation(root);
        }
        if (balancefactor>1 && data>root.left.data) {
            //lr
            root.left=leftRotation(root.left);
            return rightRotation(root);
        }
        if (balancefactor<-1 && data>root.right.data) {
            //rr
            return leftRotation(root);
        }
        if (balancefactor<-1&&data<root.right.data) {
            //rl
            root.right=rightRotation(root.right);
            return leftRotation(root);
        }
        return root;
    }
    Node rightRotation(Node y){
        Node x=y.left;
        Node t2=x.right;
        x.right=y;
        y.left=t2;
        y.height=1+Math.max(getHeight(y.left),getHeight(y.right));
        x.height=1+Math.max(getHeight(x.left),getHeight(x.right));
        return x;
    }
    Node leftRotation(Node x){
        Node y=x.left;
        Node t2=y.right;
        y.right=x;
        x.left=t2;
        x.height=1+Math.max(getHeight(x.left),getHeight(x.right));
        y.height=1+Math.max(getHeight(y.left),getHeight(y.right));
        return y;
    }
    int getBalanceFactor(Node root){
        if (root==null) {
            return 0;
        }
        return getHeight(root.left) - getHeight(root.right);
    }
    int getHeight(Node root){
        if (root==null) {
            return 0;
        }
        return root.height;
    }
    public static void main(String[] args) {
        
    }
}
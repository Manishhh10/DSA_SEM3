public class linkedlist {

    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;

    void addNode(int data){
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
            tail = newnode;
        }
        else{
            tail.next = newnode;
            tail = newnode;
            // Node current = head;
            // while (current.next != null) {
            //     current = current.next;
            // }
        }
    }

    void printList(){
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    void adddHeadfirst(int data){
        Node newnode = new Node(data);
        if (head == null) {
            head = tail = newnode;
        }
        else{
            newnode.next = head;
            head = newnode;
        }
    }

    public static void main(String[] args) {

    }
}

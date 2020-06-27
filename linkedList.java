public class linkedList {
    // linkedList fields
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // initialize data
    public Node head = null;
    public Node tail = null;

    // methods
    // add to head
    public void addToHead(int data) {
        // create a new node
        Node newNode = new Node(data);
        // if list is empty, the head and tail will be the newNode
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

    }

    // add to tail
    public void addToTail(int data) {
        // create a new node
        Node newNode = new Node(data);
        // check if empty
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

    }

    // remove head element
    public void removeHead() {
        if (head == null) {
            System.out.println("Empty list");
        } else {
            Node currentHead = head;
            head = currentHead.next;
        }
    }

    // remove tail element
    public void removeTail() {
        Node current = head;
        Node newTail = current;
        while (current.next != null) {
            newTail = current;
            current = current.next;
        }
        tail = newTail;
        tail.next = null;
    }

    // display all
    public void displayAll() {
        Node current = head;
        if (head == null) {
            System.out.println("Empty list");
        }
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        linkedList list = new linkedList();
        list.addToHead(5);
        list.addToHead(4);
        list.addToTail(3);
        // list.removeHead();
        // list.removeTail();
        list.displayAll();
    }
}
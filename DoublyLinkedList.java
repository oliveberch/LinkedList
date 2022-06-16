import java.util.*;

class Node {
    int data;
    Node prev;
    Node next;

    Node(int d) {
        data = d;
        prev = null;
        next = null;
    }
}

public class DoublyLinkedList {
    // Function to add a node at the begining of Doubly Linked List
    public void addToFirst(Node head, Node node) {
        node.prev = null;
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
    }

    // Function to insert a node at the end of Doubly LinkedList
    public void addToTheLast(Node head, Node node) {
        if (head == null) {
            node.prev = null;
            head = node;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = node;
        node.prev = last;
    }

    // Function to insert a node in Doubly LinkedList after value
    public void addBeforeVal(Node head, Node node, int key) {
        Node nextN = head;
        while (nextN.data != key) {
            nextN = nextN.next;
        }
        if (nextN.data == key) {
            node.prev = nextN.prev;
            node.next = nextN;
            nextN.prev = node;
            nextN.prev.next = node;
            return;
        }
        System.out.println("Entered value not found in list");
    }

    // Function to insert a node in the middle of DoublyLinkedList after value
    public void addAfterVal(Node head, Node node, int key) {
        Node prevN = head;
        while (prevN.data != key) {
            prevN = prevN.next;
        }
        if (prevN.data == key) {
            node.next = prevN.next;
            node.prev = prevN;
            prevN.next = node;
            return;
        }
        System.out.println("Entered value not found in list");
    }

    // Single function to take key and delete a node at given position from DoblyLinkedList
    // P.S.: This function deletes only first occurence of a given key
    public void delNode(Node head, int key) {
        Node del = head;
        while (del.data != key) {
            del = del.next;
        }
        if (del.data == key) {
            if (head == null || del == null) {
                return;
            }
            if (head == del) {
                head = del.next;
            }
            if (del.next != null) {
                del.next.prev = del.prev;
            }
            if (del.prev != null) {
                del.prev.next = del.next;
            }
            return;
        }
        System.out.println("Node to be deleted not found in list.");
    }

    // Function to display DoublyLinkkedList
    public void display(Node head) {
        Node travel = head;
        while (travel.next != null) {
            System.out.println(travel.data + ", ");
        }
    }

    // Function to reverse Doubly LinkedList
    public void revDLL(Node head) {
        Node travel = head;
        Node temp;
        while (travel.next != null) {
            temp = travel.prev;
            travel.prev = travel.next;
            travel.next = temp;
        }
        head = travel;
    }
}
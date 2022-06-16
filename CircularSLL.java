import java.util.*;
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class CircularSLL {
    // Function to add to an empty list
    public void addToEmpty(Node last, Node New) {
        if (last != null) {
            return;
        }
        last = New;
        New.next = last;
    }

    // Function to add a node at the begining of Circular Linked List
    public void addToFirst(Node last, Node node) {
        if (last == null) {
            addToEmpty(last, node);
        }
        node.next = last.next;
        last.next = node;
    }

    // Function to insert a node at the end of Circular LinkedList
    public void addToTheLast(Node last, Node node) {
        if (last == null) {
            addToEmpty(last, node);
        }
        node.next = last.next;
        last.next = node;
        last = node;
    }

    // Function to insert a node in the middle of Circular LinkedList before value
    public void addBeforeVal(Node last, Node node, int key) {
        Node travel = last.next;
        Node prev = last;
        do {
            if (travel.data == key) {
                node.next = travel;
                prev.next = node;
                if (prev == last) {
                    last = node;
                }
            }
            prev = travel;
            travel = travel.next;
        } while (travel != last.next);
        System.out.print("Item not found in list");
    }

    // Function to insert a node in the middle of Circular LinkedList after value
    public void addAfterVal(Node last, Node node, int key) {
        Node travel = last.next;
        do {
            if (travel.data == key) {
                node.next = travel.next;
                travel.next = node;
                if (travel == last) {
                    last = node;
                }
            }
            travel = travel.next;
        } while (travel != last.next);
        System.out.print("Item not found in list");
    }

    // Function to delete a node from Circular LinkedList
    // Designing a single function to take key as input and delete node at any give
    // position in CLL
    // P.S.: This function deletes only first occurence of a given key
    public void delNode(Node head, int key) {
        if(head==null){
            return;
        }
        Node travel=head,prev=head;
        //Iterte over list
        while(travel.data!=key){
            //Check weather key is even present in list or not
            if(travel.next==head){
                System.out.printf("\nGiven node not found");
                return;
            }
            prev=travel;
            travel=travel.next;
        }
        //Case 1: Head node is sole node and key
        if(travel==head&&travel.next==head){
            head=null;
        }
        //Case 2:If key is at head node
        if(travel==head){
            prev=head;
            while(prev.next!=head) {prev=prev.next;}
            head=travel.next;
            prev.next=head;
        }
        //Case 3:If node is last node
        else if(travel.next==head){
            prev.next=head;
        }
        //Case 4:If node in middle
        else{
            prev.next=travel.next;
        }
    }

    // Function to display Circular Linnked List
    static void printList(Node head) {
        Node travel = head;
        if (head != null) {
            do {
                System.out.print(travel.data + " ");
                travel = travel.next;
            } while (travel != head);
            System.out.println();
        }
    }
}
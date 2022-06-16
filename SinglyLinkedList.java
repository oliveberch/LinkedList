import java.util.*;
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}
public class SinglyLinkedList {
    Node head;
    //Function to insert a node at the front of LinkedList
    public void addToFirst(Node head,Node node){
        if (head == null) {
            head = node;
        }
        else
        {
            node.next=head;
            head=node;
        }
    }
    //Function to insert a node at the end of LinkedList
    public void addToTheLast(Node head,Node node) {
        if (head == null) {
            head = node;
        }
        else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;           
        }
    }
    //Function to insert a node in the middle of LinkedList by position
    public void addAtPos(Node head,Node node,int pos){
        if (head == null) {
            head = node;
        }
        else{
            Node prev=head;
            for(int in=0;in<pos-1;in++){
                prev=prev.next;
            }
            node.next=prev.next;
            prev.next=node;
        }
    }
    //Function to insert a node in the middle of LinkedList after value
    public void addAfterVal(Node head,Node node,int key){
        Node temp=head;
        Node prev=temp;
        while(temp!=null||temp.data!=key){
            prev=temp;
            temp=temp.next;
        }
        node.next=prev.next;
        prev.next=node;
    }
    //Function to delete a node at the front of LinkedList
    public void delFirst(Node head){
        head=head.next;
    }
    //Function to delete a node at the end of LinkedList
    public void delLast(Node head){
        Node prev=head;
        if (prev == null)
            return;
        if (prev.next == null)
            return;
        while(prev.next.next!=null){
            prev=prev.next;
        }
        prev.next=null;
    }
    //Function to delete a node in the middle of LinkedList by position
    public void delByPos(Node head,Node node,int pos){
        if (head == null) {
            return;
        }
        else{
            Node prev=head;
            for(int in=0;in<pos-1;in++){
                prev=prev.next;
            }
            if(prev.next==null){
                return;
            }
            else{
                prev.next=prev.next.next;
            }
        }
    }
    //Function to delete a node in the middle of LinkedList after value
    public void delAfterVal(Node head,Node node,int key){
        Node temp=head;
        Node prev=temp;
        while(temp!=null||temp.data!=key){
            prev=temp;
            temp=temp.next;
        }
        prev.next=prev.next.next;
    }

    static void display(Node head)
    {
        Node disp=head;
        while(disp.next != null){
            System.out.print(disp.data+" ");
            disp=disp.next;
        }
        System.out.print(disp.data);
    }
    //Driver Method
    public static void main(String args[]) {
        int value;
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            SinglyLinkedList llist = new SinglyLinkedList();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head,head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(head,new Node(a));
            }	
            display(llist.head);
            System.out.println();
            t--;
        }
    }
}
 
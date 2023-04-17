import java.util.*;
import java.io.*;

public class Main
{
  public static void main (String[]args)
  {
    Scanner sc = new Scanner (System.in);
    int N = sc.nextInt ();
    LinkedList llist = new LinkedList ();
    for (int i = 0; i < N; i++)
      {
	llist.push (sc.nextInt ());
      }
    llist.getMiddle ();
  }
}

class LinkedList
{

  Node head;
  class Node
  {
    int data;
    Node next;
      Node (int d)
    {
      data = d;
      next = null;
    }
  }

  void getMiddle ()
  {
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null)
      {
	fast = fast.next.next;
	slow = slow.next;
      }
    System.out.println ("Middle element:" + slow.data);
  }

  public void push (int new_data)
  {
    Node new_node = new Node (new_data);
    new_node.next = head;
    head = new_node;
  }

}

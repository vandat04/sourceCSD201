/*
 * Implement by FunnyCode
 * 
 */

package LinkedList;

import org.w3c.dom.Node;

public class SinglyLinkedList {

   private ListNode head;

   private static class ListNode {
      private int data; 
      private ListNode next; 

      public ListNode(int data) {
         this.data = data;
         this.next = null;
      }
   }

   public void display() {
      ListNode current = head;
      while (current != null) {
         System.out.print(current.data + " --> ");
         current = current.next;
      }
      System.out.print("null");
      System.out.println();
   }

   public int length() {
      if (head == null) {
         return 0;
      }
      int count = 0;
      ListNode current = head;
      while (current != null) {
         count++;
         current = current.next;
      }
      return count;
   }

   public void insertFirst(int value) {
      ListNode newNode = new ListNode(value);
      newNode.next = head;
      head = newNode;
   }

   public void insert(int position, int value) {
      ListNode node = new ListNode(value);

      if (position == 1) {
         node.next = head;
         head = node;
      } else {
         ListNode previous = head;
         int count = 1; 
         while (count < position - 1) {
            previous = previous.next;
            count++;
         }

         ListNode current = previous.next;
         previous.next = node;
         node.next = current;
      }

   }

   public void insertLast(int value) {
      ListNode newNode = new ListNode(value);
      if (head == null) {
         head = newNode;
         return;
      }
      ListNode current = head;
      while (null != current.next) {
         current = current.next;
      }
      current.next = newNode;
   }

   public ListNode deleteFirst() {
      if (head == null) {
         return null;
      }
      ListNode temp = head;
      head = head.next;
      temp.next = null;
      return temp;
   }

   public void delete(int position) {
      if (position == 1) {
         head = head.next;
      } else {
         ListNode previous = head;
         int count = 1;
         while (count < position - 1) {
            previous = previous.next;
            count++;
         }

         ListNode current = previous.next;
         previous.next = current.next;
      }
   }

   public ListNode deleteLast() {
      if (head == null) {
         return head;
      }

      if (head.next == null) {
         ListNode temp = head;
         head = head.next;
         return temp;
      }

      ListNode current = head;
      ListNode previous = null;

      while (current.next != null) {
         previous = current;
         current = current.next;
      }
      previous.next = null;
      return current;
   }

   public boolean find(int searchKey) {
      if (head == null) {
         return false;
      }

      ListNode current = head;
      while (current != null) {
         if (current.data == searchKey) {
            return true;
         }
         current = current.next;
      }
      return false;
   }

   public ListNode reverse() {
      if (head == null) {
         return null;
      }

      ListNode current = head;
      ListNode previous = null;
      ListNode next = null;

      while (current != null) {
         next = current.next;
         current.next = previous;
         previous = current;
         current = next;
      }
      return previous;
   }
   public int findPosition(ListNode nodeToFind) {
      if (head == null || nodeToFind == null) {
          return -1; 
      }
  
      ListNode current = head;
      int position = 1;
  
      while (current != null) {
          if (current == nodeToFind) {
              return position;
          }
          current = current.next;
          position++;
      }
  
      return -1; 
  }
  public Node findMaxNode(){
       if(head == null){
           return null;
       }
       ListNode maxNode = head;
       ListNode current = head.next;
       while(current != null){
           if(current.data > maxNode.data ){
               maxNode = current;
           }
           current = current.next;
       }
       return maxNode;
       
   }

   public ListNode getNodeAtPosition(int position) {
      if (head == null || position <= 0) {
          return null; 
      }
      ListNode current = head;
      int count = 1;
      while (current != null) {
          if (count == position) {
              return current; 
          }
          current = current.next;
          count++;
      }
      return null; 
  }
  void sortByPositionToAndEnd(int u, int v) {
   if (u > v || u < 0) {   
       return;
   }
   
   ListNode pi = head;
   int i = 1;
   while (pi != null && i < u) {
       pi = pi.next;
       i++;
   }
   while (pi != null && i < v) {
       ListNode pj = pi.next;
       int j = i + 1;
       
       while (pj != null && j <= v) {
           if (pi.data.color > pj.data.color) { // Đoạn này nhớ thêm key cần so sánh
               Bottle temp = pi.data;
               pi.data = pj.data;
               pj.data = temp;
           }
           pj = pj.next;
           j++;
       }
       
       pi = pi.next;
       i++;
   }
}
  

   public ListNode getMiddleNode() {
      if (head == null) {
         return null;
      }
      ListNode slowPtr = head;
      ListNode fastPtr = head;

      while (fastPtr != null && fastPtr.next != null) {
         slowPtr = slowPtr.next;
         fastPtr = fastPtr.next.next;
      }
      return slowPtr;
   }

   public ListNode getNthNodeFromEnd(int n) {
      if (head == null) {
         return null;
      }

      if (n <= 0) {
         throw new IllegalArgumentException("Invalid value: n = " + n);
      }

      ListNode mainPtr = head;
      ListNode refPtr = head;

      int count = 0;

      while (count < n) {
         if (refPtr == null) {
            throw new IllegalArgumentException(n + " is greater than the number of nodes in list");
         }
         refPtr = refPtr.next;
         count++;
      }

      while (refPtr != null) {
         refPtr = refPtr.next;
         mainPtr = mainPtr.next;
      }
      return mainPtr;
   }

   public ListNode insertInSortedList(int value) {
      ListNode newNode = new ListNode(value);

      if (head == null) {
         return newNode;
      }

      ListNode current = head;
      ListNode temp = null;

      while (current != null && current.data < newNode.data) {
         temp = current;
         current = current.next;
      }

      newNode.next = current;
      temp.next = newNode;
      return head;
   }

   public void deleteNode(int key) {
      ListNode current = head;
      ListNode temp = null;

      if (current != null && current.data == key) {
         head = current.next;
         return;
      }

      while (current != null && current.data != key) {
         temp = current;
         current = current.next;
      }

      if (current == null) {
         return;
      }

      temp.next = current.next;
   }

   public boolean containsLoop() {
      ListNode fastPtr = head;
      ListNode slowPtr = head;

      while (fastPtr != null && fastPtr.next != null) {
         fastPtr = fastPtr.next.next;
         slowPtr = slowPtr.next;

         if (fastPtr == slowPtr) {
            return true;
         }
      }
      return false;
   }

   public ListNode startNodeInALoop() {
      ListNode fastPtr = head;
      ListNode slowPtr = head;

      while (fastPtr != null && fastPtr.next != null) {
         fastPtr = fastPtr.next.next;
         slowPtr = slowPtr.next;

         if (fastPtr == slowPtr) {
            return getStartingNode(slowPtr);
         }
      }
      return null;
   }

   private ListNode getStartingNode(ListNode slowPtr) {
      ListNode temp = head;
      while (temp != slowPtr) {
         temp = temp.next;
         slowPtr = slowPtr.next;
      }
      return temp; 
   }

   public void removeLoop() {
      ListNode fastPtr = head;
      ListNode slowPtr = head;

      while (fastPtr != null && fastPtr.next != null) {
         fastPtr = fastPtr.next.next;
         slowPtr = slowPtr.next;

         if (fastPtr == slowPtr) {
            removeLoop(slowPtr);
            return;
         }
      }
   }

   private void removeLoop(ListNode slowPtr) {
      ListNode temp = head;
      while (temp.next != slowPtr.next) {
         temp = temp.next;
         slowPtr = slowPtr.next;
      }
      slowPtr.next = null;
   }

   public void createALoopInLinkedList() {
      ListNode first = new ListNode(1);
      ListNode second = new ListNode(2);
      ListNode third = new ListNode(3);
      ListNode fourth = new ListNode(4);
      ListNode fifth = new ListNode(5);
      ListNode sixth = new ListNode(6);

      head = first;
      first.next = second;
      second.next = third;
      third.next = fourth;
      fourth.next = fifth;
      fifth.next = sixth;
      sixth.next = third;
   }

   public static ListNode merge(ListNode a, ListNode b) {
      ListNode dummy = new ListNode(0);
      ListNode tail = dummy;
      while (a != null && b != null) {
         if (a.data <= b.data) {
            tail.next = a;
            a = a.next;
         } else {
            tail.next = b;
            b = b.next;
         }
         tail = tail.next;
      }

      if (a == null) {
         tail.next = b;
      } else {
         tail.next = a;
      }

      return dummy.next;
   }
   public void sortNodes(int fromPosition, int toPosition) {
      if (head == null || fromPosition >= toPosition) {
          return; // Danh sách rỗng hoặc không có gì để sắp xếp
      }
  
      ListNode current = head;
      ListNode prev = null;
      ListNode start = null;
      ListNode end = null;
  
      // Di chuyển đến vị trí bắt đầu sắp xếp
      int count = 1;
      while (current != null && count < fromPosition) {
          prev = current;
          current = current.next;
          count++;
      }
  
      start = current; // start là node bắt đầu sắp xếp từ vị trí fromPosition
  
      // Di chuyển đến vị trí kết thúc sắp xếp
      while (current != null && count < toPosition) {
          current = current.next;
          count++;
      }
  
      end = current; // end là node kết thúc sắp xếp tại vị trí toPosition
  
      // Nếu không tìm thấy đủ số lượng node cần sắp xếp
      if (start == null || end == null || start == end) {
          return;
      }
  
      // Sắp xếp danh sách từ start đến end bằng Bubble Sort
      bubbleSort(start, end, fromPosition, toPosition);
  }
  
  private void bubbleSort(ListNode start, ListNode end, int fromPosition, int toPosition) {
      boolean swapped;
      ListNode ptr1;
      ListNode lptr = null;
  
      if (start == null) {
          return;
      }
  
      do {
          swapped = false;
          ptr1 = start;
  
          while (ptr1.next != end) {
              if (ptr1.data > ptr1.next.data) {
                  int temp = ptr1.data;
                  ptr1.data = ptr1.next.data;
                  ptr1.next.data = temp;
                  swapped = true;
              }
              ptr1 = ptr1.next;
          }
          lptr = ptr1;
      } while (swapped);
  
      if (fromPosition == 1) {
          head = start;
      } else {
          prev.next = start;
      }
  
      // Đưa con trỏ đến cuối danh sách đã sắp xếp
      while (ptr1.next != null) {
          ptr1 = ptr1.next;
      }
  
      // Nối lại phần còn lại của danh sách
      ptr1.next = end.next;
  }

  Object searchNode(String type){
      Node tmp = head;
      while(tmp != null){
         if(tmp.info.getType().equals(type))
            return tmp.info;
         tmp = tmp.next;
      }
      return null;
   }
  

}
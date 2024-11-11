/*
 * Implement by FunnyCode 
 * Ưu đãi Combo Kì 3: 300k (WED - DBI - JDP) 
 * Làm chủ Kì 4 với Combo Kì 4 (JavaWeb + MAS + JPD123) : 1000k 
 */

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

   private TreeNode root;

   private class TreeNode {
      private int data;
      private TreeNode left;
      private TreeNode right;

      public TreeNode(int data) {
         this.data = data;
      }
   }

   public void insert(int value) {
      root = insert(root, value);
   }

   public TreeNode insert(TreeNode root, int value) {
      if (root == null) {
         root = new TreeNode(value);
         return root;
      }
      // Nếu key là String thì dùng compareTo():
      if (value < root.info) { // str1.compareTo(str2) < 0
         root.left = insert(root.left, value);
      } else if (value > root.info) { // str1.compareTo(str2) < 0
         root.right = insert(root.right, value);
      }
      return root;
   }

   public void inOrder() {
      inOrder(root);
   }

   public void inOrder(TreeNode root) {
      if (root == null) {
         return;
      }
      inOrder(root.left);
      System.out.print(root.data + " ");
      inOrder(root.right);
   }

   private int countNodeBy(BSTNode node) {
      if (node == null)
         return 0;
      int count = (node.data.age < 25) ? 1 : 0; // Sửa lại data.age theo cái điều kiện
      return count + countNodeBy(node.left) + countNodeBy(node.right);
   }

   public TreeNode search(int key) {
      return search(root, key);
      /* Search trả về j đó
      TreeNode node = search(root, phone);
        return (node != null) ? node.data : null;
      */
   }

   public TreeNode search(TreeNode root, int key) {
      if (root == null || root.data == key) {
         return root;
      }

      if (key < root.data) {
         return search(root.left, key);
      } else {
         return search(root.right, key);
      }
      /** Khi nó tìm kiếm một phần của tên thì dùng hàm này thay từ if(key<root.data)
       * // Tìm kiếm đệ quy trong cả cây con trái và cây con phải
       * TreeNode leftResult = search(root.left, name);
       * if (leftResult != null) {
       * return leftResult; // Nếu tìm thấy ở cây con trái, trả về kết quả
       * }
       * return search(root.right, name); // Nếu không, tiếp tục tìm ở cây con phải
       */

   }

   public void delete(int key) {
      root = delete(root, key);
   }

   private TreeNode delete(TreeNode root, int key) {
      if (root == null) {
         return root;
      }

      if (key < root.data) {
         root.left = delete(root.left, key);
      } else if (key > root.data) {
         root.right = delete(root.right, key);
      } else {
         if (root.left == null) {
            return root.right;
         } else if (root.right == null) {
            return root.left;
         }

         root.data = minValue(root.right);

         root.right = delete(root.right, root.data);
      }

      return root;
   }

   private int minValue(TreeNode root) {
      int minValue = root.data;
      while (root.left != null) {
         minValue = root.left.data;
         root = root.left;
      }
      return minValue;
   }

   private int maxValue(TreeNode root) {
      int maxValue = root.data;
      while (root.right != null) {
         maxValue = root.right.data;
         root = root.right;
      }
      return maxValue;
   }

   public void update(int key, int newValue) {
      root = update(root, key, newValue);
   }

   private TreeNode update(TreeNode root, int key, int newValue) {
      if (root == null) {
         return root;
      }

      if (key < root.data) {
         root.left = update(root.left, key, newValue);
      } else if (key > root.data) {
         root.right = update(root.right, key, newValue);
      } else {
         root.data = newValue;
      }

      return root;
   }

   public void bfs() {
      bfs(root);
   }

   public int height() {
      return height(root);
   }

   private int height(BSTNode node) {
      if (node == null)
         return 0;
      int leftHeight = height(node.left);
      int rightHeight = height(node.right);
      return Math.max(leftHeight, rightHeight) + 1;
   }

   // Các bạn dùng queue có trong source hoặc import thư viện vào đều được
   private void bfs(TreeNode root) {
      if (root == null) {
         return;
      }

      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);

      while (!queue.isEmpty()) {
         TreeNode currentNode = queue.poll();
         System.out.print(currentNode.data + " ");

         if (currentNode.left != null) {
            queue.add(currentNode.left);
         }

         if (currentNode.right != null) {
            queue.add(currentNode.right);
         }
      }
   }

   // check balance
   public boolean checkBalance() {
      return checkBalanceRec(root) != -1;
   }

   private int checkBalanceRec(TreeNode root) {
      if (root == null)
         return 0;
      int leftHeight = checkBalanceRec(root.left);
      int rightHeight = checkBalanceRec(root.right);
      if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
         return -1;
      }
      return Math.max(leftHeight, rightHeight) + 1;
   }

   // Tìm kiếm đối tượng lớn nhất dựa trên gì đó

   // ví dụ ở đây là tìm sinh viên có semester lớn nhất
   // public Student findMaxSemester() {
   // return findMaxSemesterRec(root, null);
   // }

   // private Student findMaxSemesterRec(Node root, Student maxStudent) {
   // if (root == null) return maxStudent;
   // if (maxStudent == null || root.student.getSemester() >
   // maxStudent.getSemester()) {
   // maxStudent = root.student;
   // }
   // maxStudent = findMaxSemesterRec(root.left, maxStudent);
   // return findMaxSemesterRec(root.right, maxStudent);
   // }

   // còn tìm min thì
   // public Student findMinSemester() {
   // return findMinSemesterRec(root, null);
   // }

   // private Student findMinSemesterRec(Node root, Student minStudent) {
   // if (root == null) return minStudent;
   // if (minStudent == null || root.student.getSemester() <
   // minStudent.getSemester()) {
   // minStudent = root.student;
   // }
   // minStudent = findMinSemesterRec(root.left, minStudent);
   // return findMinSemesterRec(root.right, minStudent);
   // }
   
   /* xóa node với tuổi
   public void deleteStudentsWithAge(int age) {
        int currentYear = 2024; // Change to current year if needed
        root = deleteStudentsWithAge(root, currentYear - age);
    }

    public TreeNode deleteStudentsWithAge(TreeNode node, int targetYear) {
        if (node == null)
            return null;

        node.left = deleteStudentsWithAge(node.left, targetYear);
        node.right = deleteStudentsWithAge(node.right, targetYear);

        if (node.data.yob == targetYear) {
            if (node.left == null)
                return node.right;
            if (node.right == null)
                return node.left;

            Student minNode = minValue(node.right);
            node.data = minNode;
            node.right = delete(node.right, minNode.id);
        }
        return node;
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    private TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.data.id) {
            root.left = delete(root.left, key);
        } else if (key > root.data.id) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = minValue(root.right);

            root.right = delete(root.right, root.data.id);
        }

        return root;
    }

    private Student minValue(TreeNode root) {
        Student minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }
   */
}
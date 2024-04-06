import java.util.Objects;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

public class LinkerListy {
    private Node head;


    public void removeAfter(Node node) {
        if (node == null || node.next == null) {
            return;
        }
        node.next = node.next.next;
    }
    public void removeDuplicate(Node startNode, int key) {
        // If the list is empty, return
        if (startNode == null) {
            return;
        }

        while (startNode != null && startNode.data == key) {
            startNode = startNode.next;
        }

        // Now startNode points to the first non-duplicate node
        Node current = startNode;

        // Traverse the list and remove duplicates
        while (current != null && current.next != null) {
            if (current.next.data == key) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }
    public int max(Node startNode) {
        if (startNode == null) {
            return 0;
        }

        int maxVal = startNode.data;

        // update Maxval
        Node current = startNode.next;
        while (current != null) {
            if (current.data > maxVal) {
                maxVal = current.data;
            }
            current = current.next;
        }

        return maxVal;
    }
    public LinkerListy copy(Node startNode) {
        LinkerListy newList = new LinkerListy();
        Node current = startNode;

        // Traverse the original list and add each node's data to the new list
        while (current != null) {
            newList.addNode(current.data);
            current = current.next;
        }
        return newList;
    }

    // Print to Console
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    // Append Node to End of Linked List
    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    // test string
    public static void main(String[] args) {
        LinkerListy list = new LinkerListy();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);

        System.out.println("Original linked list:");
        list.display();

        // Copy Test
        Node startNode = list.head;
        LinkerListy newList = list.copy(startNode);

        System.out.println("\nNew linked list (copy):");
        newList.display();

        // Modify test
        list.addNode(5);

        Node node3 = list.head.next.next;
        list.removeAfter(node3);

        System.out.println("\nLinked list after removal + AddNode:");
        list.display();

        // Dupe Test
        int key = 5;
        list.removeDuplicate(startNode, key);

        System.out.println("\nLinked list after removing nodes with data equal to \"" + key + "\":");
        list.display();

        int max = list.max(list.head);
        System.out.println("\nMaximum item in the linked list: " + max);
    }
}
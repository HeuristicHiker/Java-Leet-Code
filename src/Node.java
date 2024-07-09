public class Node {
    int val;
    Node next;

    public static void main(String[] args) {
        int[] test1 = new int[]{4, 3};
        Node l1 = new Node(20);
        l1.AddNodes(test1);

        int[] test2 = new int[]{6, 4};
        Node l2 = new Node(25);
        l2.AddNodes(test2);

//        PrintNodes(l1);
//        System.out.println("---");
        Node headNode = SumNodes(l1, l2);
        PrintNodes(headNode);
    }

    public static Node SumNodes(Node l1, Node l2) {
        Node head = new Node(0);
        Node tail = head;

        int carry = 0;

        while(l1 != null || l2 != null || carry != 0) {
            // initiate the new sum node
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            int valSum = val1 + val2 + carry;
            int digit = valSum % 10;
            carry = valSum / 10;
            Node newNode = new Node(digit);

            // set it to next
            tail.next = newNode;
            tail = tail.next;

            // increment where possible
            l1 = (l1.next != null) ? l1.next : null;
            l2 = (l2.next != null) ? l2.next : null;
        }
        Node result = head.next;
        head.next = null;

        return result;
    }

    public static void PrintNodes(Node headNode) {
        while(headNode != null) {
            System.out.println("Node value is: " + headNode.val);
            headNode = headNode.next;
        }
    }

    public void AddNodes(int nodes) {
        Node headNode = this;
        for(int i = 0; i <= nodes; i++) {
            Node nextNode = new Node(i);
            headNode.next = nextNode;
            headNode = nextNode;
        }
    }

    public void AddNodes(int[] values) {
        Node headNode = this;
        for(int i = 0; i < values.length; i++) {
            Node nextNode = new Node(values[i]);
            headNode.next = nextNode;
            headNode = nextNode;
        }
    }

    Node() {

    }

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node next) {
        this.val = val; this.next = next;
    }


}

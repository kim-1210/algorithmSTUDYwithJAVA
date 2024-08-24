package nhn_coding_test;

interface List {
    public void insert(int value);

    public int getFirst();

    public int removeFirst();

    public boolean isEmpty();
}

public class OrderedLinkedList implements List {
    class Node {
        int value;
        Node next;

        Node(Integer value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node cur;

    public OrderedLinkedList() {
        this.cur = null;
    }

    @Override
    public void insert(int value) {
        Node newNode = new Node(value);
        if (this.cur == null) {
            cur = newNode;
        } else if (this.cur.value < value) {
            Node first = this.cur;
            while (true) {
                Node pre = this.cur;
                this.cur = this.cur.next;
                if(this.cur == null){
                    cur = newNode;
                    pre.next = cur;
                    break;
                } else if (this.cur.value > value) {
                    pre.next = newNode;
                    newNode.next = this.cur;
                    break;
                }
            }
            this.cur = first;
        } else {
            newNode.next = cur;
            cur = newNode;
        }
    }

    @Override
    public int getFirst() {
        if (this.cur == null) {
            return Integer.MIN_VALUE;
        } else {
            return this.cur.value;
        }
    }

    @Override
    public int removeFirst() {
        if (this.cur == null) {
            return Integer.MIN_VALUE;
        } else {
            int re = this.cur.value;
            this.cur = this.cur.next;
            return re;
        }
    }

    @Override
    public boolean isEmpty() {
        boolean check = (this.cur != null) ? false : true;
        return check;
    }

    public static void main(String[] args) {
        OrderedLinkedList list = new OrderedLinkedList();
        System.out.println("isEmpty : " + list.isEmpty());
        list.insert(10);
        list.insert(5);
        System.out.println("getFirst : " + list.getFirst());
        list.insert(7);
        list.removeFirst();
        System.out.println("isEmpty : " + list.isEmpty());
        System.out.println("getFirst : " + list.getFirst());
        list.insert(12);
        list.insert(3);
        System.out.println("getFirst : " + list.getFirst());
        list.removeFirst();
        System.out.println("getFirst : " + list.getFirst());
        list.removeFirst();
        System.out.println("getFirst : " + list.getFirst());
        list.removeFirst();
        System.out.println("getFirst : " + list.getFirst());
        list.removeFirst();
        System.out.println("isEmpty : " + list.isEmpty());
    }
}

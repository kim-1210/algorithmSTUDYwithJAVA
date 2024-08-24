package nhn_coding_test;

interface List<T> {
    public void insert(T value);

    public T getFirst();

    public T removeFirst();

    public boolean isEmpty();
}

class Student implements Comparable<Student> {
    String name;
    int id;
    public Student next;

    Student(String a, int b) {
        this.name = a;
        this.id = b;
        this.next = null;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public int compareTo(Student arg0) {
        throw new RuntimeException("");
    }
}

public class OrderedLinkedListT<T extends Comparable<T>> implements List<T> {

    private Student cur;
    int size;

    public OrderedLinkedListT() {
        this.cur = null;
        size = 0;
    }

    @Override
    public void insert(T value) {
        try {
            size++;
            Student newStu = (Student) value;
            if (this.cur == null) {
                this.cur = newStu;
            } else if (this.cur.getId() < newStu.getId()) {
                Student first = this.cur;
                while (true) {
                    Student pre = this.cur;
                    this.cur = this.cur.next;
                    if (this.cur == null) {
                        cur = newStu;
                        pre.next = cur;
                        break;
                    }else if (this.cur.getId() > newStu.getId()) {
                        pre.next = newStu;
                        newStu.next = this.cur;
                        break;
                    }
                }
                this.cur = first;
            } else {
                newStu.next = cur;
                cur = newStu;
            }
        } catch (ClassCastException e) {
            System.out.println("맞지않은 형의 형태");
        }
    }

    @Override
    public T getFirst() {
        if (size >= 1) {
            return (T) this.cur;
        } else {
            return null;
        }
    }

    @Override
    public T removeFirst() {
        if (size >= 1) {
            T get = (T) this.cur;
            this.cur = this.cur.next;
            return get;
        } else {
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        boolean check = (this.cur != null) ? false : true;
        return check;
    }

    public static void main(String[] args) {
        OrderedLinkedListT<Student> students = new OrderedLinkedListT<>();
        students.insert(new Student("s2", 2));
        students.insert(new Student("s3", 3));
        students.insert(new Student("s1", 1));
        System.out.println(students.removeFirst().getId());
        System.out.println(students.removeFirst().getId());
        System.out.println(students.removeFirst().getId());
    }
}
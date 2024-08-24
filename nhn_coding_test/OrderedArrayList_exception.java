package nhn_coding_test;

interface List {
    public void insert(int value);

    public int getFirst();

    public int removeFirst();

    public boolean isEmpty();
}

public class OrderedArrayList_exception implements List {
    int[] values;
    int[] nexts;
    int end;

    public static void main(String[] args) {
        OrderedArrayList_exception list = new OrderedArrayList_exception(5);
        list.insert(1);
        System.out.println("1을 넣었습니다.");
        list.insert(2);
        System.out.println("2를 넣었습니다.");
        list.insert(3);
        System.out.println("3을 넣었습니다.");
        list.insert(4);
        System.out.println("4를 넣었습니다.");
        list.insert(5);
        System.out.println("5를 넣었습니다.");
        try {
            list.insert(6);
        } catch (RuntimeException ignore) {
            System.out.println("공간이 부족해 6을 추가할 수 없습니다.");
        }
        System.out.println(list.removeFirst() + "을/를 제거하였습니다.");
        System.out.println(list.removeFirst() + "을/를 제거하였습니다.");
        System.out.println(list.removeFirst() + "을/를 제거하였습니다.");
        System.out.println(list.removeFirst() + "을/를 제거하였습니다.");
        System.out.println(list.removeFirst() + "을/를 제거하였습니다.");
        try {
            System.out.println(list.removeFirst() + "을/를 제거하였습니다.");
        } catch (RuntimeException ignore) {
            System.out.println("list에 제거할 요소가 없습니다.");
        }

    }

    public OrderedArrayList_exception(int n) {
        values = new int[n];
        end = 0;
    }

    @Override
    public void insert(int value) {
        if(end >= values.length){
            throw new RuntimeException();
        }
        end++;
        for (int i = 0; i < values.length; i++) {
            if (values[i] != 0 && values[i] > value) {
                for (int j = i; j < end; j++) {
                    int temp = values[j];
                    values[j] = value;
                    value = temp;
                }
                break;
            }
            if (values[i] == 0) {
                values[i] = value;
                break;
            }
        }
    }

    @Override
    public int getFirst() {
        return values[0];
    }

    @Override
    public int removeFirst() {
        if(end == 0){
            throw new RuntimeException();
        }
        int re_get = values[0];
        for (int i = 1; i < end; i++) {
            values[i - 1] = values[i];
        }
        values[end - 1] = 0;
        end--;
        return re_get;
    }

    @Override
    public boolean isEmpty() {
        if (end == 0) {
            return true;
        } else {
            return false;
        }
    }
}
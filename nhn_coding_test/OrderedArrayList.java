package nhn_coding_test;

interface List {
    public void insert(int value);

    public int getFirst();

    public int removeFirst();

    public boolean isEmpty();
}

public class OrderedArrayList implements List {
    int[] values;
    int[] nexts;
    int end;

    public static void main(String[] args) {
        OrderedArrayList list = new OrderedArrayList(10);
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
        System.out.println("isEmpty : " + list.isEmpty());
    }

    public OrderedArrayList(int n) {
        values = new int[n];
        end = 0;
    }

    @Override
    public void insert(int value) {
        end++;
        for(int i=0;i<values.length; i++){
            if(values[i] != 0 && values[i] > value){
                for(int j=i;j<end; j++){
                    int temp = values[j];
                    values[j] = value;
                    value = temp;
                }
                break;
            }
            if(values[i] == 0){
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
        for(int i=1; i<end; i++){
            values[i - 1] = values[i];
        }
        values[end - 1] = 0;
        end--;
        return values[0];
    }

    @Override
    public boolean isEmpty() {
        if(end == 0){
            return true;
        }
        else{
            return false;
        }
    }
}

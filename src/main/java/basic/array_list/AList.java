package basic.array_list;

import java.util.Arrays;

public class AList<T> {
    private int capacity;
    private int position = 0;
    private Object[] values;

    public AList(int capacity) {
        this.capacity = capacity;
        this.values = new Object[this.capacity];
    }

    public void add(T value) {
        if (needResize()) {
            resize();
        }
        this.values[this.position++]=value;
    }

    private boolean needResize() {
        return this.position==this.capacity;
    }

    private void resize() {
        int newCapacity=capacity*2;
        Object[] newValues = new Object[newCapacity];
        System.arraycopy(this.values,0, newValues,0, this.values.length);
        this.capacity=newCapacity;
        this.values=newValues;
    }

    public T get(int index) {
        return index<position ? (T)this.values[index] : null;
    }

    public int size() {
        return this.values.length;
    }

    @Override
    public boolean equals(Object obj) {
        AList o2 = (AList)obj;
        return this.capacity==o2.capacity
                && this.position==o2.position
                && Arrays.equals(this.values, o2.values);
    }
}

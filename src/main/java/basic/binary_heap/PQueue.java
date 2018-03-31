package basic.binary_heap;

public class PQueue {
    private int capacity;
    private int[] values;
    private int position = 1;

    public PQueue (int capacity) {
        this.capacity = capacity;
        this.values = new int[this.capacity];
        this.values[0] = Integer.MIN_VALUE;
    }

    public void add(int value) {
        if (value>=peekMax()) {
            addToEnd(value);
        } else {
            addToMiddle(value);
        }
    }

    private void addToMiddle(int value) {
        int pos = findPos(value);
        shift(pos);
        this.values[pos] = value;
    }

    private int findPosBrute(int value) {
        for (int i = 1; i < position; i++) {
            if (value < values[i]) {
                return i;
            }
        }
        return 1;
    }

    private int findPos(int value) {
        int start = 1;
        int end = position-1;
        int mid = 0;
        while (true) {
            mid = (start + end) / 2;
            if (values[mid-1] < value && value <= values[mid]) {
                break;
            } else if (value < values[mid]) {
                end = mid;
            } else if (value > values[mid]) {
                start = mid;
            }
        }
        return mid;
    }

    private void shift(int pos) {
        for (int i = position; i > pos; i--) {
            values[i] = values[i-1];
        }
        position++;
    }

    private void addToEnd(int value) {
        this.values[position++] = value;
    }


    public int peekMax() {
        return this.values[position-1];
    }

    public int removeMax() {
        return this.values[--position];
    }
}

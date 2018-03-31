package basic.array_list;

import java.util.*;

//Solution_FixedLengthStream {
public class Solution_FixedLengthStream {
    char[] values;
    int index = 0, size = 0, capacity;

    public Solution_FixedLengthStream(int capacity) {
        this.capacity = capacity;
        this.values = new char[capacity];
    }

    public void write(char c) {
        values[index++ % capacity] = c;
        size = (index < capacity) ? index : capacity;
    }

    public String read() {
        int start = index % capacity;
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < size; i++) {
            res.append(this.values[(start + i) % size]);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Solution_FixedLengthStream fixedLengthStream = new Solution_FixedLengthStream(Integer.parseInt(in.nextLine()));
        String input = in.nextLine();

        for (int i = 0; i < input.length(); i++) {
            fixedLengthStream.write(input.charAt(i));
        }

        System.out.print(fixedLengthStream.read());
    }
}
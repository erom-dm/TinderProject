package basic.binary_search;

public class StringlengthHistogram {

    public static void main(String[] args) {
        histogram("Lorem ipsum dolor sit amet");
    }

    public static void histogram(String input) {
        input = input.replace("  ", " ");
        String[] parts = input.split(" ");

        int max = parts[0].length();
        for (int i = 0; i < parts.length; ++i) {
            max = Math.max(max, parts[i].length());
        }

        int[] length = new int[max + 1];
        for (String part : parts) {
            length[part.length()]++;
        }

        int maxInArray = length[0];
        for (int elem : length) {
            maxInArray = Math.max(elem, maxInArray);
        }

        for (int j = maxInArray; j > 0; --j){
            for (int i = 0; i < length.length; ++i) {
                if (length[i] >= j) {
                    System.out.print("| ");
                }
            }
            System.out.println();
        }
    }

}

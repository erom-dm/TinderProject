package quizz;

public class Quizz4 {
    public static void printA() {
        System.out.println("A");
    }

    public static void printB() {
        System.out.println("B");
    }

    public static void main(String[] args) {
        printA();
        ((Quizz4)null).printB();
    }
}

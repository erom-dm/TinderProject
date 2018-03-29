package basic.jcf;

import java.util.*;

public class ArrayListSort2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        List<Node>list=new ArrayList<>();
        for (int i = 0; i <N ; i++) {
            list.add(new Node(i,scanner.nextInt()));
        }
        list.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {

                return o1.salary-o2.salary;
            }

        });

        for (Node node:list) {
            System.out.print(node.id+" ");
        }
    }
    public static class Node{
        public int id;
        public int salary;
        public Node(int id,int salary){
            this.id=id;
            this.salary=salary;
        }
    }
}

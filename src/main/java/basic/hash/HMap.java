package basic.hash;

import java.util.ArrayList;
import java.util.List;

public class HMap<T> {
    private int capacity = 10;
    ArrayList<ArrayList<T>> values = new ArrayList<ArrayList<T>>();
    ArrayList<ArrayList<Integer>> keys = new ArrayList<ArrayList<Integer>>();


    public HMap(){

        this.capacity = capacity;
        for (int i = 0; i < this.capacity; i++) {
            keys.add(new ArrayList<Integer>());
            values.add(new ArrayList<T>());
        }
    }

    private int hash(int key){
        return key % capacity;
    }

    private T get(int key){
        if (keys.get(hash(key)).indexOf(key) == -1){
            return null;
        }
        int index = keys.get(hash(key)).indexOf(key);
        return values.get(hash(key)).get(index);
    }

    private void put(int key, T value){
        ArrayList targetKeyList = keys.get(hash(key));
        if (targetKeyList.indexOf(key) == -1){
            targetKeyList.add(key);
            values.get(hash(key)).add(value);
        } else {
            values.get(hash(key)).remove(targetKeyList.indexOf(key));
            values.get(hash(key)).add(value);
        }
    }

    private void remove(int key){
        ArrayList targetKeyList = keys.get(hash(key));
        if (targetKeyList.indexOf(key) != -1){
            int index = targetKeyList.indexOf(key);
            targetKeyList.remove(index);
            values.get(hash(key)).remove(index);
        }
    }

    private boolean containsKey(int key){
        return keys.get(hash(key)).indexOf(key) == -1 ? false : true;
    }


    private List<Integer> get_k(int key) {
        return keys.get(hash(key));
    }

    private ArrayList<T> entryValue (){
        ArrayList<T> entry = new ArrayList<T>();
        for (int i = 0; i < values.size(); i++){
            for (int j = 0; j < values.get(i).size(); j++) {
                entry.add(values.get(i).get(j));
            }
        }
        return entry;
    }

    public static void main(String[] args) {
        HMap hmap = new HMap();
        hmap.put(1, "Hello");
        hmap.put(1, "Hey");
        hmap.put(15, "cat");
        hmap.put(2, "World,");
        hmap.put(22, "World!");
        hmap.put(3, "it's me!");
        hmap.put(3335587, "wow!");
        hmap.put(33, 89);
        hmap.remove(2);
        System.out.println(hmap.containsKey(16));
        ArrayList alist = hmap.entryValue();
        for (int i = 0; i < alist.size(); i++) {
            System.out.printf("%s ", alist.get(i));
        }
    }
}
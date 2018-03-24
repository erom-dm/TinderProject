package ua.com.danit;

import java.util.ArrayList;

public class MyArrayList extends ArrayList<Integer> {

    int counter = 0;

    @Override
    public int size() {
        return counter++;
    }
}

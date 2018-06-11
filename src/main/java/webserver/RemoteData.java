package webserver;

import webserver.entities.Item;

import java.util.ArrayList;
import java.util.List;

public class RemoteData {
    public List<Item> get() {
        return new ArrayList<Item>(){{
            add(new Item(1,"MacBook Pro", 1100));
            add(new Item(2,"Iphone 5S", 349));
            add(new Item(3,"IPad 4", 651));
            add(new Item(4,"Mouse", 0));
        }};
    }
}

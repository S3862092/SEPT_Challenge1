package com.sept.kairunleong.rest.dao;

import com.sept.kairunleong.rest.model.Item;
import com.sept.kairunleong.rest.model.Items;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDAO {
    private static Items list = new Items();

    static{
        list.getItemList().add(new Item("1", "Item1", "Item1 is a box", "../image/image1.jpg",12.0));
        list.getItemList().add(new Item("2", "Item2", "Item2 is a big box", "../image/image2.jpg",15.0));
        list.getItemList().add(new Item("3", "Item3", "Item1 is a bigger box", "../image/image3.jpg",20.0));
    }

    public static Items getAllItems(){
        return list;
    }

    public void addItem(Item item){
        list.getItemList().add(item);
    }
}

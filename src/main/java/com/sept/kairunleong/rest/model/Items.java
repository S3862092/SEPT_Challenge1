package com.sept.kairunleong.rest.model;

import java.util.ArrayList;
import java.util.List;

public class Items {
    private List<Item>itemList;

    public List<Item> getItemList(){
        if(itemList == null){
            itemList = new ArrayList<Item>();
        }
        return itemList;
    }

    public void setItemList(List<Item>itemList){
        this.itemList = itemList;
    }
}

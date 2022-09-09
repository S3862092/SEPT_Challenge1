package com.sept.kairunleong.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.ArrayList;

import com.sept.kairunleong.rest.model.Item;
import com.sept.kairunleong.rest.model.Items;
import com.sept.kairunleong.rest.dao.ItemDAO;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemDAO itemDao;

    //Create Item API
    @PostMapping(path = "", consumes = "application/json", produces = "application/json")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String createItem(@RequestBody Item item){
        itemDao.addItem(item);
        return "Item added successfully!";
    }

    //Get Item API
    @GetMapping(path = "/item/{id}", produces = "application/json")
    public Item getItem(@PathVariable String id){
        Item item = null;
        Items items = itemDao.getAllItems();
        List<Item> itemsList = items.getItemList();
        for(int i = 0; i < itemsList.size(); i++){
            if(itemsList.get(i).getId().equals(id)){
                System.out.println("ran");
                item = itemsList.get(i);
                i = itemsList.size();
            }
        }
        return item;
    }

    //Get Item List API
    @GetMapping(path = "/items", produces = "application/json")
    public Items getItems(){
        return itemDao.getAllItems();
    }

    //Update Item API
    @PutMapping("/updateItem")
    public String updateItems(@RequestBody Item item){
        String result = "Update Failed!";
        for(Item currItem : itemDao.getAllItems().getItemList()){
            if(currItem.getId().equals(item.getId())){
                currItem.setTitle(item.getTitle());
                currItem.setDesc(item.getDesc());
                currItem.setPrice(item.getPrice());
                currItem.setImagePath(item.getImagePath());
                result = "Update Successful!";
            }
        }
        return result;
    }

    //Delete Item API
    @DeleteMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable String id){
        String result = "Delete Failed!";
        Item item = null;
        Items items = itemDao.getAllItems();
        List<Item> itemsList = items.getItemList();
        for(int i = 0; i < itemsList.size(); i++){
            if(itemsList.get(i).getId().equals(id)){
                itemsList.remove(itemsList.get(i));
                result = "Delete Successful!";
            }
        }
        return result;
    }
}

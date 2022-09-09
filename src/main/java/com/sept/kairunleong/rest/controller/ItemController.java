package com.sept.kairunleong.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.ResponseStatus;

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

    //test...delete later
    @RequestMapping("/hello")
    public String helloWorld(){
        return "Hello from Spring Boot";
    }

    //Create Item API
    @PostMapping(path = "", consumes = "application/json", produces = "application/json")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String createItem(@RequestBody Item item){
        itemDao.addItem(item);
        return "Item added successfully!";
    }

    //Get Item API
    @GetMapping(path = "/item/item{id}", produces = "application/json")
    public Item getItem(){
        Items items = itemDao.getAllItems();

                /*
        for(int i = 0; i < itemDao.getAllItems(); i++){

        }*/
    }

    //Get Item List API
    @GetMapping(path = "/items", produces = "application/json")
    public Items getItems(){
        return itemDao.getAllItems();
    }

    //Update Item API

    //Delete Item API
}

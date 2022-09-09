package com.sept.kairunleong.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sept.kairunleong.rest.model.Item;
import com.sept.kairunleong.rest.model.Items;
import com.sept.kairunleong.rest.dao.ItemDAO;

@RestController
@RequestMapping(path = "/items")
public class ItemController {
    @Autowired
    private ItemDAO itemDao;

    @GetMapping(path="/", produces = "application/json")
    public Items getEmployees()
    {
        return ItemDAO.getAllItems();
    }
}

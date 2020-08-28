package com.example.itemservice.models.service;

import com.example.itemservice.models.Item;

import java.util.List;

public interface ItemService {
    public List<Item> findAll();
    public Item findbyId (Long id, Integer cantidad);
}

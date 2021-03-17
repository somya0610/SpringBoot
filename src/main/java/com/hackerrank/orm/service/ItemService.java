package com.hackerrank.orm.service;

import com.hackerrank.orm.model.Item;
import com.hackerrank.orm.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ItemService {
    @Autowired
    public ItemRepository itemRepository;

    public Item createItem(Item item) {
        Item createdItem = itemRepository.save(item);
        return createdItem;
    }

    public Item updateItem(Item item) {
        Item updatedItem = itemRepository.save(item);
        return updatedItem;
    }

    public void deleteItem(Item item) {
        itemRepository.delete(item);
    }

    public void deleteAllItem() {
        itemRepository.deleteAll();
    }

    public Item getItem(int itemId) {
        final Optional<Item> itemById = itemRepository.findById(itemId);
        if (itemById.isPresent())
            return itemById.get();
        return null;
    }

    public List<Item> getAllItems() {
        List<Item> items = itemRepository.findAll();
        return items;
    }
}

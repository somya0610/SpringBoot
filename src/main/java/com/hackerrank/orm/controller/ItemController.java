package com.hackerrank.orm.controller;

import com.hackerrank.orm.enums.ItemStatus;
import com.hackerrank.orm.model.Item;
import com.hackerrank.orm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@RestController
public class ItemController {
    @Autowired
    ItemService itemService;

    //1. insert POST

    @RequestMapping(value="/app/item", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        final Item itemById = itemService.getItem(item.getItemId());
        if (itemById == null) {
            Item itemCreated = itemService.createItem(item);
            return new ResponseEntity(itemCreated, HttpStatus.CREATED);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    //2. update PUT
    @RequestMapping(value="/app/item/{itemId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> updateItem(@PathVariable("itemId") int itemId, @RequestBody Item item){
        final Item itemById = itemService.getItem(itemId);
        if (itemById != null) {
            itemById.setItemName(item.getItemName());
            itemById.setItemBuyingPrice(item.getItemBuyingPrice());
            itemById.setItemLastModifiedByUser(item.getItemLastModifiedByUser());
            itemById.setItemLastModifiedDate(item.getItemLastModifiedDate());
            itemById.setItemSellingPrice(item.getItemSellingPrice());
            itemById.setItemStatus(item.getItemStatus());
            Item updatedItem = itemService.updateItem(itemById);
            return new ResponseEntity(updatedItem, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    //3. delete by itemId DELETE
    @RequestMapping(value="/app/item/{itemId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteItem(@PathVariable("itemId") int itemId){
        final Item itemById = itemService.getItem(itemId);
        if (itemById != null) {
            itemService.deleteItem(itemById);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    //4. delete all DELETE
    @RequestMapping(value="/app/item", method = RequestMethod.DELETE)
    public ResponseEntity deleteAllItems(){
        itemService.deleteAllItem();
        return new ResponseEntity(HttpStatus.OK);
    }

    //5. get by itemId GET
    @RequestMapping(value="/app/item/{itemId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> getItem(@PathVariable("itemId") int itemId){
        final Item itemById = itemService.getItem(itemId);
        if (itemById != null) {
            return new ResponseEntity<Item>(itemById, HttpStatus.OK);
        }
        return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
    }


    //6. get all GET

    @RequestMapping(value="/app/item", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Item>> getAllItems(){
        List<Item> items = itemService.getAllItems();
        return new ResponseEntity(items, HttpStatus.OK);
    }

    //7. filters by fields ?itemStatus={status}&itemEnteredByUser={modifiedBy} GET
    @RequestMapping(value="/app/item", method = RequestMethod.GET, params = {})
    public ResponseEntity<String> getItemsByStatus(@RequestParam("status") String status, @RequestParam("modifiedBy") String modifiedBy){

        return ResponseEntity.status(HttpStatus.OK).body("all items");
    }

    //8. select all with sorting and pagination ?pageSize={pageSize}&page={page}&sortBy={sortBy} GET
    @RequestMapping(value="/app/item", method = RequestMethod.GET)
    public ResponseEntity<String> sortItems(@RequestParam("pageSize") String status, @RequestParam("page") String modifiedBy,@RequestParam("sortBy") String sortBy){

        return ResponseEntity.status(HttpStatus.OK).body("all items");
    }
}

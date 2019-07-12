package com.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.domain.item.Item;
import com.jpa.repository.ItemRepository;

import javassist.NotFoundException;

@Service
@Transactional
public class ItemService {
	
	@Autowired
    ItemRepository itemRepository;

    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) throws NotFoundException {
    	 return itemRepository.findById(itemId).orElseThrow(() -> new NotFoundException("Unable to get Item with itemId = " + itemId));
    }
}

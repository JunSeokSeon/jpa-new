package com.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.domain.item.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	
}

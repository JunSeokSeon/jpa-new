package com.jpa.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Item {
	
	@Id
    @Column(name = "item_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column
    private String name;
    
	@Column
	private int price;
    
	@Column
	private int stockQuantity;

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", stockQuantity=" + stockQuantity + "]";
	}
}

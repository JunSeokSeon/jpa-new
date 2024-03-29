package com.jpa.domain.item;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.jpa.domain.Category;
import com.jpa.exception.NotEnoughStockException;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
@Entity
@Table
public abstract class Item {
	
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
	
	@ManyToMany(mappedBy = "items")
	private List<Category> categories = new ArrayList<Category>();
	
	//==Biz Method==//
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", stockQuantity=" + stockQuantity + "]";
	}
}

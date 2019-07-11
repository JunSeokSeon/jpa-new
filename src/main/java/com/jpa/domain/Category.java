package com.jpa.domain;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.jpa.domain.item.Item;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Category {
	
	@Id
    @Column(name = "category_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "parent_id", foreignKey = @ForeignKey(name = "fk_category_01"))
	private Category parent;
	
	@OneToMany(mappedBy = "parent")
	private List<Category> child = new ArrayList<Category>();
	
	@ManyToMany
	@JoinTable(name = "category_item", 
		joinColumns = @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "fk_category_item_01")), 
		inverseJoinColumns = @JoinColumn(name = "item_id", foreignKey = @ForeignKey(name = "fk_category_item_02")))
	private List<Item> items = new ArrayList<Item>();

	
	public void addChildCategory(Category child) {
		this.child.add(child);
		child.setParent(this);
	}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
}

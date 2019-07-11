package com.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jpa.domain.item.Item;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "order_item")
public class OrderItem {
	
	@Id
	@Column(name = "order_item_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name= "item_id", foreignKey = @ForeignKey(name = "fk_order_item_01"))
    private Item item;
    
    @ManyToOne
    @JoinColumn(name= "order_id", foreignKey = @ForeignKey(name= "fk_order_item_02"))
    private Order order;

    @Column
    private int orderPrice;
    
    @Column
    private int count;

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", orderPrice=" + orderPrice + ", count=" + count + "]";
	}
}

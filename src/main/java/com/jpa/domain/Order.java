package com.jpa.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "orders", uniqueConstraints = {@UniqueConstraint(name = "uk_orders_01", columnNames = "delivery_id")})
public class Order {
	
	@Id
    @Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Setter(AccessLevel.NONE)
    @ManyToOne
    @JoinColumn(name = "member_id", foreignKey = @ForeignKey(name = "fk_orders_01"))
    private Member member;
	
	@OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	
	@Setter(AccessLevel.NONE)
	@OneToOne
	@JoinColumn(name="delivery_id", foreignKey = @ForeignKey(name = "fk_orders_02"))
	private Delivery delivery;

    @Column
    private LocalDateTime orderDate;
    
    @Column
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    
	public void setMember(Member member) {
		if (this.member != null) {
			this.member.getOrders().remove(this);
		}
		
		this.member = member;
		this.member.getOrders().add(this);
	}
	
	public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }
	
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
		delivery.setOrder(this);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", status=" + status + "]";
	}
}

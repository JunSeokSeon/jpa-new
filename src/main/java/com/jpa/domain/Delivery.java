package com.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Delivery {
	
	@Id
	@Column(name = "delivery_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(mappedBy = "delivery")
	private Order order;
	
	@Embedded
	private Address address;
	
	@Column
	@Enumerated(EnumType.STRING)
	private DeliveryStatus status;
	
	public Delivery(Address address) {
        this.address = address;
        this.status = DeliveryStatus.READY;
    }

	@Override
	public String toString() {
		return "Delivery [id=" + id + ", address=" + address + ", status=" + status + "]";
	}
}

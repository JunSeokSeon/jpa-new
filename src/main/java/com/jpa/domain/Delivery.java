package com.jpa.domain;

import javax.persistence.Column;
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
	
	@Column
	private String city;
    
	@Column
	private String street;
    
	@Column
	private String zipcode;
	
	@Column
	@Enumerated(EnumType.STRING)
	private DeliveryStatus status;

	@Override
	public String toString() {
		return "Delivery [id=" + id + ", city=" + city + ", street=" + street + ", zipcode=" + zipcode + ", status="
				+ status + "]";
	}
}
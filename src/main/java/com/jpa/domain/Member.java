package com.jpa.domain;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Member extends BaseEntity {
	
	@Id
	@Column(name = "member_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String city;
    
	@Column
	private String street;
    
	@Column
	private String zipcode;
	
	@OneToMany(mappedBy = "member")
	private List<Order> orders = new ArrayList<Order>();
	
	@Builder
	public Member(Long id, String name, String city, String street, String zipcode) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", city=" + city + ", street=" + street + ", zipcode=" + zipcode
				+ "]";
	}
}

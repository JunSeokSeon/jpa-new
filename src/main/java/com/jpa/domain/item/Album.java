package com.jpa.domain.item;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("A")
@Entity
@Table
public class Album extends Item {
	
	@Column
	private String artist;
	
	@Column
	private String etc;

	@Override
	public String toString() {
		return "Album [artist=" + artist + ", etc=" + etc + "]";
	}
}

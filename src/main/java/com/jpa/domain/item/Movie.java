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
@DiscriminatorValue("M")
@Entity
@Table
public class Movie extends Item {
	
	@Column
	private String director;
	
	@Column
	private String actor;

	@Override
	public String toString() {
		return "Movie [director=" + director + ", actor=" + actor + "]";
	}
}

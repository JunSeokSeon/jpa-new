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
@DiscriminatorValue("B")
@Entity
@Table
public class Book extends Item {
	
	@Column
	private String author;
	
	@Column
	private String isbn;

	@Override
	public String toString() {
		return "Book [author=" + author + ", isbn=" + isbn + "]";
	}
}

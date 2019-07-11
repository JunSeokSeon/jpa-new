package com.jpa.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseEntity {
	
	@Column
    private LocalDateTime createdDate;
	
	@Column
    private LocalDateTime lastModifiedDate;

	@Override
	public String toString() {
		return "BaseEntity [createdDate=" + createdDate + ", lastModifiedDate=" + lastModifiedDate + "]";
	}
}

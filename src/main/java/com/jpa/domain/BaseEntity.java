package com.jpa.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
public abstract class BaseEntity {
	
	@CreatedBy
	@Column(name = "reg_id", length = 50, nullable = false, updatable = false)
	private String regId;
	
	@CreatedDate
	@Column(name = "reg_dt", nullable = false, updatable = false)
    private LocalDateTime createdDate;
	
	@LastModifiedBy
	@Column(name = "upd_id", length = 50)
	private String updId;
	
	@LastModifiedDate
	@Column(name = "upd_dt")
    private LocalDateTime lastModifiedDate;

	@Override
	public String toString() {
		return "BaseEntity [createdDate=" + createdDate + ", lastModifiedDate=" + lastModifiedDate + "]";
	}
}

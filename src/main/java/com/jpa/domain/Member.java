package com.jpa.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table
public class Member {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NAME", nullable = false, length = 10)
	private String userName;
	
	@Column
	private int age;
	
	@Column
	@Enumerated(EnumType.STRING)
	private RoleType roleTYpe;
	
	@Column
	private LocalDateTime createdDate;
	
	@Column
	private LocalDateTime lastModifiedDate;
	
	@Column
	@Lob
	private String description;
	
	@Builder
	public Member(Long id, String userName, int age, RoleType roleTYpe, LocalDateTime createdDate, LocalDateTime lastModifiedDate, String description) {
		this.id = id;
		this.userName = userName;
		this.age = age;
		this.roleTYpe = roleTYpe;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
		this.description = description;
	}
}

package com.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.domain.Member;

@SpringBootApplication
public class JpaNewApplication {

	public static void main(String[] args) {
		try (ConfigurableApplicationContext ctx = SpringApplication.run(JpaNewApplication.class, args)) {
			JpaNewApplication app = ctx.getBean(JpaNewApplication.class);
			app.method();
		}
	}
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void method() {
		
		Member member = Member.builder()
				.name("junseok")
				.city("korea")
				.zipcode("aa")
				.street("st")
				.build();
		
		this.em.persist(member);
	}
}

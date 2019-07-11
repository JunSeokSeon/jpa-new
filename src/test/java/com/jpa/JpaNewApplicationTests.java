package com.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.domain.Member;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaNewApplicationTests {
	
	@PersistenceContext
	private EntityManager em;

	@Test
	@Transactional
	public void entityManagerSteream() {
		
		Member member = em.find(Member.class, 2L);
		
		System.out.println("Member:" + member);
		
		assertEquals(member.getName(), "junseok");
	}
}

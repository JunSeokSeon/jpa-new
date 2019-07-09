package com.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jpa.domain.Member;


/**
 * @author 9000075
 *
 */
public class JpaApplication {
	
	public static void main(String args[]) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			logic(em);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		
		emf.close();
	}
	
	public static void logic(EntityManager em) {
		
		Member member = Member.builder()
			.userName("junseok")
			.age(15)
			.build();
		
		em.persist(member);
		//member = em.merge(member);
		
		Member findMember = em.find(Member.class, 1L);
		System.out.println("findMember=" + findMember);
		
		List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
        System.out.println("members.size=" + members.size());
        
        //em.remove(member);
	}

}

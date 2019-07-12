package com.jpa.domain;

import org.springframework.data.jpa.domain.Specifications;
import static com.jpa.domain.OrderSpec.memberNameLike;
import static com.jpa.domain.OrderSpec.orderStatusEq;

import static org.springframework.data.jpa.domain.Specifications.where;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderSearch {
	
	private String memberName;      //회원 이름
    private OrderStatus orderStatus;//주문 상태
    
    @SuppressWarnings("deprecation")
	public Specifications<Order> toSpecification() {
        return where(memberNameLike(memberName))
                .and(orderStatusEq(orderStatus));
    }
}

package com.jpa.repository.custom;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.jpa.domain.Order;
import com.jpa.domain.OrderSearch;
import com.jpa.domain.QMember;
import com.jpa.domain.QOrder;
import com.querydsl.jpa.JPQLQuery;

import org.springframework.util.StringUtils;

public class OrderRepositoryImpl extends QuerydslRepositorySupport implements CustomOrderRepository {

	public OrderRepositoryImpl() {
        super(Order.class);
    }
	
	@Override
	public List<Order> search(OrderSearch orderSearch) {
		
		QOrder order = QOrder.order;
        QMember member = QMember.member;

        JPQLQuery query = from(order);

        if (StringUtils.hasText(orderSearch.getMemberName())) {
            query.leftJoin(order.member, member)
                    .where(member.name.contains(orderSearch.getMemberName()));
        }

        if (orderSearch.getOrderStatus() != null) {
            query.where(order.status.eq(orderSearch.getOrderStatus()));
        }
        
        return query.fetch();
	}
}

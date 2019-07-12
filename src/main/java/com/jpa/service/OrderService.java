package com.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.domain.Delivery;
import com.jpa.domain.Member;
import com.jpa.domain.Order;
import com.jpa.domain.OrderItem;
import com.jpa.domain.OrderSearch;
import com.jpa.domain.item.Item;
import com.jpa.repository.MemberRepository;
import com.jpa.repository.OrderRepository;

import javassist.NotFoundException;

@Service
@Transactional
public class OrderService {
	
	@Autowired 
	MemberRepository memberRepository;
    
	@Autowired 
	OrderRepository orderRepository;
    
	@Autowired 
    ItemService itemService;

    /** 주문 */
    public Long order(Long memberId, Long itemId, int count) throws NotFoundException {

        //엔티티 조회
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new NotFoundException("Unable to get Member with memberId = " + memberId));
        Item item = itemService.findOne(itemId);

        //배송정보 생성
        Delivery delivery = new Delivery(member.getAddress());
        //주문상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
        //주문 생성
        Order order = Order.createOrder(member, delivery, orderItem);

        //주문 저장
        orderRepository.save(order);
        return order.getId();
    }


    /** 주문 취소 */
    public void cancelOrder(Long orderId) throws Exception {

        //주문 엔티티 조회
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new NotFoundException("Unable to get orderId with orderId = " + orderId));

        //주문 취소
        order.cancel();
    }

    /** 주문 검색 */
    public List<Order> findOrders(OrderSearch orderSearch) {
        return orderRepository.findAll(orderSearch.toSpecification());
    }
}

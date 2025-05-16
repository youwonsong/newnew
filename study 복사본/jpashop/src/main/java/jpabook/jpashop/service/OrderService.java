package jpabook.jpashop.service;

import jpabook.jpashop.domain.Delivery;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {


    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    //Order - 데이터를 변경하는것이기 때문에 @Transactional 필요
    @Transactional
    public Long order(Long memberId, Long itemId, int count){

        //Search Entity
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);

        //create DeliveryInfo
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());

        //crete orderItem
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        //create order
        Order order = Order.createOrder(member, delivery, orderItem);

        //save order
        //orderRepository.save((jakarta.persistence.criteria.Order) order);
        orderRepository.save(order);

        return order.getId();
    }
    //Cancel
    @Transactional
    public void cancelOrder(Long orderId){
        //Search Order Entity
        Order order = orderRepository.findOne(orderId);
        //cancel order
        order.cancel();
    }

    //Search
    public List<Order> findOrders(OrderSearch orderSearch){
        return orderRepository.findAllByCriteria(orderSearch);
    }

}

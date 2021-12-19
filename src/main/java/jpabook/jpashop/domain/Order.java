package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;

@Entity
@Table(name="ORDERS")
public class Order extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    //다대1 관계인데 fk가 Order에 있음
    @ManyToOne(fetch = LAZY)//ManyToOne은 LAZY로 바꿔야함
    @JoinColumn (name = "MEMBER_ID")
    private Member member;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(mappedBy = "order", cascade = ALL)//orderItem에 order라는 fk가 있음
    private List<OrderItem> orderItems = new ArrayList<>();

    //1대1 관계인데 fk가 Order에 있음
    @OneToOne(fetch = LAZY, cascade = ALL)//LAZY로 바꾸기, delivery의 생명주기를 order에 맞춤, delivery를 order에서 관리하겠다.
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;

    public void addOrderItem(OrderItem orderItem){//연관관계 편의 메소드
        orderItems.add(orderItem);
        orderItem.setOrder(this);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}

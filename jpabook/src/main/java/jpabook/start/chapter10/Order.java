package jpabook.start.chapter10;

import javax.persistence.*;

@Entity(name = "orders")
public class Order {
    @Id @GeneratedValue
    private Long id;

    private int orderAmount;

    @ManyToOne(optional = false)
    @JoinColumn(name="MEMBER_ID")
    private Member member;

    @ManyToOne(optional = false)
    private Product product;

    @Embedded
    private Address address;

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderAmount=" + orderAmount +
                ", member=" + member +
                ", product=" + product +
                ", address=" + address +
                '}';
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Member getMember() {
        return member;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }
}

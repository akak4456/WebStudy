package jpabook.start.chapter8;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "orders")
public class Order {
    @Id
    private String id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "MEMBER_IDS")
    private Member member;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        if(this.member != null && this.member.getOrders().contains(this)) {
            this.member.getOrders().remove(this);
        }
        this.member = member;
        this.member.getOrders().add(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

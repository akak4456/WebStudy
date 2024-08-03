package tobyspring.hellospring.order;

import jakarta.persistence.*;

import java.math.BigDecimal;

public class Order {
    private Long id;

    private String no;

    private BigDecimal total;

    public Order() {

    }

    public Order(String no, BigDecimal total) {
        this.no = no;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", total=" + total +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getNo() {
        return no;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}

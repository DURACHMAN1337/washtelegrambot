package ru.itwizard.washtelegrambot.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "orders")
@Data
@EqualsAndHashCode(callSuper = true)
public class Order extends AbstractEntityClass {

    @Id
    @GeneratedValue
    Long orderId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    @NotNull
    Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "carWashId")
    @NotNull
    CarWash carWash;

    @NotNull
    @Column(name = "date")
    Date date;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cartId")
    @NotNull
    Cart cart;

    public Order() {
    }

    public Order(Long orderId, @NotNull Customer customer, @NotNull CarWash carWash, @NotNull Date date, @NotNull Cart cart) {
        this.orderId = orderId;
        this.customer = customer;
        this.carWash = carWash;
        this.date = date;
        this.cart = cart;
    }
}

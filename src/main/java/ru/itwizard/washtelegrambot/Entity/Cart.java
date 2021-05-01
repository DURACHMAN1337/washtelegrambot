package ru.itwizard.washtelegrambot.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "carts")
@Data
@EqualsAndHashCode(callSuper = true)
public class Cart extends AbstractEntityClass {

    @Id
    @GeneratedValue
    private Long carId;

    @JoinColumn(name = "services")
    @OneToMany(fetch = FetchType.EAGER)
    private List<Service> services;

    @Column(name = "totalPrice")
    private BigDecimal totalPrice;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private Customer customer;

    public Cart() {
    }

    public Cart(Long carId, List<Service> services, BigDecimal totalPrice, Customer customer) {
        this.carId = carId;
        this.services = services;
        this.totalPrice = totalPrice;
        this.customer = customer;
    }
}

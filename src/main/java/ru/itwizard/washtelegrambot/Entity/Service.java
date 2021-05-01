package ru.itwizard.washtelegrambot.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "services")
@EqualsAndHashCode(callSuper = true)
@Data
public class Service extends AbstractEntityClass {

    @Id
    @GeneratedValue
    private Long serviceId;

    @Column(name = "price")
    @NotNull
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "carWashId")
    private CarWash carWash;

    @Column(name = "serviceName")
    private String serviceName;

    public Service() {
    }

    public Service(Long serviceId, @NotNull BigDecimal price, CarWash carWash, String serviceName) {
        this.serviceId = serviceId;
        this.price = price;
        this.carWash = carWash;
        this.serviceName = serviceName;
    }


}

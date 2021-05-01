package ru.itwizard.washtelegrambot.Entity;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
@EqualsAndHashCode(callSuper = true)
@Data
public class Customer extends AbstractEntityClass {

    @Id
    @Column(name = "userID")
    private Long userId;

    @NotNull
    @Column(name = "firstname")
    private String firstname;

    @NotNull
    @Column(name = "username")
    private String username;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "state_number")
    private String stateNumber;

    @Column(name = "auto_brand")
    private Brands brand;

    @Column(name = "auto_model")
    private String model;

    public Customer() {
    }

    public Customer(String firstname, Long userId, String username, String telephone, String stateNumber, Brands brand, String model) {
        this.firstname = firstname;
        this.userId = userId;
        this.username = username;
        this.telephone = telephone;
        this.stateNumber = stateNumber;
        this.brand = brand;
        this.model = model;
    }
}

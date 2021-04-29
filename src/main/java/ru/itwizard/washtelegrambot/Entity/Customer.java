package ru.itwizard.washtelegrambot.Entity;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
@EqualsAndHashCode(callSuper = true)
@Data
public class Customer extends AbstractEntityClass {

    @NotNull
    @Column(name = "firstname")
    String firstname;

    @NotNull
    @Column(name = "userID")
    String userId;

    @NotNull
    @Column(name = "username")
    String username;

    @Column(name = "telephone")
    String telephone;

    @Column(name = "state_number")
    String stateNumber;

    @Column(name = "auto_brand")
    Brands brand;

    @Column(name = "auto_model")
    String model;







}

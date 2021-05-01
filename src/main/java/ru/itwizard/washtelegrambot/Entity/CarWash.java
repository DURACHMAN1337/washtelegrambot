package ru.itwizard.washtelegrambot.Entity;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@Entity
@Table(name = "carWash")
@EqualsAndHashCode(callSuper = true)
@Data
public class CarWash extends AbstractEntityClass {

    @Id
    @GeneratedValue
    Long carWashId;

    @Column(name = "addres")
    String address;

    @Column(name = "telephone")
    String telephone;






}

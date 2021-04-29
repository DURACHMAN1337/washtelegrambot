package ru.itwizard.washtelegrambot.Entity;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "carWash")
@EqualsAndHashCode(callSuper = true)
@Data
public class CarWash extends AbstractEntityClass {

    @NotNull
    @Column(name = "car_wash_id")
    String carWashId;

    String address;

    String telephone;

    TimeTable timeTable;


}

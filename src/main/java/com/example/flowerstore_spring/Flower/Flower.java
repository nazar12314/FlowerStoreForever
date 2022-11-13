package com.example.flowerstore_spring.Flower;

import com.example.flowerstore_spring.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Table
@Entity
public class Flower extends Item {
    private int sepalLength;
    private String description;
    @Enumerated(EnumType.STRING)
    private FlowerType flowerType;
    private String color;
    protected double price;
    @Id @GeneratedValue
    private int id;

    public Flower(
            String description,
            double price,
            String color,
            int sepalLength
    ) {
        super(description);
        this.price = price;
        this.sepalLength = sepalLength;
        this.color = color;
    }

    @Override
    public double price() {
        return this.price;
    }
}
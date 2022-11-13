package com.example.flowerstore_spring;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @AllArgsConstructor @NoArgsConstructor
public abstract class Item {

    private String description;

    public abstract double price();
}
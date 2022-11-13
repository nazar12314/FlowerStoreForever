package com.example.flowerstore_spring;

import com.example.flowerstore_spring.Decorators.BasketDecorator;
import com.example.flowerstore_spring.Decorators.PaperDecorator;
import com.example.flowerstore_spring.Decorators.RibbonDecorator;
import com.example.flowerstore_spring.Flower.Flower;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DecoratorsTest {

    private Item item;

    @BeforeEach
    public void init() {
        this.item = new Flower(
                "Beautiful flower",
                40,
                "red",
                11
        );
    }

    @Test
    public void testBasketDecorator() {
        BasketDecorator decoratedFlower = new BasketDecorator(item);

        Assertions.assertEquals(decoratedFlower.getPrice(), item.price() + 4);
        Assertions.assertEquals(
                decoratedFlower.getDescription(),
                item.getDescription()
        );
    }

    @Test
    public void testPaperDecorator() {
        PaperDecorator decoratedFlower = new PaperDecorator(item);

        Assertions.assertEquals(
                decoratedFlower.getPrice(),
                item.price() + 13
        );
        Assertions.assertEquals(
                decoratedFlower.getDescription(),
                item.getDescription()
        );
    }

    @Test
    public void testRibbonDecorator() {
        RibbonDecorator decoratedFlower = new RibbonDecorator(item);

        Assertions.assertEquals(
                decoratedFlower.getPrice(),
                item.price() + 40
        );
        Assertions.assertEquals(
                decoratedFlower.getDescription(),
                item.getDescription()
        );
    }
}

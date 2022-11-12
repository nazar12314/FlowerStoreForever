package com.example.flowerstore_spring.Orders;

import com.example.flowerstore_spring.Delivery.Delivery;
import com.example.flowerstore_spring.Payments.Payment;
import com.example.flowerstore_spring.Responses.Response;
import lombok.Getter;

import com.example.flowerstore_spring.Item;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
public class Order {
    @Getter
    private final List<Item> items = new ArrayList<>();
    @Setter
    private Payment payment;
    @Setter
    private Delivery delivery;
    @Getter
    private boolean isProcessed;

    @Getter
    private final String id = UUID.randomUUID().toString();
    private double calculateTotalPrice() {
        double price = 0;

        for (Item item : items) {
            price += item.price();
        }

        return price;
    }

    public Response processOrder() {
        double totalPrice = calculateTotalPrice();
        isProcessed = true;
        return payment.pay(totalPrice);
    }

    public Response deliverOrder() {
        return delivery.deliver(items);
    }

    public void addItem(Item item) {
        items.add(item);
    }
}
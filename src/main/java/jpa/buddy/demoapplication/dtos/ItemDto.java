package jpa.buddy.demoapplication.dtos;

import jpa.buddy.demoapplication.entities.Item;
import jpa.buddy.demoapplication.entities.Order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link Item} entity
 */
public class ItemDto implements Serializable {
    private final OrderDto order;
    private final String name;
    private final BigDecimal price;
    private final Long quantity;

    public ItemDto(OrderDto order, String name, BigDecimal price, Long quantity) {
        this.order = order;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderDto getOrder() {
        return order;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Long getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ItemDto entity = (ItemDto) o;
        return Objects.equals(this.order, entity.order) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.price, entity.price) &&
                Objects.equals(this.quantity, entity.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, name, price, quantity);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "order = " + order + ", " +
                "name = " + name + ", " +
                "price = " + price + ", " +
                "quantity = " + quantity + ")";
    }

    /**
     * A DTO for the {@link Order} entity
     */
    public static class OrderDto implements Serializable {
        private final BigDecimal totalPrice;

        public OrderDto(BigDecimal totalPrice) {
            this.totalPrice = totalPrice;
        }

        public BigDecimal getTotalPrice() {
            return totalPrice;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            OrderDto entity = (OrderDto) o;
            return Objects.equals(this.totalPrice, entity.totalPrice);
        }

        @Override
        public int hashCode() {
            return Objects.hash(totalPrice);
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + "(" +
                    "totalPrice = " + totalPrice + ")";
        }
    }
}
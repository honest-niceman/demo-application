package jpa.buddy.demoapplication.controllers;

import jpa.buddy.demoapplication.dtos.ItemDto;
import jpa.buddy.demoapplication.mappers.ItemMapper;
import jpa.buddy.demoapplication.services.DiscountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final DiscountService discountService;
    private final ItemMapper itemMapper;

    public OrderController(DiscountService discountService, ItemMapper itemMapper) {
        this.discountService = discountService;
        this.itemMapper = itemMapper;
    }

    @PutMapping("/category/{categoryId}/discount")
    public List<ItemDto> applyDiscount(@PathVariable Long categoryId, @RequestParam Long discountSize) {
        return discountService.applyDiscount(categoryId, discountSize)
                .stream()
                .map(itemMapper::itemToItemDto)
                .collect(Collectors.toList());
    }
}

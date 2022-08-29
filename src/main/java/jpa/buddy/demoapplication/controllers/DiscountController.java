package jpa.buddy.demoapplication.controllers;

import jpa.buddy.demoapplication.dtos.ItemDto;
import jpa.buddy.demoapplication.entities.Item;
import jpa.buddy.demoapplication.mappers.ItemMapper;
import jpa.buddy.demoapplication.services.DiscountService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/discount")
public class DiscountController {
    private final DiscountService discountService;
    private final ItemMapper itemMapper;

    public DiscountController(DiscountService discountService, ItemMapper itemMapper) {
        this.discountService = discountService;
        this.itemMapper = itemMapper;
    }

    @PutMapping("/set-discount")
    public List<ItemDto> setDiscount(@RequestParam Long orderId, @RequestParam Long discountSize) {
        return discountService.setDiscount(orderId, discountSize)
                .stream()
                .map(itemMapper::itemToItemDto)
                .collect(Collectors.toList());
    }
}

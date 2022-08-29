package jpa.buddy.demoapplication.services;

import jpa.buddy.demoapplication.entities.Item;
import jpa.buddy.demoapplication.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DiscountService {
    private final ItemRepository itemRepository;

    public DiscountService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> applyDiscount(Long categoryId, Long discountSize) {
        List<Item> items = itemRepository.findByCategory(categoryId);

        items.forEach(item -> {
            item.setPrice(item.getPrice()
                                  .multiply(BigDecimal.valueOf(1 - discountSize / 100)));
        });

        return itemRepository.saveAll(items);
    }
}

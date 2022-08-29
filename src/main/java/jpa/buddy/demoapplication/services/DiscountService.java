package jpa.buddy.demoapplication.services;

import jpa.buddy.demoapplication.entities.Item;
import jpa.buddy.demoapplication.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class DiscountService {
    private final ItemRepository itemRepository;

    public DiscountService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> setDiscount(Long orderId, Long discountSize) {
        List<Item> items = itemRepository.findByOrder(orderId);

        BigDecimal discount;
        for (Item item : items) {
            discount = item
                    .getPrice()
                    .multiply(BigDecimal.valueOf(discountSize))
                    .divide(BigDecimal.valueOf(100), RoundingMode.CEILING);

            item.setPrice(item.getPrice().subtract(discount));
        }

        return itemRepository.saveAll(items);
    }
}

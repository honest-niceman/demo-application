package jpa.buddy.demoapplication.mappers;

import jpa.buddy.demoapplication.dtos.ItemDto;
import jpa.buddy.demoapplication.entities.Item;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
@Component
public interface ItemMapper {
    Item itemDtoToItem(ItemDto itemDto);

    ItemDto itemToItemDto(Item item);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Item updateItemFromItemDto(ItemDto itemDto, @MappingTarget Item item);
}

package io.github.vanbv.list.keep.mapper;

import io.github.vanbv.list.keep.dto.ItemDto;
import io.github.vanbv.list.keep.dto.ItemUpdateDto;
import io.github.vanbv.list.keep.model.Item;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ItemMapper {
    public Collection<ItemDto> map(Collection<Item> source) {
        return source.stream().map(item -> new ItemDto(item.getId(), item.getName())).toList();
    }

    public Item map(ItemUpdateDto source, Item destination) {
        destination.setName(source.name());
        return destination;
    }
}

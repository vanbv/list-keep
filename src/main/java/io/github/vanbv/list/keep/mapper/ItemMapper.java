package io.github.vanbv.list.keep.mapper;

import io.github.vanbv.list.keep.dto.ItemCreateDto;
import io.github.vanbv.list.keep.dto.ItemDto;
import io.github.vanbv.list.keep.dto.ItemUpdateDto;
import io.github.vanbv.list.keep.model.Item;
import io.github.vanbv.list.keep.model.List;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ItemMapper {
    public Collection<ItemDto> map(Collection<Item> source) {
        return source.stream().map(this::map).toList();
    }

    public ItemDto map(Item source) {
        return new ItemDto(source.getId(), source.getName());
    }

    public Item map(ItemCreateDto source, List list) {
        Item destination = new Item();
        destination.setName(source.name());
        destination.setList(list);
        return destination;
    }

    public Item map(ItemUpdateDto source, Item destination) {
        destination.setName(source.name());
        return destination;
    }
}

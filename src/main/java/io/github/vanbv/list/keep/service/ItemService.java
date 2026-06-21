package io.github.vanbv.list.keep.service;

import io.github.vanbv.list.keep.dto.ItemDto;
import io.github.vanbv.list.keep.dto.ItemUpdateDto;
import io.github.vanbv.list.keep.exception.NotFoundException;
import io.github.vanbv.list.keep.mapper.ItemMapper;
import io.github.vanbv.list.keep.model.Item;
import io.github.vanbv.list.keep.model.List;
import io.github.vanbv.list.keep.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class ItemService {
    Logger log = LoggerFactory.getLogger(ItemService.class);

    private final ListService listService;
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public ItemService(ListService listService, ItemRepository itemRepository, ItemMapper itemMapper) {
        this.listService = listService;
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public Collection<ItemDto> getAll(UUID listId, String userId) {
        List list = listService.getIfExist(listId, userId);
        return itemMapper.map(itemRepository.findByList(list));
    }

    public void update(UUID id, UUID listId, ItemUpdateDto item, String userId) {
        itemRepository.save(itemMapper.map(item, getIfExist(id, listId, userId)));
    }

    private Item getIfExist(UUID id, UUID listId, String userId) {
        Optional<Item> item = itemRepository.findByIdAndListIdAndListUserId(id, listId, UUID.fromString(userId));

        if (item.isPresent()) {
            return item.get();
        } else {
            log.warn("Item not found: [id = {}, listId = {}, userId = {}]", id, listId, userId);
            throw new NotFoundException("Item with id = %s not found".formatted(id));
        }
    }
}

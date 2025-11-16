package io.github.vanbv.list.keep.service;

import io.github.vanbv.list.keep.dto.ItemDto;
import io.github.vanbv.list.keep.mapper.ItemMapper;
import io.github.vanbv.list.keep.model.List;
import io.github.vanbv.list.keep.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
public class ItemService {
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
}

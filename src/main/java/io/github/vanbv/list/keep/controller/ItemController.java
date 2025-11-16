package io.github.vanbv.list.keep.controller;

import io.github.vanbv.list.keep.dto.ItemDto;
import io.github.vanbv.list.keep.service.ItemService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/lists/{listId}/items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public Collection<ItemDto> getAll(@PathVariable UUID listId, Authentication authentication) {
        return itemService.getAll(listId, authentication.getName());
    }
}

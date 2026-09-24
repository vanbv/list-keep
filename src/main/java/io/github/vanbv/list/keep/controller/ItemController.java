package io.github.vanbv.list.keep.controller;

import io.github.vanbv.list.keep.dto.ItemCreateDto;
import io.github.vanbv.list.keep.dto.ItemDto;
import io.github.vanbv.list.keep.dto.ItemUpdateDto;
import io.github.vanbv.list.keep.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/lists/{listId}/items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ItemDto create(
            @PathVariable UUID listId,
            @RequestBody ItemCreateDto item,
            Authentication authentication
    ) {
        return itemService.create(listId, item, authentication.getName());
    }

    @GetMapping
    public Collection<ItemDto> getAll(@PathVariable UUID listId, Authentication authentication) {
        return itemService.getAll(listId, authentication.getName());
    }

    @PutMapping("/{id}")
    public void update(
            @PathVariable UUID listId,
            @PathVariable UUID id,
            @RequestBody ItemUpdateDto item,
            Authentication authentication
    ) {
        itemService.update(id, listId, item, authentication.getName());
    }
}

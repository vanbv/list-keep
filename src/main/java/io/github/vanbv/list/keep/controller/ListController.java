package io.github.vanbv.list.keep.controller;

import io.github.vanbv.list.keep.dto.ListCreateDto;
import io.github.vanbv.list.keep.dto.ListDto;
import io.github.vanbv.list.keep.service.ListService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/lists")
public class ListController {
    private final ListService listService;

    public ListController(ListService listService) {
        this.listService = listService;
    }

    @PostMapping
    public void create(@Valid @RequestBody ListCreateDto list, Authentication authentication) {
        listService.create(list, authentication.getName());
    }

    @GetMapping
    public Collection<ListDto> getAll(Authentication authentication) {
        return listService.getAll(authentication.getName());
    }
}

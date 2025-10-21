package io.github.vanbv.list.keep.service;

import io.github.vanbv.list.keep.dto.ListCreateDto;
import io.github.vanbv.list.keep.dto.ListDto;
import io.github.vanbv.list.keep.mapper.ListMapper;
import io.github.vanbv.list.keep.repository.ListRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
public class ListService {
    private final ListMapper listMapper;
    private final ListRepository repository;

    public ListService(ListRepository repository, ListMapper listMapper) {
        this.repository = repository;
        this.listMapper = listMapper;
    }

    public void create(ListCreateDto list, String userId) {
        repository.save(listMapper.map(list, userId));
    }

    public Collection<ListDto> getAll(String userId) {
        return listMapper.map(repository.findByUserId(UUID.fromString(userId)));
    }
}

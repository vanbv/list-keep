package io.github.vanbv.list.keep.service;

import io.github.vanbv.list.keep.dto.ListCreateDto;
import io.github.vanbv.list.keep.dto.ListDto;
import io.github.vanbv.list.keep.exception.NotFoundException;
import io.github.vanbv.list.keep.mapper.ListMapper;
import io.github.vanbv.list.keep.model.List;
import io.github.vanbv.list.keep.repository.ListRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class ListService {
    Logger log = LoggerFactory.getLogger(ListService.class);

    private final ListMapper listMapper;
    private final ListRepository listRepository;

    public ListService(ListRepository listRepository, ListMapper listMapper) {
        this.listRepository = listRepository;
        this.listMapper = listMapper;
    }

    public void create(ListCreateDto list, String userId) {
        listRepository.save(listMapper.map(list, userId));
    }

    public Collection<ListDto> getAll(String userId) {
        return listMapper.map(listRepository.findByUserId(UUID.fromString(userId)));
    }

    public ListDto get(UUID id, String userId) {
        return listMapper.map(getIfExist(id, userId));
    }

    public List getIfExist(UUID id, String userId) {
        Optional<List> list = listRepository.findByIdAndUserId(id, UUID.fromString(userId));

        if (list.isPresent()) {
            return list.get();
        } else {
            log.warn("List not found: [id = {}, userId = {}]", id, userId);
            throw new NotFoundException("List with id = %s not found".formatted(id));
        }
    }
}

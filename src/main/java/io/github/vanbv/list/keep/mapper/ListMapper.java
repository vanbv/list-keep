package io.github.vanbv.list.keep.mapper;

import io.github.vanbv.list.keep.dto.ListCreateDto;
import io.github.vanbv.list.keep.dto.ListDto;
import io.github.vanbv.list.keep.model.List;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.UUID;

@Component
public class ListMapper {
    public List map(ListCreateDto list, String userId) {
        List destination = new List();
        destination.setName(list.name());
        destination.setUserId(UUID.fromString(userId));
        return destination;
    }

    public Collection<ListDto> map(Collection<List> source) {
        return source.stream().map(list -> new ListDto(list.getName())).toList();
    }
}

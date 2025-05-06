package io.github.vanbv.list.keep.mapper;

import io.github.vanbv.list.keep.dto.ListCreateDto;
import io.github.vanbv.list.keep.model.List;
import org.springframework.stereotype.Component;

@Component
public class ListMapper {
    public List map(ListCreateDto source) {
        List destination = new List();
        destination.setName(source.name());
        return destination;
    }
}

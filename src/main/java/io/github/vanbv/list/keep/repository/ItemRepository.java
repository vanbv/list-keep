package io.github.vanbv.list.keep.repository;

import io.github.vanbv.list.keep.model.Item;
import io.github.vanbv.list.keep.model.List;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.UUID;

public interface ItemRepository extends CrudRepository<Item, UUID> {
    Collection<Item> findByList(List list);
}

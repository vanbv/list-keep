package io.github.vanbv.list.keep.repository;

import io.github.vanbv.list.keep.model.Item;
import io.github.vanbv.list.keep.model.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface ItemRepository extends CrudRepository<Item, UUID> {
    Collection<Item> findByList(List list);
    @EntityGraph(attributePaths = {"list"})
    Optional<Item> findByIdAndListIdAndListUserId(UUID id, UUID listId, UUID userId);
}

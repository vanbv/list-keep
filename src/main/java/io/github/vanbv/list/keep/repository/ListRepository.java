package io.github.vanbv.list.keep.repository;

import io.github.vanbv.list.keep.model.List;
import org.springframework.data.repository.CrudRepository;

public interface ListRepository extends CrudRepository<List, Long> { }

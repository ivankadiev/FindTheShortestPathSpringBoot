package com.ftsp.backtracking.rep;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ftsp.backtracking.model.BoardParameters;

@Repository
public interface BoardRepository extends CrudRepository<BoardParameters, String> {}

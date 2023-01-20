package com.usercase.resource.dao;

import com.usercase.resource.model.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface noteRepository extends CrudRepository<Note,Integer> {


}

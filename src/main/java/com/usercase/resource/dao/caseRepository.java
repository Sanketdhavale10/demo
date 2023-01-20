package com.usercase.resource.dao;

import com.usercase.resource.model.Case;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface caseRepository extends CrudRepository<Case,Integer> {


        List<Case> findByStatus(Case.Status Status);

        @Query(value = "SELECT * FROM Case c where c.userId =? ", nativeQuery = true)
        List<Case>  findByUserId(Integer userId );

        @Query(value = "SELECT * FROM Case c where c.userId=? and c.status=? ", nativeQuery = true)
        List<Case>   findByUserIdAndStatus(Integer userId,Case.Status Status);
}

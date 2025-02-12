package com.ucx.testsparttwo.repository;

import com.ucx.testsparttwo.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository<T extends BaseEntity<U>,U> extends JpaRepository<T, U> {

}

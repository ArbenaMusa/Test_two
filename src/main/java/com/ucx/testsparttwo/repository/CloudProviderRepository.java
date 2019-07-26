package com.ucx.testsparttwo.repository;

import com.ucx.testsparttwo.entity.CloudProvider;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;

@Repository
public interface CloudProviderRepository extends BaseRepository<CloudProvider, Integer> {

    @Query(value = "SELECT  COUNT(p.id), c.location " +
            "FROM cloud_provider AS c " +
            "INNER JOIN product AS p ON c.id = p.cloud_provider_id " +
            "GROUP BY c.location", nativeQuery = true)
    public List<Tuple> readLocation();
}


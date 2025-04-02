package com.test.abc.testcms.repository;

import com.test.abc.testcms.entity.ClientEntity;
import com.test.abc.testcms.model.ClientAgeStats;
import com.test.abc.testcms.projection.ClientStatProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    @Query(
            "select c from ClientEntity c " +
                    "where (:firstName is null or c.firstName like %:firstName%) " +
                    "and (:lastName is null or c.lastName like %:lastName%) "
    )
    Page<ClientEntity> filter(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            Pageable pageable
    );

    @Query(
            "select min(c.age) as min, " +
                    "max(c.age) as max, " +
                    "avg(c.age) as mean, " +
                    "stddev(c.age) as stdDev " +
                    "from ClientEntity c " +
                    "where (:firstName is null or c.firstName like %:firstName%) " +
                    "and (:lastName is null or c.lastName like %:lastName%) "
    )
    ClientStatProjection getAgeStats(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName
    );

}

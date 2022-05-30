package com.api.postnet.repository;

import com.api.postnet.entities.Appoiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AppoimentRepository extends JpaRepository<Appoiment,Long> {

    @Query("SELECT o From Appoiment o WHERE o.id=:appoimentId")
    Appoiment findAppoimentByAppoimentId(@Param("appoimentId") Long appoimentId);
}

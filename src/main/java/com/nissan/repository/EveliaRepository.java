package com.nissan.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nissan.entity.Evelia;

@Repository
public interface EveliaRepository extends JpaRepository<Evelia, Long>,
        Serializable {
}

package com.nissan.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nissan.entity.Qashqai;

@Repository
public interface QashqaiRepository extends JpaRepository<Qashqai, Long> ,
        Serializable {
}

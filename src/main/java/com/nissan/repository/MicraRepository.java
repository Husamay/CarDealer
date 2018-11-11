package com.nissan.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nissan.entity.Micra;

@Repository
public interface MicraRepository extends JpaRepository<Micra, Long>,
        Serializable {
}

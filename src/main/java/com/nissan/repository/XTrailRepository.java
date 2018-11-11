package com.nissan.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nissan.entity.XTrail;

@Repository
public interface XTrailRepository extends JpaRepository<XTrail, Long>,
        Serializable {
}

package com.nissan.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nissan.entity.Pulsar;

@Repository
public interface PulsarRepository extends JpaRepository<Pulsar, Long>,
        Serializable {
}

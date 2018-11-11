package com.nissan.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nissan.entity.Juke;

@Repository
public interface JukeRepository extends JpaRepository<Juke, Long>, Serializable {
        }

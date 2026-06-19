package com.resenas.resenas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resenas.resenas.model.Resenas;

@Repository
public interface ResenasRepository extends JpaRepository<Resenas, Long> {
}
package com.olmez.ceilingfan.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olmez.ceilingfan.model.data.CeilingFan;

@Repository
public interface CeilingFanRepository extends JpaRepository<CeilingFan, Long> {
}

package com.ci.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ci.entity.Riw;

@Repository
public interface RiwRepo extends JpaRepository<Riw, Long>{

}

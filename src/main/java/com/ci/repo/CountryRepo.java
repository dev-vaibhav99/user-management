package com.ci.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ci.entity.Countries;

public interface CountryRepo extends JpaRepository<Countries, Long> {

}

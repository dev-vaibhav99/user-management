package com.vaibhav.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaibhav.entity.Countries;

public interface CountryRepo extends JpaRepository<Countries, Long> {

}

package com.vaibhav.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vaibhav.entity.DataCollection;

public interface DataCollectionRepo extends JpaRepository<DataCollection, Long> {

}

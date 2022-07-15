package com.ci.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ci.entity.DataCollection;

public interface DataCollectionRepo extends JpaRepository<DataCollection, Long> {

}

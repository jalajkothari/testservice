package com.jk.testservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jk.testservice.entity.Service;

@Repository
public interface ServiceRepository extends CrudRepository<Service, Long> {

}

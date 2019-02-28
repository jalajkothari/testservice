package com.jk.testservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jk.testservice.entity.Plan;

@Repository
public interface PlanRepository extends CrudRepository<Plan, Long> {

	@EntityGraph(value = "Plan.Product")
	Plan findOneWithProductsById(long id);
	
	List<Plan> findAllByOrderById();
	
	List<Plan> findAllByOrderByName();

}

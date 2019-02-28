package com.jk.testservice.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.testservice.entity.Plan;
import com.jk.testservice.repository.PlanRepository;

@Service
public class PlanService {

	@Autowired
	PlanRepository planRepository;

	public List<Plan> getSortedPlans(){
		Iterable<Plan> planList = planRepository.findAll();
		return StreamSupport.stream(Optional.ofNullable(planList).orElse(Collections.emptyList()).spliterator(), false)
				.sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
				.collect(Collectors.toList());
	}

	public List<Plan> getPlans(String sortBy) {
		switch(Optional.ofNullable(sortBy).orElse("").toLowerCase()) {
		case "id":
			return planRepository.findAllByOrderById();
		case "name":
			return planRepository.findAllByOrderByName();
		default:
			return (List<Plan>) planRepository.findAll();
		}
	}

	public Plan findById(Long id) {
		Plan plan = planRepository.findOneWithProductsById(id);
		return plan;
	}
}

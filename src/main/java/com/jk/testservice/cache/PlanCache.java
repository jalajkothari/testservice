package com.jk.testservice.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.jk.testservice.service.PlanService;

@Component
@Cacheable()
public class PlanCache {

	@Autowired
	PlanService planService;
	
}

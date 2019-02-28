package com.jk.testservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jk.testservice.entity.Plan;
import com.jk.testservice.entity.Product;
import com.jk.testservice.entity.Service;
import com.jk.testservice.repository.PlanRepository;
import com.jk.testservice.repository.ProductRepository;
import com.jk.testservice.repository.ServiceRepository;
import com.jk.testservice.service.PlanService;

//@RestController
@Controller
//@ResponseBody
public class PlanController {

	@Autowired
	PlanService planService;
	
	@Autowired
	PlanRepository planRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ServiceRepository serviceRepository;

	/*@GetMapping(path="/plan/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Optional<Plan>> getPlan(@PathVariable("id") Long id){
		return new ResponseEntity<>(planService.findById(id), HttpStatus.OK);
	}*/
	@GetMapping(path="/plan/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	private Plan getPlan(@PathVariable("id") Long id){
		return planService.findById(id);
	}
	
	@GetMapping(path="/plan", produces= {MediaType.ALL_VALUE})
	private ResponseEntity<Iterable<Plan>> getPlans(@RequestParam(name="sortBy", required=false) String sortBy) {
		return new ResponseEntity<>(planService.getPlans(sortBy), HttpStatus.OK);
	}
	
	@PostMapping(path="/plan", consumes=MediaType.APPLICATION_JSON_VALUE, 
    		produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Plan> addPlan(@RequestBody Plan plan){
		return new ResponseEntity<>(planRepository.save(plan), HttpStatus.OK);
	}
	
	@PutMapping(path="/plan", consumes=MediaType.APPLICATION_JSON_VALUE, 
    		produces=MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Plan> updatePlan(@RequestBody Plan plan){
		return new ResponseEntity<>(planRepository.save(plan), HttpStatus.OK);
	}
	
	@DeleteMapping(path="/plan", consumes=MediaType.APPLICATION_JSON_VALUE, 
    		produces=MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<String> deletePlan(@RequestBody Plan plan){
		planRepository.delete(plan);
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	
	@PostMapping(path="/service", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Iterable<Service>> addService(@RequestBody List<Service> services){
		return new ResponseEntity<>(serviceRepository.saveAll(services), HttpStatus.OK);
	}
	
	@PostMapping(path="/product", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<Iterable<Product>> addProduct(@RequestBody List<Product> products){
		return new ResponseEntity<>(productRepository.saveAll(products), HttpStatus.OK);
	}
}

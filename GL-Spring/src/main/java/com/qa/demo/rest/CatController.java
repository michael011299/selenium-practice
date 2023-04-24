package com.qa.demo.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qa.demo.domain.Cat;
import com.qa.demo.service.CatService;

@RestController
public class CatController {

	private CatService service;

	public CatController(CatService service) {
		super();
		this.service = service;
	}

	@GetMapping("/getAll")
	public List<Cat> getAll() {
		return this.service.getAll();
	}

	@GetMapping("/get/{id}")
	public Cat getById(@PathVariable int id) {
		return this.service.getById(id);
	}

	@GetMapping("/get/name/{name}")
	public List<Cat> findByName(@PathVariable String name) {
		return this.service.findByName(name);
	}

	@PostMapping("/create")
	public ResponseEntity<Cat> create(@RequestBody Cat c) {
		Cat created = this.service.create(c);
		return new ResponseEntity<>(created, HttpStatus.CREATED);
	}

	@PatchMapping("/update/{id}")
	public Cat update(@PathVariable Integer id, @RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "length", required = false) Integer length,
			@RequestParam(name = "hasWhiskers", required = false) Boolean hasWhiskers,
			@RequestParam(name = "evil", required = false) Boolean evil) {
		return this.service.update(id, name, length, hasWhiskers, evil);
	}

	@DeleteMapping("/remove/{id}")
	public Cat removeById(@PathVariable int id) {
		return this.service.removeById(id);
	}
}

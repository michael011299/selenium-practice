package com.qa.demo.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.demo.domain.Cat;
import com.qa.demo.exceptions.CatNotFoundException;
import com.qa.demo.repo.CatRepo;

@Primary
@Service
public class CatServiceDB implements CatService {

	private CatRepo repo;

	public CatServiceDB(CatRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<Cat> getAll() {
		return this.repo.findAll();
	}

	@Override
	public Cat getById(int id) {
		return this.repo.findById(id).orElseThrow(CatNotFoundException::new);
	}

	@Override
	public List<Cat> findByName(String name) {
		return this.repo.findByNameOrderByLengthAsc(name);
	}

	@Override
	public Cat create(Cat c) {
		return this.repo.save(c);
	}

	@Override
	public Cat update(Integer id, String name, Integer length, Boolean hasWhiskers, Boolean evil) {
		Cat toUpdate = this.getById(id);

		if (name != null)
			toUpdate.setName(name);
		if (length != null)
			toUpdate.setLength(length);
		if (hasWhiskers != null)
			toUpdate.setHasWhiskers(hasWhiskers);
		if (evil != null)
			toUpdate.setEvil(evil);

		return this.repo.save(toUpdate);
	}

	@Override
	public Cat removeById(int id) {
		Cat deleted = this.getById(id);
		this.repo.deleteById(id);
		return deleted;
	}
}

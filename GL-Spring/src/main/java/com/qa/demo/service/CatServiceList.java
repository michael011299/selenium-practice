package com.qa.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.qa.demo.domain.Cat;

//@Primary
@Service
public class CatServiceList implements CatService {

	private List<Cat> cats = new ArrayList<>();

	@Override
	public List<Cat> getAll() {
		return this.cats;
	}

	@Override
	public Cat getById(int id) {
		return this.cats.get(id);
	}

	@Override
	public List<Cat> findByName(String name) {
		return this.cats.stream().filter(c -> c.getName().equals(name))
				.sorted((c1, c2) -> c1.getLength() - c2.getLength()).collect(Collectors.toList());
	}

	@Override
	public Cat create(Cat c) {
		this.cats.add(c);
		return this.cats.get(this.cats.size() - 1);
	}

	@Override
	public Cat update(Integer id, String name, Integer length, Boolean hasWhiskers, Boolean evil) {
		Cat toUpdate = this.cats.get(id);

		if (name != null)
			toUpdate.setName(name);
		if (length != null)
			toUpdate.setLength(length);
		if (hasWhiskers != null)
			toUpdate.setHasWhiskers(hasWhiskers);
		if (evil != null)
			toUpdate.setEvil(evil);
		return toUpdate;
	}

	@Override
	public Cat removeById(int id) {
		return this.cats.remove(id);
	}
}

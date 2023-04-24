package com.qa.demo.service;

import java.util.List;

import com.qa.demo.domain.Cat;

public interface CatService {

	public List<Cat> getAll();

	public Cat getById(int id);

	public Cat create(Cat c);

	public Cat update(Integer id, String name, Integer length, Boolean hasWhiskers, Boolean evil);

	public Cat removeById(int id);

	public List<Cat> findByName(String name);
}

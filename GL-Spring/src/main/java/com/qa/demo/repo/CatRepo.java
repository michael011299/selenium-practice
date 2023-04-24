package com.qa.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.demo.domain.Cat;

//@Repository not required unless we provide our own implementation
public interface CatRepo extends JpaRepository<Cat, Integer> {

	List<Cat> findByNameOrderByLengthAsc(String name);
}

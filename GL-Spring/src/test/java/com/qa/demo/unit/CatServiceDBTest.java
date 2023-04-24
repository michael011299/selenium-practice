package com.qa.demo.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.demo.domain.Cat;
import com.qa.demo.repo.CatRepo;
import com.qa.demo.service.CatService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CatServiceDBTest {

	@Autowired
	private CatService service;

	@MockBean
	private CatRepo repo;

	@Test
	void testCreate() {
		Cat toCreate = new Cat("barry", false, false, 12);
		Cat created = new Cat(1, "barry", false, false, 12);

		Mockito.when(this.repo.save(toCreate)).thenReturn(created);

		assertEquals(created, this.service.create(toCreate));
	}

	@Test
	void testGet() {
		int id = 1;
		Cat c = new Cat(id, "harry", false, false, 16);
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(c));

		assertEquals(c, this.service.getById(id));
	}

	@Test
	void testGetAll() {
		List<Cat> cats = List.of(new Cat(1, "harry", false, false, 16));
		Mockito.when(this.repo.findAll()).thenReturn(cats);

		assertEquals(cats, this.service.getAll());
	}

	@Test
	void testUpdate() {
		int id = 1;
		Cat existing = new Cat(id, "Tiddles", true, false, 12);
		Cat updated = new Cat(id, "Fluffy", false, true, 99);
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(existing));
		Mockito.when(this.repo.save(updated)).thenReturn(updated);

		Assertions.assertEquals(updated, this.service.update(id, updated.getName(), updated.getLength(),
				updated.isHasWhiskers(), updated.isEvil()));
	}

	@Test
	void testDelete() {
		int id = 1;
		Cat c = new Cat(id, "harry", false, false, 16);
		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(c));

		assertEquals(c, this.service.removeById(id));
	}

}

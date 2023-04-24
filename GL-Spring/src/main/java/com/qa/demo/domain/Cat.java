package com.qa.demo.domain;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private boolean hasWhiskers;
	private boolean evil;
	private Integer length;

	public Cat() {
		// TODO Auto-generated constructor stub
	}

	public Cat(String name, boolean hasWhiskers, boolean evil, Integer length) {
		super();
		this.name = name;
		this.hasWhiskers = hasWhiskers;
		this.evil = evil;
		this.length = length;
	}

	public Cat(Integer id, String name, boolean hasWhiskers, boolean evil, Integer length) {
		super();
		this.id = id;
		this.name = name;
		this.hasWhiskers = hasWhiskers;
		this.evil = evil;
		this.length = length;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isHasWhiskers() {
		return hasWhiskers;
	}

	public void setHasWhiskers(boolean hasWhiskers) {
		this.hasWhiskers = hasWhiskers;
	}

	public boolean isEvil() {
		return evil;
	}

	public void setEvil(boolean evil) {
		this.evil = evil;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	@Override
	public int hashCode() {
		return Objects.hash(evil, hasWhiskers, id, length, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		return evil == other.evil && hasWhiskers == other.hasWhiskers && Objects.equals(id, other.id)
				&& Objects.equals(length, other.length) && Objects.equals(name, other.name);
	}

}

package org.binx.utils.database.memdb.model;

import java.util.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class Column<T> {

	private String name;
	private T value;
	private List<Constraint> constraints;
	
	public Column(String name) {
		this.name = name;
		constraints = new ArrayList<>();
	}
	
	public Column(String name, T value) {
		this.name = name;
		this.value = value;
		constraints = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public List<Constraint> getConstraints() {
		return constraints;
	}
}

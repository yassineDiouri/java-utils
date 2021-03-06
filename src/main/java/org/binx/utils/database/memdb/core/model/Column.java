package org.binx.utils.database.memdb.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class Column implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private Class<?> type;
	private Integer order;
	private List<Constraint> constraints;
	
	public Column(String name, Class<?> type) {
		this.name = name;
		this.type = type;
		this.constraints = new ArrayList<>();
	}

	public Column(String name, Class<?> type, List<Constraint> constraints) {
		this.name = name;
		this.type = type;
		this.constraints = constraints;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class<?> getType() {
		return type;
	}

	public void setType(Class<?> type) {
		this.type = type;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public List<Constraint> getConstraints() {
		return constraints;
	}
}

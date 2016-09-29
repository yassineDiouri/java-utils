package org.binx.utils.database.memdb.model;

import java.util.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class Schema {

	private String name;
	private List<Table> tables;
	
	public Schema() {
		this.name = "public";
		tables = new ArrayList<>();
	}
	
	public Schema(String name) {
		this.name = name;
		tables = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Table> getTables() {
		return tables;
	}
}

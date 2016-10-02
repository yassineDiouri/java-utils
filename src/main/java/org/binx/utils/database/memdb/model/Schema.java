package org.binx.utils.database.memdb.model;

import java.util.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class Schema {

	public final static Schema DEFAULT_SCHEMA = new Schema();
	
	private String name;
	private List<Table> tables;
	
	private Schema() {
		this.name = "public";
		tables = new ArrayList<>();
	}
	
	public Schema(String name) {
		this.name = (name == null || name.equals("")) ? "public" : name;
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

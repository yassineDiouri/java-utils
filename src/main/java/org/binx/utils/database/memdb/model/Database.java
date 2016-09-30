package org.binx.utils.database.memdb.model;

import java.util.*;

import org.binx.utils.database.memdb.generator.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class Database {

	private String name;
	private List<Schema> schemas;
	
	public Database(String name) {
		this.name = name;
		schemas = new ArrayList<>();
		schemas.add(SchemaGenerator.getDefaultSchema());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Schema> getSchemas() {
		return schemas;
	}
}

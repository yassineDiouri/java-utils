package org.binx.utils.database.memdb.core.model;

import java.io.*;
import java.util.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class Schema  implements Serializable {

	private static final long serialVersionUID = 1L;

	public final static String DEFAULT_NAME = "public";
	
	private String name;
	private List<Table> tables;
	
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

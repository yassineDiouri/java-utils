package org.binx.utils.database.memdb.model;

import java.io.*;
import java.util.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class Table  implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private List<Column> columns;
	
	public Table(String name) {
		this.name = name;
		columns = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Column> getColumns() {
		return columns;
	}
}

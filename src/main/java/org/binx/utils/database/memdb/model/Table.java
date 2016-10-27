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
	private List<Line> lines;
	
	public Table(String name) {
		this.name = name;
		this.columns = new ArrayList<>();
		this.lines = new ArrayList<>();
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

	public List<Line> getLines() {
		return lines;
	}
}

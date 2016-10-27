package org.binx.utils.database.memdb.model;

import java.io.*;
import java.util.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class Line implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long index;
	private List<ColumnValue> values;
	
	public Line() {
		this.values = new ArrayList<>();
	}

	public Long getIndex() {
		return index;
	}

	public void setIndex(Long index) {
		this.index = index;
	}

	public List<ColumnValue> getValues() {
		return values;
	}
}

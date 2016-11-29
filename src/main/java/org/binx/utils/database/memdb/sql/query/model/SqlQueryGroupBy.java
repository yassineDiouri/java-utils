package org.binx.utils.database.memdb.sql.query.model;

import java.io.*;
import java.util.*;

import org.binx.utils.database.memdb.core.model.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class SqlQueryGroupBy implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Column> columns;

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}
}

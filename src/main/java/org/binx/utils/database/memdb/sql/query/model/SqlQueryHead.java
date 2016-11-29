package org.binx.utils.database.memdb.sql.query.model;

import java.io.*;
import java.util.*;

import org.binx.utils.database.memdb.core.model.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class SqlQueryHead implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private SqlQueryType type;
	private List<Table>  tables;
	private List<Column> columns;

	public SqlQueryType getType() {
		return type;
	}

	public void setType(SqlQueryType type) {
		this.type = type;
	}

	public List<Table> getTables() {
		return tables;
	}

	public void setTables(List<Table> tables) {
		this.tables = tables;
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}
}

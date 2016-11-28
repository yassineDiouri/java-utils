package org.binx.utils.database.memdb.core.manager;

import java.util.ArrayList;
import java.util.List;

import org.binx.utils.database.memdb.core.generator.TableGenerator;
import org.binx.utils.database.memdb.core.model.Column;
import org.binx.utils.database.memdb.core.model.ColumnValue;
import org.binx.utils.database.memdb.core.model.Line;
import org.binx.utils.database.memdb.core.model.Table;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class TableManager {

	/**
	 * Add table into specified database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param table
	 * @return
	 * False if table exists<br/>
	 * Null if database..schema not exists
	 */
	public static Boolean createNewTable(String databaseName, String schemaName, String tableName) {
		return SchemaManager.addTable(databaseName, schemaName, TableGenerator.getTable(tableName));
	}
	
	/**
	 * Add table into specified database..default(schema)
	 * 
	 * @param databaseName
	 * @param table
	 * @return
	 * False if table exists<br/>
	 * Null if database not exists
	 */
	public static Boolean createNewTable(String databaseName, String tableName) {
		return SchemaManager.addTable(databaseName, TableGenerator.getTable(tableName));
	}

	/**
	 * Add table into specified default(database)..schema
	 * 
	 * @param schemaName
	 * @param table
	 * @return
	 * False if table exists<br/>
	 * Null if there is no default database or schema not exist
	 */
	public static Boolean createNewTableDefaultDB(String schemaName, String tableName) {
		return SchemaManager.addTableDefaultDB(schemaName, TableGenerator.getTable(tableName));
	}

	/**
	 * Add table into specified default(database)..default(schema)
	 * 
	 * @param table
	 * @return
	 * False if table exists<br/>
	 * Null if there is no default database
	 */
	public static Boolean createNewTable(String tableName) {
		return SchemaManager.addTable(TableGenerator.getTable(tableName));
	}

	/**
	 * Get table from database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @return
	 * Null if table not exist or database..schema not exist
	 */
	public static Table getTable(String databaseName, String schemaName, String tableName) {
		return SchemaManager.getTable(databaseName, schemaName, tableName);
	}

	/**
	 * Get table from database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @return
	 * Null if table not exist or database not exist
	 */
	public static Table getTable(String databaseName, String tableName) {
		return SchemaManager.getTable(databaseName, tableName);
	}
	
	/**
	 * Get table from default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @return
	 * Null if table not exist or default(database)..schema not exists
	 */
	public static Table getTableDefaultDB(String schemaName, String tableName) {
		return SchemaManager.getTableDefaultDB(schemaName, tableName);
	}
	
	/**
	 * Get table from default(database)..default(schema)
	 * 
	 * @param tableName
	 * @return
	 * Null if table not exist or there is no default(database)
	 */
	public static Table getTable(String tableName) {
		return SchemaManager.getTable(tableName);
	}

	/**
	 * Delete Table from specified database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @return
	 * True if success<br/>
	 * False if not or table not exist<br/>
	 * Null if database..schema not exist
	 */
	public static Boolean delete(String databaseName, String schemaName, String tableName) {
		return SchemaManager.deleteTable(databaseName, schemaName, tableName);
	}
	
	/**
	 * Delete Table from specified database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @return
	 * True if success<br/>
	 * False if not or table not exist<br/>
	 * Null if database not exist
	 */
	public static Boolean delete(String databaseName, String tableName) {
		return SchemaManager.deleteTable(databaseName, tableName);
	}

	/**
	 * Delete Table from specified default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @return
	 * True if success<br/>
	 * False if not or table not exist<br/>
	 * Null if schema not exist in default database
	 */
	public static Boolean deleteDefaultDB(String schemaName, String tableName) {
		return SchemaManager.deleteTableDefaultDB(schemaName, tableName);
	}

	/**
	 * Delete Table from specified default(database)..default(schema)
	 * 
	 * @param tableName
	 * @return
	 * True if success<br/>
	 * False if not or table not exist<br/>
	 * Null if there is no dfault database
	 */
	public static Boolean delete(String tableName) {
		return SchemaManager.deleteTable(tableName);
	}
	
	/**
	 * Verify if table exists on specified database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @return
	 * True if exist<br/>
	 * else False
	 */
	public static Boolean exists(String databaseName, String schemaName, String tableName) {
		return SchemaManager.existsTable(databaseName, schemaName, tableName);
	}
	
	/**
	 * Verify if table exists on specified database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @return
	 * True if exist<br/>
	 * else False
	 */
	public static Boolean exists(String databaseName, String tableName) {
		return SchemaManager.existsTable(databaseName, tableName);
	}
	
	/**
	 * Verify if table exists on specified default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @return
	 * True if exist<br/>
	 * else False
	 */
	public static Boolean existsDefaultDB(String schemaName, String tableName) {
		return SchemaManager.existsTableDefaultDB(schemaName, tableName);
	}
	
	/**
	 * Verify if table exists on specified default(database)..default(schema)
	 * 
	 * @param tableName
	 * @return
	 * True if exist<br/>
	 * else False
	 */
	public static Boolean exists(String tableName) {
		return SchemaManager.existsTable(tableName);
	}
	
	/**
	 * add column into specified table on database..schema<br/>
	 * It make the order of new column as last index of the list of table columns
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param column
	 * @return
	 * True if added<br/>
	 * False if not<br/>
	 * null if table, schema or database not exists
	 */
	public static Boolean addColumn(String databaseName, String schemaName, String tableName, Column column) {
		if(existsColumn(databaseName, schemaName, tableName, column.getName()))
			return false;
		Table tab = getTable(databaseName, schemaName, tableName);
		if(tab != null) {
			column.setOrder(tab.getColumns().size());
			return tab.getColumns().add(column);
		}
		return null;
	}
	
	/**
	 * add column into specified table on database..default(schema)<br/>
	 * It make the order of new column as last index of the list of table columns
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param column
	 * @return
	 * True if added<br/>
	 * False if not<br/>
	 * null if table or database not exists
	 */
	public static Boolean addColumn(String databaseName, String tableName, Column column) {
		if(existsColumn(databaseName, tableName, column.getName()))
			return false;
		Table tab = getTable(databaseName, tableName);
		if(tab != null) {
			column.setOrder(tab.getColumns().size());
			return tab.getColumns().add(column);
		}
		return null;
	}

	/**
	 * add column into specified table on default(database)..schema<br/>
	 * It make the order of new column as last index of the list of table columns
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param column
	 * @return
	 * True if added<br/>
	 * False if not<br/>
	 * null if table, schema or default database not exists
	 */
	public static Boolean addColumnDefaultDB(String schemaName, String tableName, Column column) {
		if(existsColumnDefaultDB(schemaName, tableName, column.getName()))
			return false;
		Table tab = getTableDefaultDB(schemaName, tableName);
		if(tab != null) {
			column.setOrder(tab.getColumns().size());
			return tab.getColumns().add(column);
		}
		return null;
	}

	/**
	 * add column into specified table on default(database)..default(schema)<br/>
	 * It make the order of new column as last index of the list of table columns
	 * 
	 * @param tableName
	 * @param column
	 * @return
	 * True if added<br/>
	 * False if not<br/>
	 * null if table or default database not exists
	 */
	public static Boolean addColumn(String tableName, Column column) {
		if(existsColumn(tableName, column.getName()))
			return false;
		Table tab = getTable(tableName);
		if(tab != null) {
			column.setOrder(tab.getColumns().size());
			return tab.getColumns().add(column);
		}
		return null;
	}
	
	/**
	 * Get Column with name from specified table on database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @return
	 * Null if table not exist or database..schema not exist
	 */
	public static Column getColumn(String databaseName, String schemaName, String tableName, String columnName) {
		if(existsColumn(databaseName, schemaName, tableName, columnName)) {
			for(Column col : getAllColumns(databaseName, schemaName, tableName))
				if(col.getName().equals(columnName))
					return col;
		}
		return null;
	}

	/**
	 * Get Column with name from specified table on database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param columnName
	 * @return
	 * Null if table or database not exist
	 */
	public static Column getColumn(String databaseName, String tableName, String columnName) {
		if(existsColumn(databaseName, tableName, columnName)) {
			for (Column col : getAllColumns(databaseName, tableName))
				if(col.getName().equals(columnName))
					return col;
		}
		return null;
	}
	
	/**
	 * Get Column with name from specified table on default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @return
	 * Null if table or schema not exist, or no default database
	 */
	public static Column getColumnDefaultDB(String schemaName, String tableName, String columnName) {
		if(existsColumnDefaultDB(schemaName, tableName, columnName)) {
			for(Column col : getAllColumnsDefaultDB(schemaName, tableName))
				if(col.getName().equals(columnName))
					return col;
		}
		return null;
	}

	/**
	 * Get Column with name from specified table on default(database)..default(schema)
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @return
	 * Null if table not exist, or no default database
	 */
	public static Column getColumn(String tableName, String columnName) {
		if(existsColumn(tableName, columnName)) {
			for(Column col : getAllColumns(tableName))
				if(col.getName().equals(columnName))
					return col;
		}
		return null;
	}
	
	/**
	 * Get Column with order from specified table on database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnOrder
	 * @return
	 * Null if table not exist or database..schema not exist
	 */
	public static Column getColumn(String databaseName, String schemaName, String tableName, Integer columnOrder) {
		if(columnOrder >= 0 && columnOrder < countColumns(databaseName, schemaName, tableName)) {
			for(Column col : getAllColumns(databaseName, schemaName, tableName))
				if(col.getOrder().equals(columnOrder))
					return col;
		}
		return null;
	}
	
	/**
	 * Get Column with order from specified table on database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param columnOrder
	 * @return
	 * Null if table or database not exist
	 */
	public static Column getColumn(String databaseName, String tableName, Integer columnOrder) {
		if(columnOrder >= 0 && columnOrder < countColumns(databaseName, tableName)) {
			for(Column col : getAllColumns(databaseName, tableName))
				if(col.getOrder().equals(columnOrder))
					return col;
		}
		return null;
	}
	
	/**
	 * Get Column with order from specified table on default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param columnOrder
	 * @return
	 * Null if table or schema not exist, or no default database
	 */
	public static Column getColumnDefaultDB(String schemaName, String tableName, Integer columnOrder) {
		if(columnOrder >= 0 && columnOrder < countColumnsDefaultDB(schemaName, tableName)) {
			for(Column col : getAllColumnsDefaultDB(schemaName, tableName))
				if(col.getOrder().equals(columnOrder))
					return col;
		}
		return null;
	}
	
	/**
	 * Get Column with order from specified table on default(database)..default(schema)
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param columnOrder
	 * @return
	 * Null if table not exist, or no default database
	 */
	public static Column getColumn(String tableName, Integer columnOrder) {
		if(columnOrder >= 0 && columnOrder < countColumns(tableName)) {
			for(Column col : getAllColumns(tableName))
				if(col.getOrder().equals(columnOrder))
					return col;
		}
		return null;
	}
	
	/**
	 * Return List of Columns from specified table on database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @return
	 * Null if table or database..schema not exist
	 */
	public static List<Column> getAllColumns(String databaseName, String schemaName, String tableName) {
		if(exists(databaseName, schemaName, tableName)) {
			return getTable(databaseName, schemaName, tableName).getColumns();
		}
		return null;
	}

	/**
	 * Return List of Columns from specified table on database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @return
	 * Null if table or database not exist
	 */
	public static List<Column> getAllColumns(String databaseName, String tableName) {
		if(exists(databaseName, tableName)) {
			return getTable(databaseName, tableName).getColumns();
		}
		return null;
	}
	
	/**
	 * Return List of Columns from specified table on default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @return
	 * Null if table or schema not exist or no default database
	 */
	public static List<Column> getAllColumnsDefaultDB(String schemaName, String tableName) {
		if(existsDefaultDB(schemaName, tableName)) {
			return getTableDefaultDB(schemaName, tableName).getColumns();
		}
		return null;
	}

	
	/**
	 * Return List of Columns from specified table on default(database)..default(schema)
	 * 
	 * @param schemaName
	 * @param tableName
	 * @return
	 * Null if table not exist or no default database
	 */
	public static List<Column> getAllColumns(String tableName) {
		if(exists(tableName)) {
			return getTable(tableName).getColumns();
		}
		return null;
	}
	
	/**
	 * Remove Column from specified table on database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @return
	 * True if removed<br/>
	 * False if not<br/>
	 * Null if table, schema or database not exists
	 */
	public static Boolean deleteColumn(String databaseName, String schemaName, String tableName, String columnName) {
		if(exists(databaseName, schemaName, tableName)) {
			for(Column col : getAllColumns(databaseName, schemaName, tableName)) {
				if(col.getName().equals(columnName)) {
					return getAllColumns(databaseName, schemaName, tableName).remove(col);
				}
			}
		}
		return null;
	}
	
	/**
	 * Remove Column from specified table on database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param columnName
	 * @return
	 * True if removed<br/>
	 * False if not<br/>
	 * Null if table or database not exists
	 */
	public static Boolean deleteColumn(String databaseName, String tableName, String columnName) {
		if(exists(databaseName, tableName)) {
			for(Column col : getAllColumns(databaseName, tableName)) {
				if(col.getName().equals(columnName)) {
					return getAllColumns(databaseName, tableName).remove(col);
				}
			}
		}
		return null;
	}
	
	/**
	 * Remove Column from specified table on default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @return
	 * True if removed<br/>
	 * False if not<br/>
	 * Null if table or schema not exists, or there is no default databse
	 */
	public static Boolean deleteColumnDefaultDB(String schemaName, String tableName, String columnName) {
		if(existsDefaultDB(schemaName, tableName)) {
			for(Column col : getAllColumnsDefaultDB(schemaName, tableName)) {
				if(col.getName().equals(columnName)) {
					return getAllColumnsDefaultDB(schemaName, tableName).remove(col);
				}
			}
		}
		return null;
	}
	
	/**
	 * Remove Column from specified table on default(database)..default(schema)
	 * 
	 * @param tableName
	 * @param columnName
	 * @return
	 * True if removed<br/>
	 * False if not<br/>
	 * Null if table not exists, or there is no default databse
	 */
	public static Boolean deleteColumn(String tableName, String columnName) {
		if(exists(tableName)) {
			for(Column col : getAllColumns(tableName)) {
				if(col.getName().equals(columnName)) {
					return getAllColumns(tableName).remove(col);
				}
			}
		}
		return null;
	}
	
	/**
	 * Verify if column exists on specified table in database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @return
	 * True if exist<br/>
	 * else False
	 */
	public static Boolean existsColumn(String databaseName, String schemaName, String tableName, String columnName) {
		List<String> names = getAllNamesColumns(databaseName, schemaName, tableName);
		if(names != null) {
			if(names.contains(columnName)) return true;
		}
		return false;
	}

	/**
	 * Verify if column exists on specified table in database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param columnName
	 * @return
	 * True if exist<br/>
	 * else False
	 */
	public static Boolean existsColumn(String databaseName, String tableName, String columnName) {
		List<String> names = getAllNamesColumns(databaseName, tableName);
		if(names != null) {
			if(names.contains(columnName)) return true;
		}
		return false;
	}

	/**
	 * Verify if column exists on specified table in default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param columnName
	 * @return
	 * True if exist<br/>
	 * else False
	 */
	public static Boolean existsColumnDefaultDB(String schemaName, String tableName, String columnName) {
		List<String> names = getAllNamesColumnsDefaultDB(schemaName, tableName);
		if(names != null) {
			if(names.contains(columnName)) return true;
		}
		return false;
	}

	/**
	 * Verify if column exists on specified table in default(database)..default(schema)
	 * 
	 * @param tableName
	 * @param columnName
	 * @return
	 * True if exist<br/>
	 * else False
	 */
	public static Boolean existsColumn(String tableName, String columnName) {
		List<String> names = getAllNamesColumns(tableName);
		if(names != null) {
			if(names.contains(columnName)) return true;
		}
		return false;
	}
	
	/**
	 * Get number of columns in specified table on database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @return
	 * -1 if table, schema or database not exist
	 */
	public static Integer countColumns(String databaseName, String schemaName, String tableName) {
		Table tab = getTable(databaseName, schemaName, tableName);
		if(tab != null)
			return tab.getColumns().size();
		return -1;
	}
	
	/**
	 * Get number of columns in specified table on database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @return
	 * -1 if table or database not exist
	 */
	public static Integer countColumns(String databaseName, String tableName) {
		Table tab = getTable(databaseName, tableName);
		if(tab != null)
			return tab.getColumns().size();
		return -1;
	}
	
	/**
	 * Get number of columns in specified table on default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @return
	 * -1 if table, schema or default database not exist
	 */
	public static Integer countColumnsDefaultDB(String schemaName, String tableName) {
		Table tab = getTableDefaultDB(schemaName, tableName);
		if(tab != null)
			return tab.getColumns().size();
		return -1;
	}
	
	/**
	 * Get number of columns in specified table on default(database)..default(schema)
	 * 
	 * @param schemaName
	 * @param tableName
	 * @return
	 * -1 if table or default database not exist
	 */
	public static Integer countColumns(String tableName) {
		Table tab = getTable(tableName);
		if(tab != null)
			return tab.getColumns().size();
		return -1;
	}
	
	/**
	 * List all names of existing columns on specified table from database..schema
	 * 
	 * @return
	 * List of names
	 */
	public static List<String> getAllNamesColumns(String databaseName, String schemaName, String tableName) {
		List<String> names = new ArrayList<>();
		if(exists(databaseName, schemaName, tableName)) {
			for(Column col : getTable(databaseName, schemaName, tableName).getColumns()) {
				names.add(col.getName());
			}
			return names;
		}
		return null;
	}

	/**
	 * List all names of existing columns on specified table from database..default(schema)
	 * 
	 * @return
	 * List of names
	 */
	public static List<String> getAllNamesColumns(String databaseName, String tableName) {
		List<String> names = new ArrayList<>();
		if(exists(databaseName, tableName)) {
			for(Column col : getTable(databaseName, tableName).getColumns()) {
				names.add(col.getName());
			}
			return names;
		}
		return null;
	}

	/**
	 * List all names of existing columns on specified table from default(database)..schema
	 * 
	 * @return
	 * List of names
	 */
	public static List<String> getAllNamesColumnsDefaultDB(String schemaName, String tableName) {
		List<String> names = new ArrayList<>();
		if(existsDefaultDB(schemaName, tableName)) {
			for(Column col : getTableDefaultDB(schemaName, tableName).getColumns()) {
				names.add(col.getName());
			}
			return names;
		}
		return null;
	}

	/**
	 * List all names of existing columns on specified table from default(database)..default(schema)
	 * 
	 * @return
	 * List of names
	 */
	public static List<String> getAllNamesColumns(String tableName) {
		List<String> names = new ArrayList<>();
		if(exists(tableName)) {
			for(Column col : getTable(tableName).getColumns()) {
				names.add(col.getName());
			}
			return names;
		}
		return null;
	}
	
	/**
	 * Add line into specified table on database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param line
	 * @return
	 * True if added<br/>
	 * False if not<br/>
	 * Null if table do not contains columns or if table, schema or database not exists
	 */
	public static Boolean addLine(String databaseName, String schemaName, String tableName, Line line) {
		Table tab = getTable(databaseName, schemaName, tableName);
		if(tab != null && tab.getColumns().size() > 0) {
			line.setIndex(getLastLineIndex(databaseName, schemaName, tableName) + 1);
			for(ColumnValue columnValue : line.getValues()){
				columnValue.setIndex(line.getIndex());
			}
			return tab.getLines().add(line);
		}
		return null;
	}
	
	/**
	 * Add line into specified table on database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param line
	 * @return
	 * True if added<br/>
	 * False if not<br/>
	 * Null if table do not contains columns or if table or database not exists
	 */
	public static Boolean addLine(String databaseName, String tableName, Line line) {
		Table tab = getTable(databaseName, tableName);
		if(tab != null && tab.getColumns().size() > 0) {
			line.setIndex(getLastLineIndex(databaseName, tableName) + 1);
			for(ColumnValue columnValue : line.getValues()){
				columnValue.setIndex(line.getIndex());
			}
			return tab.getLines().add(line);
		}
		return null;
	}
	
	/**
	 * Add line into specified table on default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param line
	 * @return
	 * True if added<br/>
	 * False if not<br/>
	 * Null if table do not contains columns or if table, schema or default database not exists
	 */
	public static Boolean addLineDefaultDB(String schemaName, String tableName, Line line) {
		Table tab = getTableDefaultDB(schemaName, tableName);
		if(tab != null && tab.getColumns().size() > 0) {
			line.setIndex(getLastLineIndexDefaultDB(schemaName, tableName) + 1);
			for(ColumnValue columnValue : line.getValues()){
				columnValue.setIndex(line.getIndex());
			}
			return tab.getLines().add(line);
		}
		return null;
	}
	
	/**
	 * Add line into specified table on default(database)..default(schema)
	 * 
	 * @param tableName
	 * @param line
	 * @return
	 * True if added<br/>
	 * False if not<br/>
	 * Null if table do not contains columns or if table or default database not exists
	 */
	public static Boolean addLine(String tableName, Line line) {
		Table tab = getTable(tableName);
		if(tab != null && tab.getColumns().size() > 0) {
			line.setIndex(getLastLineIndex(tableName) + 1);
			for(ColumnValue columnValue : line.getValues()){
				columnValue.setIndex(line.getIndex());
			}
			return tab.getLines().add(line);
		}
		return null;
	}
	
	/**
	 * Get Line on index from specified table on database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param index
	 * @return
	 * Null if table not exist or database..schema not exist
	 */
	public static Line getLine(String databaseName, String schemaName, String tableName, Long index) {
		if(index >= 0 && index < countLines(databaseName, schemaName, tableName)) {
			for(Line line : getAllLines(databaseName, schemaName, tableName))
				if(line.getIndex().equals(index))
					return line;
		}
		return null;
	}
	
	/**
	 * Get Line on index from specified table on database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param index
	 * @return
	 * Null if table or database not exist
	 */
	public static Line getLine(String databaseName, String tableName, Long index) {
		if(index >= 0 && index < countLines(databaseName, tableName)) {
			for(Line line : getAllLines(databaseName, tableName))
				if(line.getIndex().equals(index))
					return line;
		}
		return null;
	}
	
	/**
	 * Get Line on index from specified table on default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param index
	 * @return
	 * Null if table or schema not exist, or no default database
	 */
	public static Line getLineDefaultDB(String schemaName, String tableName, Long index) {
		if(index >= 0 && index < countLinesDefaultDB(schemaName, tableName)) {
			for(Line line : getAllLinesDefaultDB(schemaName, tableName))
				if(line.getIndex().equals(index))
					return line;
		}
		return null;
	}
	
	/**
	 * Get Line on index from specified table on default(database)..default(schema)
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param index
	 * @return
	 * Null if table not exist, or no default database
	 */
	public static Line getLine(String tableName, Long index) {
		if(index >= 0 && index < countLines(tableName)) {
			for(Line line : getAllLines(tableName))
				if(line.getIndex().equals(index))
					return line;
		}
		return null;
	}
	
	/**
	 * Return List of Lines from specified table on database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @return
	 * Null if table or database..schema not exist
	 */
	public static List<Line> getAllLines(String databaseName, String schemaName, String tableName) {
		if(exists(databaseName, schemaName, tableName)) {
			return getTable(databaseName, schemaName, tableName).getLines();
		}
		return null;
	}
	
	/**
	 * Return List of Lines from specified table on database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @return
	 * Null if table or database not exist
	 */
	public static List<Line> getAllLines(String databaseName, String tableName) {
		if(exists(databaseName, tableName)) {
			return getTable(databaseName, tableName).getLines();
		}
		return null;
	}
	
	/**
	 * Return List of Lines from specified table on default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @return
	 * Null if table or schema not exist or no default database
	 */
	public static List<Line> getAllLinesDefaultDB(String schemaName, String tableName) {
		if(existsDefaultDB(schemaName, tableName)) {
			return getTableDefaultDB(schemaName, tableName).getLines();
		}
		return null;
	}
	
	/**
	 * Return List of Lines from specified table on default(database)..default(schema)
	 * 
	 * @param schemaName
	 * @param tableName
	 * @return
	 * Null if table not exist or no default database
	 */
	public static List<Line> getAllLines(String tableName) {
		if(exists(tableName)) {
			return getTable(tableName).getLines();
		}
		return null;
	}
	
	/**
	 * Remove line from specified table on database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @param index
	 * @return
	 * Null if table not exist or no default database
	 */
	public static Boolean deleteLine(String databaseName, String schemaName, String tableName, Long index) {
		if(index >= 0 && index < countLines(databaseName, schemaName, tableName)) {
			List<Line> lines = getAllLines(databaseName, schemaName, tableName);
			for(Line line : lines) {
				if(line.getIndex().equals(index))
					return lines.remove(line);
			}
		}
		return null;
	}
	
	/**
	 * Remove line from specified table on database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @param index
	 * @return
	 * Null if table or database not exist
	 */
	public static Boolean deleteLine(String databaseName, String tableName, Long index) {
		if(index >= 0 && index < countLines(databaseName, tableName)) {
			List<Line> lines = getAllLines(databaseName, tableName);
			for(Line line : lines) {
				if(line.getIndex().equals(index))
					return lines.remove(line);
			}
		}
		return null;
	}
	
	/**
	 * Remove line from specified table on default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @param index
	 * @return
	 * Null if table or schema not exist or no default database
	 */
	public static Boolean deleteLineDefaultDB(String schemaName, String tableName, Long index) {
		if(index >= 0 && index < countLinesDefaultDB(schemaName, tableName)) {
			List<Line> lines = getAllLinesDefaultDB(schemaName, tableName);
			for(Line line : lines) {
				if(line.getIndex().equals(index))
					return lines.remove(line);
			}
		}
		return null;
	}
	
	/**
	 * Remove line from specified table on default(database)..default(schema)
	 * 
	 * @param tableName
	 * @param index
	 * @return
	 * Null if table not exist or no default database
	 */
	public static Boolean deleteLine(String tableName, Long index) {
		if(index >= 0 && index < countLines(tableName)) {
			List<Line> lines = getAllLines(tableName);
			for(Line line : lines) {
				if(line.getIndex().equals(index))
					return lines.remove(line);
			}
		}
		return null;
	}
	
	/**
	 * Get number of lines in specified table on database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @return
	 * -1 if table, schema or database not exist
	 */
	public static Long countLines(String databaseName, String schemaName, String tableName) {
		Table tab = getTable(databaseName, schemaName, tableName);
		if(tab != null)
			return (long) tab.getLines().size();
		return -1L;
	}
	
	/**
	 * Get number of lines in specified table on database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @return
	 * -1 if table or database not exist
	 */
	public static Long countLines(String databaseName, String tableName) {
		Table tab = getTable(databaseName, tableName);
		if(tab != null)
			return (long) tab.getLines().size();
		return -1L;
	}
	
	/**
	 * Get number of lines in specified table on default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @return
	 * -1 if table, schema or default database not exist
	 */
	public static Long countLinesDefaultDB(String schemaName, String tableName) {
		Table tab = getTableDefaultDB(schemaName, tableName);
		if(tab != null)
			return (long) tab.getLines().size();
		return -1L;
	}
	
	/**
	 * Get number of lines in specified table on default(database)..default(schema)
	 * 
	 * @param schemaName
	 * @param tableName
	 * @return
	 * -1 if table or default database not exist
	 */
	public static Long countLines(String tableName) {
		Table tab = getTable(tableName);
		if(tab != null)
			return (long) tab.getLines().size();
		return -1L;
	}
	
	/**
	 * Used to get the last index of current table
	 * @param databaseName
	 * @param schemaName
	 * @param tableName
	 * @return
	 * last index
	 */
	private static Long getLastLineIndex(String databaseName, String schemaName, String tableName) {
		List<Line> lines = getAllLines(databaseName, schemaName, tableName);
		if(lines.size() == 0) return -1L;
		return lines.get(lines.size() - 1).getIndex();
	}
	
	/**
	 * Used to get the last index of current table
	 * 
	 * @param databaseName
	 * @param tableName
	 * @return
	 * last index
	 */
	private static Long getLastLineIndex(String databaseName, String tableName) {
		List<Line> lines = getAllLines(databaseName, tableName);
		if(lines.size() == 0) return -1L;
		return lines.get(lines.size() - 1).getIndex();
	}
	
	/**
	 * Used to get the last index of current table
	 * 
	 * @param schemaName
	 * @param tableName
	 * @return
	 * last index
	 */
	private static Long getLastLineIndexDefaultDB(String schemaName, String tableName) {
		List<Line> lines = getAllLinesDefaultDB(schemaName, tableName);
		if(lines.size() == 0) return -1L;
		return lines.get(lines.size() - 1).getIndex();
	}
	
	/**
	 * Used to get the last index of current table
	 * 
	 * @param tableName
	 * @return
	 * last index
	 */
	private static Long getLastLineIndex(String tableName) {
		List<Line> lines = getAllLines(tableName);
		if(lines.size() == 0) return -1L;
		return lines.get(lines.size() - 1).getIndex();
	}
}

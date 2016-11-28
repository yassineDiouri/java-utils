package org.binx.utils.database.memdb.core.manager;

import java.util.ArrayList;
import java.util.List;

import org.binx.utils.database.memdb.core.generator.SchemaGenerator;
import org.binx.utils.database.memdb.core.model.Schema;
import org.binx.utils.database.memdb.core.model.Table;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class SchemaManager {

	/**
	 * Create new Schema into specified database
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @return
	 * False if schema given is null<br/>
	 * True if success to be added<br/>
	 * Null if database not exists
	 */
	public static Boolean createNewSchema(String databaseName, String schemaName) {
		return DatabaseManager.addSchema(databaseName, SchemaGenerator.getSchema(schemaName));
	}
	
	/**
	 * Create new Schema into default database
	 * 
	 * @param schemaName
	 * @return
	 * False if schema given is null<br/>
	 * True if success to be added<br/>
	 * Null if there is no default database
	 */
	public static Boolean createNewSchema(String schemaName) {
		return DatabaseManager.addSchema(SchemaGenerator.getSchema(schemaName));
	}
	
	/**
	 * Return Schema with specified name from database "name"
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @return
	 * Specified Schema with name if exist<br/>
	 * else return default schema<br/>
	 * Null if database not exists
	 */
	public static Schema getSchema(String databaseName, String schemaName) {
		return DatabaseManager.getSchema(databaseName, schemaName);
	}
	
	/**
	 * Return Schema with specified name from default database
	 * 
	 * @param schemaName
	 * @return
	 * Specified Schema with name if exist<br/>
	 * else return default schema<br/>
	 * Null if there is no default database
	 */
	public static Schema getSchema(String schemaName) {
		return DatabaseManager.getSchema(schemaName);
	}
	
	/**
	 * Return Default Schema from specified database
	 * 
	 * @param databaseName
	 * @return
	 * Null if database not exists
	 */
	public static Schema getDefault(String databaseName) {
		return DatabaseManager.getDefaultSchema(databaseName);
	}
	
	/**
	 * Return Default Schema from default database
	 * 
	 * @return
	 * Null if there is no default database
	 */
	public static Schema getDefault() {
		return DatabaseManager.getDefaultSchema();
	}
	
	/**
	 * Delete schema from specified database
	 * 
	 * @param databaseName
	 * @param name
	 * @return
	 * False if not delete, not exist schema or name is default schema<br/>
	 * else True<br/>
	 * Null if database not exists
	 */
	public static Boolean delete(String databaseName, String schemaName) {
		return DatabaseManager.deleteSchema(databaseName, schemaName);
	}
	
	/**
	 * Delete schema from default database
	 * 
	 * @param databaseName
	 * @param name
	 * @return
	 * False if not delete, not exist schema or name is default schema<br/>
	 * else True<br/>
	 * Null if there is no default database
	 */
	public static Boolean delete(String schemaName) {
		return DatabaseManager.deleteSchema(schemaName);
	}
	
	/**
	 * Verify if database contains specified schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @return
	 * True if exist<br/>
	 * else False
	 */
	public static Boolean exists(String databaseName, String schemaName) {
		return DatabaseManager.existsSchema(databaseName, schemaName);
	}
	
	/**
	 * Verify if schema given exists on default database 
	 * 
	 * @param schemaName
	 * @return
	 * True if exist<br/>
	 * else False
	 */
	public static Boolean exists(String schemaName) {
		return DatabaseManager.existsSchema(schemaName);
	}
	
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
	public static Boolean addTable(String databaseName, String schemaName, Table table) {
		if(exists(databaseName, schemaName)) {
			if(table != null && !existsTable(databaseName, schemaName, table.getName())
					&& !table.getName().trim().equals("")) {
				return getAllTables(databaseName, schemaName).add(table);
			}
			return false;
		} else 
			return null;
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
	public static Boolean addTable(String databaseName, Table table) {
		Schema defaultSC = getDefault(databaseName);
		if(defaultSC != null) {
			if(table != null && !existsTable(databaseName, table.getName())
					&& !table.getName().trim().equals("")) {
				return getAllTables(databaseName).add(table);
			}
			return false;
		} else 
			return null;
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
	public static Boolean addTableDefaultDB(String schemaName, Table table) {
		if(exists(schemaName)) {
			if(table != null && !existsTableDefaultDB(schemaName, table.getName())
					&& !table.getName().trim().equals("")) {
				return getAllTablesDefaultDB(schemaName).add(table);
			}
			return false;
		} else 
			return null;
	}
	
	/**
	 * Add table into specified default(database)..default(schema)
	 * 
	 * @param table
	 * @return
	 * False if table exists<br/>
	 * Null if there is no default database
	 */
	public static Boolean addTable(Table table) {
		Schema defaultSC = getDefault();
		if(defaultSC != null) {
			if(table != null && !existsTable(table.getName())
					&& !table.getName().trim().equals("")) {
				return getAllTables().add(table);
			}
			return false;
		} else 
			return null;
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
	public static Table getTable(String databaseName, String schemaName, String tableName)  {
		if(existsTable(databaseName, schemaName, tableName)) {
			for(Table tab : getAllTables(databaseName, schemaName)) {
				if(tab.getName().equals(tableName))
					return tab;
			}
		}
		return null;
	}
	
	/**
	 * Get table from database..default(schema)
	 * 
	 * @param databaseName
	 * @param tableName
	 * @return
	 * Null if table not exist or database not exist
	 */
	public static Table getTable(String databaseName, String tableName)  {
		if(existsTable(databaseName, tableName)) {
			for(Table tab : getAllTables(databaseName)) {
				if(tab.getName().equals(tableName))
					return tab;
			}
		}
		return null;
	}
	
	/**
	 * Get table from default(database)..schema
	 * 
	 * @param schemaName
	 * @param tableName
	 * @return
	 * Null if table not exist or default(database)..schema not exists
	 */
	public static Table getTableDefaultDB(String schemaName, String tableName)  {
		if(existsTableDefaultDB(schemaName, tableName)) {
			for(Table tab : getAllTablesDefaultDB(schemaName)) {
				if(tab.getName().equals(tableName))
					return tab;
			}
		}
		return null;
	}
	
	/**
	 * Get table from default(database)..default(schema)
	 * 
	 * @param tableName
	 * @return
	 * Null if table not exist or there is no default(database)
	 */
	public static Table getTable(String tableName)  {
		if(existsTable(tableName)) {
			for(Table tab : getAllTables()) {
				if(tab.getName().equals(tableName))
					return tab;
			}
		}
		return null;
	}
	
	/**
	 * Return List of Tables on specified database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @return
	 * Null if database..schema not exist
	 */
	public static List<Table> getAllTables(String databaseName, String schemaName) {
		if(exists(databaseName, schemaName))
			return getSchema(databaseName, schemaName).getTables();
		return null;
	}
	
	/**
	 * Return List of Tables on specified database..default(schema)
	 * 
	 * @param databaseName
	 * @return
	 * Null if database not exist
	 */
	public static List<Table> getAllTables(String databaseName) {
		Schema defaultSC = getDefault(databaseName);
		if(defaultSC != null)
			return defaultSC.getTables();
		return null;
	}
	
	/**
	 * Return List of Tables on specified default(database)..schema
	 * 
	 * @param schemaName
	 * @return
	 * Null if no default(database)..schema
	 */
	public static List<Table> getAllTablesDefaultDB(String schemaName) {
		if(exists(schemaName))
			return getSchema(schemaName).getTables();
		return null;
	}
	
	/**
	 * Return List of Tables on specified default(database)..default(schema)
	 * 
	 * @return
	 * Null if no default(database)
	 */
	public static List<Table> getAllTables() {
		Schema defaultSC = getDefault();
		if(defaultSC != null)
			return defaultSC.getTables();
		return null;
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
	public static Boolean deleteTable(String databaseName, String schemaName, String tableName) {
		if(exists(databaseName, schemaName)) {
			for(Table tab : getAllTables(databaseName, schemaName)) {
				if(tab.getName().equals(tableName)) {
					return getAllTables(databaseName, schemaName).remove(tab);
				}
			}
			return false;
		}
		return null;
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
	public static Boolean deleteTable(String databaseName, String tableName) {
		Schema defaultSC = getDefault(databaseName);
		if(defaultSC != null) {
			for(Table tab : getAllTables(databaseName)) {
				if(tab.getName().equals(tableName)) {
					return getAllTables(databaseName).remove(tab);
				}
			}
			return false;
		}
		return null;
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
	public static Boolean deleteTableDefaultDB(String schemaName, String tableName) {
		if(exists(schemaName)) {
			for(Table tab : getAllTablesDefaultDB(schemaName)) {
				if(tab.getName().equals(tableName)) {
					return getAllTablesDefaultDB(schemaName).remove(tab);
				}
			}
			return false;
		}
		return null;
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
	public static Boolean deleteTable(String tableName) {
		Schema defaultSC = getDefault();
		if(defaultSC != null) {
			for(Table tab : getAllTables()) {
				if(tab.getName().equals(tableName)) {
					return getAllTables().remove(tab);
				}
			}
			return false;
		}
		return null;
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
	public static Boolean existsTable(String databaseName, String schemaName, String tableName) {
		if(exists(databaseName, schemaName)
				&& getAllNamesTables(databaseName, schemaName).contains(tableName))
			return true;
		return false;
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
	public static Boolean existsTable(String databaseName, String tableName) {
		List<String> names = getAllNamesTables(databaseName);
		if(names != null && names.contains(tableName))
			return true;
		return false;
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
	public static Boolean existsTableDefaultDB(String schemaName, String tableName) {
		if(exists(schemaName)
				&& getAllNamesTablesDefaultDB(schemaName).contains(tableName))
			return true;
		return false;
	}
	
	/**
	 * Verify if table exists on specified default(database)..default(schema)
	 * 
	 * @param tableName
	 * @return
	 * True if exist<br/>
	 * else False
	 */
	public static Boolean existsTable(String tableName) {
		List<String> names = getAllNamesTables();
		if(names != null && names.contains(tableName))
			return true;
		return false;
	}
	
	/**
	 * List all names of existing tables on specified database..schema
	 * 
	 * @return
	 * List of names
	 */
	public static List<String> getAllNamesTables(String databaseName, String schemaName) {
		List<String> names = new ArrayList<>();
		if(exists(databaseName, schemaName)) {
			for(Table tab : getSchema(databaseName, schemaName).getTables()) {
				names.add(tab.getName());
			}
			return names;
		}
		return null;
	}
	
	/**
	 * List all names of existing tables on specified database..default(schema)
	 * 
	 * @return
	 * List of names
	 */
	public static List<String> getAllNamesTables(String databaseName) {
		List<String> names = new ArrayList<>();
		Schema defaultSC = getDefault(databaseName);
		if(defaultSC != null) {
			for(Table tab : defaultSC.getTables()) {
				names.add(tab.getName());
			}
			return names;
		}
		return null;
	}
	
	/**
	 * List all names of existing tables on specified default(database)..schema
	 * 
	 * @return
	 * List of names
	 */
	public static List<String> getAllNamesTablesDefaultDB(String schemaName) {
		List<String> names = new ArrayList<>();
		if(exists(schemaName)) {
			for(Table tab : getSchema(schemaName).getTables()) {
				names.add(tab.getName());
			}
			return names;
		}
		return null;
	}
	
	/**
	 * List all names of existing tables on specified default(database)..default(schema)
	 * 
	 * @return
	 * List of names
	 */
	public static List<String> getAllNamesTables() {
		List<String> names = new ArrayList<>();
		Schema defaultSC = getDefault();
		if(defaultSC != null) {
			for(Table tab : defaultSC.getTables()) {
				names.add(tab.getName());
			}
			return names;
		}
		return null;
	}
	
	/**
	 * get number of tables on specified database..schema
	 * 
	 * @param databaseName
	 * @param schemaName
	 * @return
	 * -1 : if database..schema not exists
	 */
	public static Integer countTables(String databaseName, String schemaName) {
		return exists(databaseName, schemaName) ? getAllTables(databaseName, schemaName).size() : -1;
	}
	
	/**
	 * get number of tables on specified database..default(schema)
	 * 
	 * @param databaseName
	 * @return
	 * -1 : if database not exists
	 */
	public static Integer countTables(String databaseName) {
		return getDefault(databaseName) != null ? getAllTables(databaseName).size() : -1;
	}
	
	/**
	 * get number of tables on specified default(database)..schema
	 * 
	 * @param schemaName
	 * @return
	 * -1 : if schema not exists in default database
	 */
	public static Integer countTablesDefaultDB(String schemaName) {
		return exists(schemaName) ? getAllTablesDefaultDB(schemaName).size() : -1;
	}
	
	/**
	 * get number of tables on specified default(database)..default(schema)
	 * 
	 * @return
	 * -1 : if there is no default database
	 */
	public static Integer countTables() {
		return getDefault() != null ? getAllTables().size() : -1;
	}
}

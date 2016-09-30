package org.binx.utils.database.memdb.model;

import java.util.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class DatabaseList {

	private List<Database> databases;
	private Integer defaultDatabase;
	
	public DatabaseList(){
		databases = new ArrayList<>();
		defaultDatabase = -1;
	}

	public Integer getDefaultDatabase() {
		return defaultDatabase;
	}

	public void setDefaultDatabase(Integer defaultDatabase) {
		this.defaultDatabase = defaultDatabase;
	}

	public void setDatabases(List<Database> databases) {
		this.databases = databases;
	}

	public List<Database> getDatabases() {
		return databases;
	}
}

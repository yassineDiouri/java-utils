package org.binx.utils.database.memdb.model;

import java.io.*;
import java.util.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class DatabaseList  implements Serializable {

	private static final long serialVersionUID = 1L;

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

	public List<Database> getDatabases() {
		return databases;
	}
}

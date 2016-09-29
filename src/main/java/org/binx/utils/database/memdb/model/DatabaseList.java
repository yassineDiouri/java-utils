package org.binx.utils.database.memdb.model;

import java.util.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class DatabaseList {

	private List<Database> databases;
	
	public DatabaseList(){
		databases = new ArrayList<>();
	}
	
	public List<Database> getDatabases() {
		return databases;
	}
}

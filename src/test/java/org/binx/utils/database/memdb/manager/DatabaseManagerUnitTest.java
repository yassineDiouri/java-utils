package org.binx.utils.database.memdb.manager;

import junit.framework.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class DatabaseManagerUnitTest extends TestCase {

	private String name;
	private String emptyName;
	
	@Override
	protected void setUp() throws Exception {
		DatabaseListManager.getDatabaseList();
		name = " newDb ";
		emptyName = " ";
	}
	
	public void testCreateNewDatabaseReturnFalse() {
		assertFalse(DatabaseManager.createNewDatabase(emptyName));
	}
	
	public void testCreateNewDatabaseReturnTrue() {
		assertTrue(DatabaseManager.createNewDatabase(name));
	}
}

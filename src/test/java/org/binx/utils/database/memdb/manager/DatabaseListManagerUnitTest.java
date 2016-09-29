package org.binx.utils.database.memdb.manager;

import org.binx.utils.database.memdb.model.*;

import junit.framework.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class DatabaseListManagerUnitTest extends TestCase {

	private Database db;
	private Database existsDb;
	private Database notExistsDb;
	private Database dbNameEmpty;
	
	@Override
	protected void setUp() {
		db = new Database("testDB");
		existsDb = new Database("testDB");
		notExistsDb = new Database("notExistDB");
		dbNameEmpty = new Database("");
	}
	
	public void testGetDatabaseListReturnNotNull() {
		assertNotNull(DatabaseListManager.getDatabaseList());
	}
	
	public void testGetDatabaseListReturnDatabaseListClass() {
		assertEquals(DatabaseListManager.getDatabaseList().getClass(), DatabaseList.class);
	}
	
	public void testAddDatabaseReturnFalse() {
		assertFalse(DatabaseListManager.addDatabase(null));
		assertFalse(DatabaseListManager.addDatabase(dbNameEmpty));
	}
	
	public void testAddDatabaseReturnTrue() {
		assertTrue(DatabaseListManager.addDatabase(db));
	}
	
	public void testAddDatabaseMakeSizeNotZero() {
		assertTrue(!DatabaseListManager.getDatabaseList().getDatabases().isEmpty());
	}
	
	public void testExistsDatabaseReturnFalse() {
		assertFalse(DatabaseListManager.existsDatabase(notExistsDb));
	}
	
	public void testExistsDatabaseReturnTrue() {
		assertTrue(DatabaseListManager.existsDatabase(existsDb));
	}
	
	/*getNamesDatabases()*/
	public void testNamesDatabasesReturnSameSize() {
		assertEquals(DatabaseListManager.getNamesDatabases().size(), 
				DatabaseListManager.getDatabaseList().getDatabases().size());
	}
}

package org.binx.utils.database.memdb.manager;

import org.binx.utils.database.memdb.generator.*;
import org.binx.utils.database.memdb.model.*;

import junit.framework.TestCase;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class TableManagerUnitTest extends TestCase {

	// databases
	private String simpledb;
	private String defaultdb;
	private String notexistdb;
	//schemas
	private String simpleSchema;
	private String notexistSchema;
	//tables
	private String simpleTab;
	private String notexistTab;
	//columns
	private String simpleCol;
	private String notexistCol;
	private Column simpleColumn;
	//lines
	private Line simpleLine;
	
	@Override
	protected void setUp() throws Exception {
		simpledb = "simpledb";
		defaultdb = "defaultdb";
		notexistdb = "notexistdb";
		
		simpleSchema = "simpleSchema";
		notexistSchema = "notexistSchema";
		
		simpleTab = "simpleTab";
		notexistTab = "notexistTab";
		
		simpleCol = "simpleCol";
		notexistCol = "notexistCol";
		simpleColumn = ColumnGenerator.getColumn(simpleCol, String.class);
		
		simpleLine = LineGenerator.getLine();
	}
	
	public void testTableManager() {
		DatabaseListManager.getDatabaseList();
		DatabaseManager.createNewDatabase(simpledb);
		DatabaseManager.createNewDatabase(defaultdb);
		SchemaManager.createNewSchema(simpledb, simpleSchema);
		
		createNewTableWithDefaultDbScTabReturnNull();
		createNewTableWithDefaultDbDefaultScTabReturnNull();
		deleteWithDefaultDbDefaultScTabReturnNull();
		existsWithDefaultDbDefaultScTabReturnFalse();
		
		DatabaseManager.setToDefault(defaultdb);
		SchemaManager.createNewSchema(simpleSchema);

		createNewTableWithDbScTabReturnNull();
		createNewTableWithDbDefaultScTabReturnNull();
		getTableWithDbScTabReturnNull();
		getTableWithDbDefaultScTabReturnNull();
		getTableWithDefaultDbScTabReturnNull();
		getTableWithDefaultDbDefaultScTabReturnNull();

		createNewTableWithDbScTabReturnTrue();
		createNewTableWithDbScTabReturnFalse();
		createNewTableWithDbDefaultScTabReturnTrue();
		createNewTableWithDbDefaultScTabReturnFalse();
		createNewTableWithDefaultDbScTabReturnTrue();
		createNewTableWithDefaultDbScTabReturnFalse();
		createNewTableWithDefaultDbDefaultScTabReturnTrue();
		createNewTableWithDefaultDbDefaultScTabReturnFalse();
		getTableWithDbScTabReturnNotNull();
		getTableWithDbDefaultScTabReturnNotNull();
		getTableWithDefaultDbScTabReturnNotNull();
		getTableWithDefaultDbDefaultScTabReturnNotNull();
		existsWithDbScTabReturnFalse();
		existsWithDbScTabReturnTrue();
		existsWithDbDefaultScTabReturnFalse();
		existsWithDbDefaultScTabReturnTrue();
		existsWithDefaultDbScTabReturnFalse();
		existsWithDefaultDbScTabReturnTrue();
		existsWithDefaultDbDefaultScTabReturnTrue();
		addLineWithDbScTabReturnNull();
		addLineWithDbDefaultScTabReturnNull();
		addLineWithDefaultDbtScTabReturnNull();
		addLineWithDefaultDbDefaultScTabReturnNull();
		addColumnWithDbScTabReturnNull();
		addColumnWithDbScTabReturnTrue();
		addColumnWithDbScTabReturnFalse();
		addColumnWithDbDefaultScTabReturnNull();
		addColumnWithDbDefaultScTabReturnTrue();
		addColumnWithDbDefaultScTabReturnFalse();
		addColumnWithDefaultDbScTabReturnNull();
		addColumnWithDefaultDbScTabReturnTrue();
		addColumnWithDefaultDbScTabReturnFalse();
		addColumnWithDefaultDbDefaultScTabReturnNull();
		addColumnWithDefaultDbDefaultScTabReturnTrue();
		addColumnWithDefaultDbDefaultScTabReturnFalse();
		getColumnWithDbScTabReturnNull();
		getColumnWithDbScTabReturnNotNull();
		getColumnWithDbDefaultScTabReturnNull();
		getColumnWithDbDefaultScTabReturnNotNull();
		getColumnWithDefaultDbScTabReturnNull();
		getColumnWithDefaultDbScTabReturnNotNull();
		getColumnWithDefaultDbDefaultScTabReturnNull();
		getColumnWithDefaultDbDefaultScTabReturnNotNull();
		getColumnWithOrderWithDbScTabReturnNull();
		getColumnWithOrderWithDbScTabReturnNotNull();
		getColumnWithOrderWithDbDefaultScTabReturnNull();
		getColumnWithOrderWithDbDefaultScTabReturnNotNull();
		getColumnWithOrderWithDefaultDbScTabReturnNull();
		getColumnWithOrderWithDefaultDbScTabReturnNotNull();
		getColumnWithOrderWithDefaultDbDefaultScTabReturnNull();
		getColumnWithOrderWithDefaultDbDefaultScTabReturnNotNull();
		getAllColumnsWithDbScTabReturnNull();
		getAllColumnsWithDbScTabReturnNotNull();
		getAllColumnsWithDbDefaultScTabReturnNull();
		getAllColumnsWithDbDefaultScTabReturnNotNull();
		getAllColumnsWithDefaultDbScTabReturnNull();
		getAllColumnsWithDefaultDbScTabReturnNotNull();
		getAllColumnsWithDefaultDbDefaultScTabReturnNull();
		getAllColumnsWithDefaultDbDefaultScTabReturnNotNull();
		existsColumnWithDbScTabReturnFalse();
		existsColumnWithDbScTabReturnTrue();
		existsColumnWithDbDefaultScTabReturnFalse();
		existsColumnWithDbDefaultScTabReturnTrue();
		existsColumnWithDefaultDbScTabReturnFalse();
		existsColumnWithDefaultDbScTabReturnTrue();
		existsColumnWithDefaultDbDefaultScTabReturnFalse();
		existsColumnWithDefaultDbDefaultScTabReturnTrue();
		getAllNamesColumnsWithDbScTabReturnNull();
		getAllNamesColumnsWithDbScTabReturnNotNull();
		getAllNamesColumnsWithDbDefaultScTabReturnNull();
		getAllNamesColumnsWithDbDefaultScTabReturnNotNull();
		getAllNamesColumnsWithDefaultDbScTabReturnNull();
		getAllNamesColumnsWithDefaultDbScTabReturnNotNull();
		getAllNamesColumnsWithDefaultDbDefaultScTabReturnNull();
		getAllNamesColumnsWithDefaultDbDefaultScTabReturnNotNull();
		countColumnsWithDbScTabReturnMinus1();
		countColumnsWithDbScTabReturnGreaterThanO();
		countColumnsWithDbDefaultScTabReturnMinus1();
		countColumnsWithDbDefaultScTabReturnGreaterThanO();
		countColumnsWithDefaultDbScTabReturnMinus1();
		countColumnsWithDefaultDbScTabReturnGreaterThanO();
		countColumnsWithDefaultDbDefaultScTabReturnMinus1();
		countColumnsWithDefaultDbDefaultScTabReturnGreaterThanO();
		countLinesWithDbScTabReturnMinus1();
		countLinesWithDbScTabReturnNotNull();
		countLinesWithDbDefaultScTabReturnMinus1();
		countLinesWithDbDefaultScTabReturnNotNull();
		countLinesWithDefaultDbScTabReturnMinus1();
		countLinesWithDefaultDbScTabReturnNotNull();
		countLinesWithDefaultDbDefaultScTabReturnMinus1();
		countLinesWithDefaultDbDefaultScTabReturnNotNull();
		addLineWithDbScTabReturnTrue();
		addLineWithDbDefaultScTabReturnTrue();
		addLineWithDefaultDbScTabReturnTrue();
		addLineWithDefaultDbDefaultScTabReturnTrue();
		getLineWithDbScTabReturnNull();
		getLineWithDbScTabReturnNotNull();
		getLineWithDbDefaultScTabReturnNull();
		getLineWithDbDefaultScTabReturnNotNull();
		getLineWithDefaultDbScTabReturnNull();
		getLineWithDefaultDbScTabReturnNotNull();
		getLineWithDefaultDbDefaultScTabReturnNull();
		getLineWithDefaultDbDefaultScTabReturnNotNull();
		getAllLinesWithDbScTabReturnNull();
		getAllLinesWithDbScTabReturnNotNull();
		getAllLinesWithDbDefaultScTabReturnNull();
		getAllLinesWithDbDefaultScTabReturnNotNull();
		getAllLinesWithDefaultDbScTabReturnNull();
		getAllLinesWithDefaultDbScTabReturnNotNull();
		getAllLinesWithDefaultDbDefaultScTabReturnNull();
		getAllLinesWithDefaultDbDefaultScTabReturnNotNull();
		
		deleteLineWithDefaultDbDefaultScTabReturnNull();
		deleteLineWithDefaultDbDefaultScTabReturnNotNull();
		deleteLineWithDefaultDbScTabReturnNull();
		deleteLineWithDefaultDbScTabReturnNotNull();
		deleteLineWithDbDefaultScTabReturnNull();
		deleteLineWithDbDefaultScTabReturnNotNull();
		deleteLineWithDbScTabReturnNull();
		deleteLineWithDbScTabReturnNotNull();
		deleteColumnWithDbScTabReturnNull();
		deleteColumnWithDbScTabReturnFalse();
		deleteColumnWithDbScTabReturnTrue();
		deleteColumnWithDbDefaultScTabReturnNull();
		deleteColumnWithDbDefaultScTabReturnFalse();
		deleteColumnWithDbDefaultScTabReturnTrue();
		deleteColumnWithDefaultDbScTabReturnNull();
		deleteColumnWithDefaultDbScTabReturnFalse();
		deleteColumnWithDefaultDbScTabReturnTrue();
		deleteColumnWithDefaultDbDefaultScTabReturnNull();
		deleteColumnWithDefaultDbDefaultScTabReturnFalse();
		deleteColumnWithDefaultDbDefaultScTabReturnTrue();
		deleteWithDbScTabReturnNull();
		deleteWithDbScTabReturnFalse();
		deleteWithDbScTabReturnTrue();
		deleteWithDbDefaultScTabReturnNull();
		deleteWithDbDefaultScTabReturnFalse();
		deleteWithDbDefaultScTabReturnTrue();
		deleteWithDefaultDbScTabReturnNull();
		deleteWithDefaultDbScTabReturnFalse();
		deleteWithDefaultDbScTabReturnTrue();
		deleteWithDefaultDbDefaultScTabReturnFalse();
		deleteWithDefaultDbDefaultScTabReturnTrue();
	}
	
	public void createNewTableWithDbScTabReturnNull() {
		assertNull(TableManager.createNewTable(notexistdb, simpleSchema, simpleTab));
		assertNull(TableManager.createNewTable(simpledb, notexistSchema, simpleTab));
		assertNull(TableManager.createNewTable(notexistdb, notexistSchema, simpleTab));
	}
	
	public void createNewTableWithDbScTabReturnFalse() {
		assertFalse(TableManager.createNewTable(simpledb, simpleSchema, simpleTab));
	}
	
	public void createNewTableWithDbScTabReturnTrue() {
		assertTrue(TableManager.createNewTable(simpledb, simpleSchema, simpleTab));
	}
	
	public void createNewTableWithDbDefaultScTabReturnNull() {
		assertNull(TableManager.createNewTable(notexistdb, simpleTab));
	}
	
	public void createNewTableWithDbDefaultScTabReturnFalse() {
		assertFalse(TableManager.createNewTable(simpledb, simpleTab));
	}
	
	public void createNewTableWithDbDefaultScTabReturnTrue() {
		assertTrue(TableManager.createNewTable(simpledb, simpleTab));
	}
	
	public void createNewTableWithDefaultDbScTabReturnNull() {
		assertNull(TableManager.createNewTableDefaultDB(notexistSchema, simpleTab));
		assertNull(TableManager.createNewTableDefaultDB(simpleSchema, simpleTab));
	}
	
	public void createNewTableWithDefaultDbScTabReturnFalse() {
		assertFalse(TableManager.createNewTableDefaultDB(simpleSchema, simpleTab));
	}
	
	public void createNewTableWithDefaultDbScTabReturnTrue() {
		assertTrue(TableManager.createNewTableDefaultDB(simpleSchema, simpleTab));
	}
	
	public void createNewTableWithDefaultDbDefaultScTabReturnNull() {
		assertNull(TableManager.createNewTable(simpleTab));
	}
	
	public void createNewTableWithDefaultDbDefaultScTabReturnFalse() {
		assertFalse(TableManager.createNewTable(simpleTab));
	}
	
	public void createNewTableWithDefaultDbDefaultScTabReturnTrue() {
		assertTrue(TableManager.createNewTable(simpleTab));
	}
	
	public void getTableWithDbScTabReturnNull() {
		assertNull(TableManager.getTable(notexistdb, simpleSchema, simpleTab));
		assertNull(TableManager.getTable(simpledb, notexistSchema, simpleTab));
		assertNull(TableManager.getTable(simpledb, simpleSchema, notexistTab));
	}
	
	public void getTableWithDbScTabReturnNotNull() {
		assertNotNull(TableManager.getTable(simpledb, simpleSchema, simpleTab));
	}
	
	public void getTableWithDbDefaultScTabReturnNull() {
		assertNull(TableManager.getTable(notexistdb, simpleTab));
		assertNull(TableManager.getTable(simpledb, notexistTab));
	}
	
	public void getTableWithDbDefaultScTabReturnNotNull() {
		assertNotNull(TableManager.getTable(simpledb, simpleTab));
	}
	
	public void getTableWithDefaultDbScTabReturnNull() {
		assertNull(TableManager.getTableDefaultDB(notexistSchema, simpleTab));
		assertNull(TableManager.getTableDefaultDB(simpleSchema, notexistTab));
	}
	
	public void getTableWithDefaultDbScTabReturnNotNull() {
		assertNotNull(TableManager.getTableDefaultDB(simpleSchema, simpleTab));
	}
	
	public void getTableWithDefaultDbDefaultScTabReturnNull() {
		assertNull(TableManager.getTable(notexistTab));
	}
	
	public void getTableWithDefaultDbDefaultScTabReturnNotNull() {
		assertNotNull(TableManager.getTable(simpleTab));
	}
	
	public void deleteWithDbScTabReturnNull() {
		assertNull(TableManager.delete(notexistdb, simpleSchema, simpleTab));
		assertNull(TableManager.delete(simpledb, notexistSchema, simpleTab));
	}
	
	public void deleteWithDbScTabReturnFalse() {
		assertFalse(TableManager.delete(simpledb, simpleSchema, notexistTab));
	}
	
	public void deleteWithDbScTabReturnTrue() {
		assertTrue(TableManager.delete(simpledb, simpleSchema, simpleTab));
	}
	
	public void deleteWithDbDefaultScTabReturnNull() {
		assertNull(TableManager.delete(notexistdb, simpleTab));
	}
	
	public void deleteWithDbDefaultScTabReturnFalse() {
		assertFalse(TableManager.delete(simpledb, notexistTab));
	}
	
	public void deleteWithDbDefaultScTabReturnTrue() {
		assertTrue(TableManager.delete(simpledb, simpleTab));
	}
	
	public void deleteWithDefaultDbScTabReturnNull() {
		assertNull(TableManager.deleteDefaultDB(notexistSchema, simpleTab));
	}
	
	public void deleteWithDefaultDbScTabReturnFalse() {
		assertFalse(TableManager.deleteDefaultDB(simpleSchema, notexistTab));
	}
	
	public void deleteWithDefaultDbScTabReturnTrue() {
		assertTrue(TableManager.deleteDefaultDB(simpleSchema, simpleTab));
	}
	
	public void deleteWithDefaultDbDefaultScTabReturnNull() {
		assertNull(TableManager.delete(simpleTab));
	}
	
	public void deleteWithDefaultDbDefaultScTabReturnFalse() {
		assertFalse(TableManager.delete(notexistTab));
	}
	
	public void deleteWithDefaultDbDefaultScTabReturnTrue() {
		assertTrue(TableManager.delete(simpleTab));
	}
	
	public void existsWithDbScTabReturnFalse() {
		assertFalse(TableManager.exists(notexistdb, simpleSchema, simpleTab));
		assertFalse(TableManager.exists(simpledb, notexistSchema, simpleTab));
		assertFalse(TableManager.exists(simpledb, simpleSchema, notexistTab));
	}
	
	public void existsWithDbScTabReturnTrue() {
		assertTrue(TableManager.exists(simpledb, simpleSchema, simpleTab));
	}
	
	public void existsWithDbDefaultScTabReturnFalse() {
		assertFalse(TableManager.exists(notexistdb, simpleTab));
		assertFalse(TableManager.exists(simpledb, notexistTab));
	}
	
	public void existsWithDbDefaultScTabReturnTrue() {
		assertTrue(TableManager.exists(simpledb, simpleTab));
	}
	
	public void existsWithDefaultDbScTabReturnFalse() {
		assertFalse(TableManager.existsDefaultDB(notexistSchema, simpleTab));
		assertFalse(TableManager.existsDefaultDB(simpleSchema, notexistTab));
	}
	
	public void existsWithDefaultDbScTabReturnTrue() {
		assertTrue(TableManager.existsDefaultDB(simpleSchema, simpleTab));
	}
	
	public void existsWithDefaultDbDefaultScTabReturnFalse() {
		assertFalse(TableManager.exists(notexistTab));
		assertFalse(TableManager.exists(simpleTab));
	}
	
	public void existsWithDefaultDbDefaultScTabReturnTrue() {
		assertTrue(TableManager.exists(simpleTab));
	}
	
	public void addColumnWithDbScTabReturnNull() {
		assertNull(TableManager.addColumn(notexistdb, simpleSchema, simpleTab, simpleColumn));
		assertNull(TableManager.addColumn(simpledb, notexistSchema, simpleTab, simpleColumn));
		assertNull(TableManager.addColumn(simpledb, simpleSchema, notexistTab, simpleColumn));
	}
	
	public void addColumnWithDbScTabReturnFalse() {
		assertFalse(TableManager.addColumn(simpledb, simpleSchema, simpleTab, simpleColumn));
	}
	
	public void addColumnWithDbScTabReturnTrue() {
		assertTrue(TableManager.addColumn(simpledb, simpleSchema, simpleTab, simpleColumn));
	}
	
	public void addColumnWithDbDefaultScTabReturnNull() {
		assertNull(TableManager.addColumn(notexistdb, simpleTab, simpleColumn));
		assertNull(TableManager.addColumn(simpledb, notexistTab, simpleColumn));
	}
	
	public void addColumnWithDbDefaultScTabReturnFalse() {
		assertFalse(TableManager.addColumn(simpledb, simpleTab, simpleColumn));
	}
	
	public void addColumnWithDbDefaultScTabReturnTrue() {
		assertTrue(TableManager.addColumn(simpledb, simpleTab, simpleColumn));
	}
	
	public void addColumnWithDefaultDbScTabReturnNull(){
		assertNull(TableManager.addColumnDefaultDB(notexistSchema, simpleTab, simpleColumn));
		assertNull(TableManager.addColumnDefaultDB(simpleSchema, notexistTab, simpleColumn));
	}
	
	public void addColumnWithDefaultDbScTabReturnFalse() {
		assertFalse(TableManager.addColumnDefaultDB(simpleSchema, simpleTab, simpleColumn));
	}
	
	public void addColumnWithDefaultDbScTabReturnTrue() {
		assertTrue(TableManager.addColumnDefaultDB(simpleSchema, simpleTab, simpleColumn));
	}
	
	public void addColumnWithDefaultDbDefaultScTabReturnNull(){
		assertNull(TableManager.addColumn(notexistTab, simpleColumn));
	}
	
	public void addColumnWithDefaultDbDefaultScTabReturnFalse() {
		assertFalse(TableManager.addColumn(simpleTab, simpleColumn));
	}
	
	public void addColumnWithDefaultDbDefaultScTabReturnTrue() {
		assertTrue(TableManager.addColumn(simpleTab, simpleColumn));
	}
	
	public void getColumnWithDbScTabReturnNull() {
		assertNull(TableManager.getColumn(notexistdb, simpleSchema, simpleTab, simpleCol));
		assertNull(TableManager.getColumn(simpledb, notexistSchema, simpleTab, simpleCol));
		assertNull(TableManager.getColumn(simpledb, simpleSchema, notexistTab, simpleCol));
	}
	
	public void getColumnWithDbScTabReturnNotNull() {
		assertNotNull(TableManager.getColumn(simpledb, simpleSchema, simpleTab, simpleCol));
	}
	
	public void getColumnWithDbDefaultScTabReturnNull() {
		assertNull(TableManager.getColumn(notexistdb, simpleTab, simpleCol));
		assertNull(TableManager.getColumn(simpledb, notexistTab, simpleCol));
	}
	
	public void getColumnWithDbDefaultScTabReturnNotNull() {
		assertNotNull(TableManager.getColumn(simpledb, simpleTab, simpleCol));
	}
	
	public void getColumnWithDefaultDbScTabReturnNull() {
		assertNull(TableManager.getColumnDefaultDB(notexistSchema, simpleTab, simpleCol));
		assertNull(TableManager.getColumnDefaultDB(simpleSchema, notexistTab, simpleCol));
	}
	
	public void getColumnWithDefaultDbScTabReturnNotNull() {
		assertNotNull(TableManager.getColumnDefaultDB(simpleSchema, simpleTab, simpleCol));
	}
	
	public void getColumnWithDefaultDbDefaultScTabReturnNull() {
		assertNull(TableManager.getColumn(notexistTab, simpleCol));
	}
	
	public void getColumnWithDefaultDbDefaultScTabReturnNotNull() {
		assertNotNull(TableManager.getColumn(simpleTab, simpleCol));
	}
	
	public void getColumnWithOrderWithDbScTabReturnNull() {
		assertNull(TableManager.getColumn(notexistdb, simpleSchema, simpleTab, 0));
		assertNull(TableManager.getColumn(simpledb, notexistSchema, simpleTab, 0));
		assertNull(TableManager.getColumn(simpledb, simpleSchema, notexistTab, 0));
		assertNull(TableManager.getColumn(simpledb, simpleSchema, simpleTab, -1));
		assertNull(TableManager.getColumn(simpledb, simpleSchema, simpleTab, 100000));
	}
	
	public void getColumnWithOrderWithDbScTabReturnNotNull() {
		assertNotNull(TableManager.getColumn(simpledb, simpleSchema, simpleTab, 0));
	}
	
	public void getColumnWithOrderWithDbDefaultScTabReturnNull() {
		assertNull(TableManager.getColumn(notexistdb, simpleTab, 0));
		assertNull(TableManager.getColumn(simpledb, notexistTab, 0));
		assertNull(TableManager.getColumn(simpledb, simpleTab, -1));
		assertNull(TableManager.getColumn(simpledb, simpleTab, 100000));
	}
	
	public void getColumnWithOrderWithDbDefaultScTabReturnNotNull() {
		assertNotNull(TableManager.getColumn(simpledb, simpleTab, 0));
	}
	
	public void getColumnWithOrderWithDefaultDbScTabReturnNull() {
		assertNull(TableManager.getColumnDefaultDB(notexistSchema, simpleTab, 0));
		assertNull(TableManager.getColumnDefaultDB(simpleSchema, notexistTab, 0));
		assertNull(TableManager.getColumnDefaultDB(simpleSchema, simpleTab, -1));
		assertNull(TableManager.getColumnDefaultDB(simpleSchema, simpleTab, 100000));
	}
	
	public void getColumnWithOrderWithDefaultDbScTabReturnNotNull() {
		assertNotNull(TableManager.getColumnDefaultDB(simpleSchema, simpleTab, 0));
	}
	
	public void getColumnWithOrderWithDefaultDbDefaultScTabReturnNull() {
		assertNull(TableManager.getColumn(notexistTab, 0));
		assertNull(TableManager.getColumn(simpleTab, -1));
		assertNull(TableManager.getColumn(simpleTab, 100000));
	}
	
	public void getColumnWithOrderWithDefaultDbDefaultScTabReturnNotNull() {
		assertNotNull(TableManager.getColumn(simpleTab, 0));
	}
	
	public void getAllColumnsWithDbScTabReturnNull() {
		assertNull(TableManager.getAllColumns(notexistdb, simpleSchema, simpleTab));
		assertNull(TableManager.getAllColumns(simpledb, notexistSchema, simpleTab));
		assertNull(TableManager.getAllColumns(simpledb, simpleSchema, notexistTab));
	}
	
	public void getAllColumnsWithDbScTabReturnNotNull() {
		assertNotNull(TableManager.getAllColumns(simpledb, simpleSchema, simpleTab));
	}
	
	public void getAllColumnsWithDbDefaultScTabReturnNull() {
		assertNull(TableManager.getAllColumns(notexistdb, simpleTab));
		assertNull(TableManager.getAllColumns(simpledb, notexistTab));
	}
	
	public void getAllColumnsWithDbDefaultScTabReturnNotNull() {
		assertNotNull(TableManager.getAllColumns(simpledb, simpleTab));
	}
	
	public void getAllColumnsWithDefaultDbScTabReturnNull() {
		assertNull(TableManager.getAllColumnsDefaultDB(notexistSchema, simpleTab));
		assertNull(TableManager.getAllColumnsDefaultDB(simpleSchema, notexistTab));
	}
	
	public void getAllColumnsWithDefaultDbScTabReturnNotNull() {
		assertNotNull(TableManager.getAllColumnsDefaultDB(simpleSchema, simpleTab));
	}
	
	public void getAllColumnsWithDefaultDbDefaultScTabReturnNull() {
		assertNull(TableManager.getAllColumns(notexistTab));
	}
	
	public void getAllColumnsWithDefaultDbDefaultScTabReturnNotNull() {
		assertNotNull(TableManager.getAllColumns(simpleTab));
	}
	
	public void deleteColumnWithDbScTabReturnNull() {
		assertNull(TableManager.deleteColumn(notexistdb, simpleSchema, simpleTab, simpleCol));
		assertNull(TableManager.deleteColumn(simpledb, notexistSchema, simpleTab, simpleCol));
		assertNull(TableManager.deleteColumn(simpledb, simpleSchema, notexistTab, simpleCol));
	}
	
	public void deleteColumnWithDbScTabReturnFalse() {
		assertFalse(TableManager.deleteColumn(simpledb, simpleSchema, simpleTab, notexistCol));
	}
	
	public void deleteColumnWithDbScTabReturnTrue() {
		assertTrue(TableManager.deleteColumn(simpledb, simpleSchema, simpleTab, simpleCol));
	}
	
	public void deleteColumnWithDbDefaultScTabReturnNull() {
		assertNull(TableManager.deleteColumn(notexistdb, simpleTab, simpleCol));
		assertNull(TableManager.deleteColumn(simpledb, notexistTab, simpleCol));
	}
	
	public void deleteColumnWithDbDefaultScTabReturnFalse() {
		assertFalse(TableManager.deleteColumn(simpledb, simpleTab, notexistCol));
	}
	
	public void deleteColumnWithDbDefaultScTabReturnTrue() {
		assertTrue(TableManager.deleteColumn(simpledb, simpleTab, simpleCol));
	}
	
	public void deleteColumnWithDefaultDbScTabReturnNull() {
		assertNull(TableManager.deleteColumnDefaultDB(notexistSchema, simpleTab, simpleCol));
		assertNull(TableManager.deleteColumnDefaultDB(simpleSchema, notexistTab, simpleCol));
	}
	
	public void deleteColumnWithDefaultDbScTabReturnFalse() {
		assertFalse(TableManager.deleteColumnDefaultDB(simpleSchema, simpleTab, notexistCol));
	}
	
	public void deleteColumnWithDefaultDbScTabReturnTrue() {
		assertTrue(TableManager.deleteColumnDefaultDB(simpleSchema, simpleTab, simpleCol));
	}
	
	public void deleteColumnWithDefaultDbDefaultScTabReturnNull() {
		assertNull(TableManager.deleteColumn(notexistTab, simpleCol));
	}
	
	public void deleteColumnWithDefaultDbDefaultScTabReturnFalse() {
		assertFalse(TableManager.deleteColumn(simpleTab, notexistCol));
	}
	
	public void deleteColumnWithDefaultDbDefaultScTabReturnTrue() {
		assertTrue(TableManager.deleteColumn(simpleTab, simpleCol));
	}
	
	public void existsColumnWithDbScTabReturnFalse() {
		assertFalse(TableManager.existsColumn(notexistdb, simpleSchema, simpleTab, simpleCol));
		assertFalse(TableManager.existsColumn(simpledb, notexistSchema, simpleTab, simpleCol));
		assertFalse(TableManager.existsColumn(simpledb, simpleSchema, notexistTab, simpleCol));
		assertFalse(TableManager.existsColumn(simpledb, simpleSchema, simpleTab, notexistCol));
	}
	
	public void existsColumnWithDbScTabReturnTrue() {
		assertTrue(TableManager.existsColumn(simpledb, simpleSchema, simpleTab, simpleCol));
	}
	
	public void existsColumnWithDbDefaultScTabReturnFalse() {
		assertFalse(TableManager.existsColumn(notexistdb, simpleTab, simpleCol));
		assertFalse(TableManager.existsColumn(simpledb, notexistTab, simpleCol));
		assertFalse(TableManager.existsColumn(simpledb, simpleTab, notexistCol));
	}
	
	public void existsColumnWithDbDefaultScTabReturnTrue() {
		assertTrue(TableManager.existsColumn(simpledb, simpleTab, simpleCol));
	}
	
	public void existsColumnWithDefaultDbScTabReturnFalse() {
		assertFalse(TableManager.existsColumnDefaultDB(notexistSchema, simpleTab, simpleCol));
		assertFalse(TableManager.existsColumnDefaultDB(simpleSchema, notexistTab, simpleCol));
		assertFalse(TableManager.existsColumnDefaultDB(simpleSchema, simpleTab, notexistCol));
	}
	
	public void existsColumnWithDefaultDbScTabReturnTrue() {
		assertTrue(TableManager.existsColumnDefaultDB(simpleSchema, simpleTab, simpleCol));
	}
	
	public void existsColumnWithDefaultDbDefaultScTabReturnFalse() {
		assertFalse(TableManager.existsColumn(notexistTab, simpleCol));
		assertFalse(TableManager.existsColumn(simpleTab, notexistCol));
	}
	
	public void existsColumnWithDefaultDbDefaultScTabReturnTrue() {
		assertTrue(TableManager.existsColumn(simpleTab, simpleCol));
	}
	
	public void countColumnsWithDbScTabReturnMinus1() {
		assertEquals(TableManager.countColumns(notexistdb, simpleSchema, simpleTab), new Integer(-1));
		assertEquals(TableManager.countColumns(simpledb, notexistSchema, simpleTab), new Integer(-1));
		assertEquals(TableManager.countColumns(simpledb, simpleSchema, notexistTab), new Integer(-1));
	}
	
	public void countColumnsWithDbScTabReturnGreaterThanO() {
		assertTrue(TableManager.countColumns(simpledb, simpleSchema, simpleTab) >= 0);
	}
	
	public void countColumnsWithDbDefaultScTabReturnMinus1() {
		assertEquals(TableManager.countColumns(notexistdb, simpleTab), new Integer(-1));
		assertEquals(TableManager.countColumns(simpledb, notexistTab), new Integer(-1));
	}
	
	public void countColumnsWithDbDefaultScTabReturnGreaterThanO() {
		assertTrue(TableManager.countColumns(simpledb, simpleTab) >= 0);
	}
	
	public void countColumnsWithDefaultDbScTabReturnMinus1() {
		assertEquals(TableManager.countColumnsDefaultDB(notexistSchema, simpleTab), new Integer(-1));
		assertEquals(TableManager.countColumnsDefaultDB(simpleSchema, notexistTab), new Integer(-1));
	}
	
	public void countColumnsWithDefaultDbScTabReturnGreaterThanO() {
		assertTrue(TableManager.countColumnsDefaultDB(simpleSchema, simpleTab) >= 0);
	}
	
	public void countColumnsWithDefaultDbDefaultScTabReturnMinus1() {
		assertEquals(TableManager.countColumns(notexistTab), new Integer(-1));
	}
	
	public void countColumnsWithDefaultDbDefaultScTabReturnGreaterThanO() {
		assertTrue(TableManager.countColumns(simpleTab) >= 0);
	}
	
	public void getAllNamesColumnsWithDbScTabReturnNull() {
		assertNull(TableManager.getAllNamesColumns(notexistdb, simpleSchema, simpleTab));
		assertNull(TableManager.getAllNamesColumns(simpledb, notexistSchema, simpleTab));
		assertNull(TableManager.getAllNamesColumns(simpledb, simpleSchema, notexistTab));
	}
	
	public void getAllNamesColumnsWithDbScTabReturnNotNull() {
		assertNotNull(TableManager.getAllNamesColumns(simpledb, simpleSchema, simpleTab));
	}
	
	public void getAllNamesColumnsWithDbDefaultScTabReturnNull() {
		assertNull(TableManager.getAllNamesColumns(notexistdb, simpleTab));
		assertNull(TableManager.getAllNamesColumns(simpledb, notexistTab));
	}
	
	public void getAllNamesColumnsWithDbDefaultScTabReturnNotNull() {
		assertNotNull(TableManager.getAllNamesColumns(simpledb, simpleTab));
	}
	
	public void getAllNamesColumnsWithDefaultDbScTabReturnNull() {
		assertNull(TableManager.getAllNamesColumnsDefaultDB(notexistSchema, simpleTab));
		assertNull(TableManager.getAllNamesColumnsDefaultDB(simpleSchema, notexistTab));
	}
	
	public void getAllNamesColumnsWithDefaultDbScTabReturnNotNull() {
		assertNotNull(TableManager.getAllNamesColumnsDefaultDB(simpleSchema, simpleTab));
	}
	
	public void getAllNamesColumnsWithDefaultDbDefaultScTabReturnNull() {
		assertNull(TableManager.getAllNamesColumns(notexistTab));
	}
	
	public void getAllNamesColumnsWithDefaultDbDefaultScTabReturnNotNull() {
		assertNotNull(TableManager.getAllNamesColumns(simpleTab));
	}
	
	public void addLineWithDbScTabReturnNull() {
		assertNull(TableManager.addLine(notexistdb, simpleSchema, simpleTab, simpleLine));
		assertNull(TableManager.addLine(simpledb, notexistSchema, simpleTab, simpleLine));
		assertNull(TableManager.addLine(simpledb, simpleSchema, notexistTab, simpleLine));
		assertNull(TableManager.addLine(simpledb, simpleSchema, simpleTab, simpleLine));
	}
	
	/*not needed False test*/
	public void addLineWithDbScTabReturnTrue() {
		assertTrue(TableManager.addLine(simpledb, simpleSchema, simpleTab, simpleLine));
	}
	
	public void addLineWithDbDefaultScTabReturnNull() {
		assertNull(TableManager.addLine(notexistdb, simpleTab, simpleLine));
		assertNull(TableManager.addLine(simpledb, notexistTab, simpleLine));
		assertNull(TableManager.addLine(simpledb, simpleTab, simpleLine));
	}
	
	/*not needed False test*/
	public void addLineWithDbDefaultScTabReturnTrue() {
		assertTrue(TableManager.addLine(simpledb, simpleTab, simpleLine));
	}
	
	public void addLineWithDefaultDbtScTabReturnNull() {
		assertNull(TableManager.addLineDefaultDB(notexistSchema, simpleTab, simpleLine));
		assertNull(TableManager.addLineDefaultDB(simpleSchema, notexistTab, simpleLine));
		assertNull(TableManager.addLineDefaultDB(simpleSchema, simpleTab, simpleLine));
	}
	
	/*not needed False test*/
	public void addLineWithDefaultDbScTabReturnTrue() {
		assertTrue(TableManager.addLineDefaultDB(simpleSchema, simpleTab, simpleLine));
	}
	
	public void addLineWithDefaultDbDefaultScTabReturnNull() {
		assertNull(TableManager.addLine(notexistTab, simpleLine));
		assertNull(TableManager.addLine(simpleTab, simpleLine));
	}
	
	/*not needed False test*/
	public void addLineWithDefaultDbDefaultScTabReturnTrue() {
		assertTrue(TableManager.addLine(simpleTab, simpleLine));
	}
	
	public void getLineWithDbScTabReturnNull() {
		assertNull(TableManager.getLine(notexistdb, simpleSchema, simpleTab, 0L));
		assertNull(TableManager.getLine(simpledb, notexistSchema, simpleTab, 0L));
		assertNull(TableManager.getLine(simpledb, simpleSchema, notexistTab, 0L));
		assertNull(TableManager.getLine(simpledb, simpleSchema, simpleTab, -1L));
		assertNull(TableManager.getLine(simpledb, simpleSchema, simpleTab, 100000L));
	}
	
	public void getLineWithDbScTabReturnNotNull() {
		assertNotNull(TableManager.getLine(simpledb, simpleSchema, simpleTab, 0L));
	}
	
	public void getLineWithDbDefaultScTabReturnNull() {
		assertNull(TableManager.getLine(notexistdb, simpleTab, 0L));
		assertNull(TableManager.getLine(simpledb, notexistTab, 0L));
		assertNull(TableManager.getLine(simpledb, simpleTab, -1L));
		assertNull(TableManager.getLine(simpledb, simpleTab, 100000L));
	}
	
	public void getLineWithDbDefaultScTabReturnNotNull() {
		assertNotNull(TableManager.getLine(simpledb, simpleTab, 0L));
	}
	
	public void getLineWithDefaultDbScTabReturnNull() {
		assertNull(TableManager.getLineDefaultDB(notexistSchema, simpleTab, 0L));
		assertNull(TableManager.getLineDefaultDB(simpleSchema, notexistTab, 0L));
		assertNull(TableManager.getLineDefaultDB(simpleSchema, simpleTab, -1L));
		assertNull(TableManager.getLineDefaultDB(simpleSchema, simpleTab, 100000L));
	}
	
	public void getLineWithDefaultDbScTabReturnNotNull() {
		assertNotNull(TableManager.getLineDefaultDB(simpleSchema, simpleTab, 0L));
	}
	
	public void getLineWithDefaultDbDefaultScTabReturnNull() {
		assertNull(TableManager.getLine(notexistTab, 0L));
		assertNull(TableManager.getLine(simpleTab, -1L));
		assertNull(TableManager.getLine(simpleTab, 100000L));
	}
	
	public void getLineWithDefaultDbDefaultScTabReturnNotNull() {
		assertNotNull(TableManager.getLine(simpleTab, 0L));
	}
	
	public void getAllLinesWithDbScTabReturnNull() {
		assertNull(TableManager.getAllLines(notexistdb, simpleSchema, simpleTab));
		assertNull(TableManager.getAllLines(simpledb, notexistSchema, simpleTab));
		assertNull(TableManager.getAllLines(simpledb, simpleSchema, notexistTab));
	}
	
	public void getAllLinesWithDbScTabReturnNotNull() {
		assertNotNull(TableManager.getAllLines(simpledb, simpleSchema, simpleTab));
	}
	
	public void getAllLinesWithDbDefaultScTabReturnNull() {
		assertNull(TableManager.getAllLines(notexistdb, simpleTab));
		assertNull(TableManager.getAllLines(simpledb, notexistTab));
	}
	
	public void getAllLinesWithDbDefaultScTabReturnNotNull() {
		assertNotNull(TableManager.getAllLines(simpledb, simpleTab));
	}
	
	public void getAllLinesWithDefaultDbScTabReturnNull() {
		assertNull(TableManager.getAllLinesDefaultDB(notexistSchema, simpleTab));
		assertNull(TableManager.getAllLinesDefaultDB(simpleSchema, notexistTab));
	}
	
	public void getAllLinesWithDefaultDbScTabReturnNotNull() {
		assertNotNull(TableManager.getAllLinesDefaultDB(simpleSchema, simpleTab));
	}
	
	public void getAllLinesWithDefaultDbDefaultScTabReturnNull() {
		assertNull(TableManager.getAllLines(notexistTab));
	}
	
	public void getAllLinesWithDefaultDbDefaultScTabReturnNotNull() {
		assertNotNull(TableManager.getAllLines(simpleTab));
	}
	
	public void deleteLineWithDbScTabReturnNull() {
		assertNull(TableManager.deleteLine(notexistdb, simpleSchema, simpleTab, 0L));
		assertNull(TableManager.deleteLine(simpledb, notexistSchema, simpleTab, 0L));
		assertNull(TableManager.deleteLine(simpledb, simpleSchema, notexistTab, 0L));
		assertNull(TableManager.deleteLine(simpledb, simpleSchema, simpleTab, -1L));
		assertNull(TableManager.deleteLine(simpledb, simpleSchema, simpleTab, 100000L));
	}
	
	public void deleteLineWithDbScTabReturnNotNull() {
		assertNotNull(TableManager.deleteLine(simpledb, simpleSchema, simpleTab, 0L));
	}
	
	public void deleteLineWithDbDefaultScTabReturnNull() {
		assertNull(TableManager.deleteLine(notexistdb, simpleTab, 0L));
		assertNull(TableManager.deleteLine(simpledb, notexistTab, 0L));
		assertNull(TableManager.deleteLine(simpledb, simpleTab, -1L));
		assertNull(TableManager.deleteLine(simpledb, simpleTab, 100000L));
	}
	
	public void deleteLineWithDbDefaultScTabReturnNotNull() {
		assertNotNull(TableManager.deleteLine(simpledb, simpleTab, 0L));
	}
	
	public void deleteLineWithDefaultDbScTabReturnNull() {
		assertNull(TableManager.deleteLineDefaultDB(notexistSchema, simpleTab, 0L));
		assertNull(TableManager.deleteLineDefaultDB(simpleSchema, notexistTab, 0L));
		assertNull(TableManager.deleteLineDefaultDB(simpleSchema, simpleTab, -1L));
		assertNull(TableManager.deleteLineDefaultDB(simpleSchema, simpleTab, 100000L));
	}
	
	public void deleteLineWithDefaultDbScTabReturnNotNull() {
		assertNotNull(TableManager.deleteLineDefaultDB(simpleSchema, simpleTab, 0L));
	}
	
	public void deleteLineWithDefaultDbDefaultScTabReturnNull() {
		assertNull(TableManager.deleteLine(notexistTab, 0L));
		assertNull(TableManager.deleteLine(simpleTab, -1L));
		assertNull(TableManager.deleteLine(simpleTab, 100000L));
	}
	
	public void deleteLineWithDefaultDbDefaultScTabReturnNotNull() {
		assertNotNull(TableManager.deleteLine(simpleTab, 0L));
	}
	
	public void countLinesWithDbScTabReturnMinus1() {
		assertEquals(TableManager.countLines(notexistdb, simpleSchema, simpleTab), new Long(-1));
		assertEquals(TableManager.countLines(simpledb, notexistSchema, simpleTab), new Long(-1));
		assertEquals(TableManager.countLines(simpledb, simpleSchema, notexistTab), new Long(-1));
	}
	
	public void countLinesWithDbScTabReturnNotNull() {
		assertNotNull(TableManager.countLines(simpledb, simpleSchema, simpleTab));
	}
	
	public void countLinesWithDbDefaultScTabReturnMinus1() {
		assertEquals(TableManager.countLines(notexistdb, simpleTab), new Long(-1));
		assertEquals(TableManager.countLines(simpledb, notexistTab), new Long(-1));
	}
	
	public void countLinesWithDbDefaultScTabReturnNotNull() {
		assertNotNull(TableManager.countLines(simpledb, simpleTab));
	}
	
	public void countLinesWithDefaultDbScTabReturnMinus1() {
		assertEquals(TableManager.countLinesDefaultDB(notexistSchema, simpleTab), new Long(-1));
		assertEquals(TableManager.countLinesDefaultDB(simpleSchema, notexistTab), new Long(-1));
	}
	
	public void countLinesWithDefaultDbScTabReturnNotNull() {
		assertNotNull(TableManager.countLinesDefaultDB(simpleSchema, simpleTab));
	}
	
	public void countLinesWithDefaultDbDefaultScTabReturnMinus1() {
		assertEquals(TableManager.countLines(notexistTab), new Long(-1));
	}
	
	public void countLinesWithDefaultDbDefaultScTabReturnNotNull() {
		assertNotNull(TableManager.countLines(simpleTab));
	}
}

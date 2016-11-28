package org.binx.utils.database.memdb;

import java.time.*;
import java.util.*;

import org.binx.utils.database.memdb.manager.*;
import org.binx.utils.database.memdb.model.*;

import junit.framework.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public class globalMemDBTest extends TestCase {

	/* 
	 * To illustrate & verify developed functionnalities for MemDB 0.1.0 we will use the following case :
	 * 
	 * The Case will concern an entity Person table with name, age & birthdate
	 * Name must be unique & not null
	 * 
	 * Modeling this case will give us a Table Person with Columns : [name : String], [age : Integer] & [birthdate : Date]  
	 * 1. Create a database wich will contains the table Person and wich will the default database
	 * 2. Create Table Person
	 * 3. Add Columns name, age & birthdate
	 * 4. Insert records :
	 *   4.1. Normal person (with all values)
	 *   4.2. Person with wrong type of age
	 *   4.3. Update Person name
	 *   4.4. Person with null age
	 *   4.5. Person with duplicated name
	 *   4.6. Person with null name
	 */
	
	// database
	private String databaseName;
	//table
	private String tableName;
	//column
	private String name;
	private Class<?> nameType;
	private String age;
	private Class<?> ageType;
	private String birthdate;
	private Class<?> birthdateType;
	
	@Override
	protected void setUp() {
		databaseName  = "MemDBTest";
		tableName     = "Person";
		name          = "name";
		nameType      = String.class;
		age           = "age";
		ageType       = Integer.class;
		birthdate     = "birthdate";
		birthdateType = Date.class;
	}
	
	public void testForGlobalMemDB_0_1_0() {
		
		//1. Create a database wich will contains the table Person (It will instantiate dynamically the list of databases)
		System.out.print("1. Creating a new database with name : ");
		DatabaseManager.createNewDatabase(databaseName);
		DatabaseManager.setToDefault(databaseName);
		System.out.println(DatabaseManager.getDefault().getName() + " [done successfully]");
		
		
		//2. Create Table Person (in default Schema)
		System.out.print("2. Creating Table : ");
		TableManager.createNewTable(tableName);
		System.out.println(TableManager.getTable(tableName).getName() + " [done successfully]");
		
		
		//3. Add Columns name, age & birthdate
		System.out.println("3. Add Columns name, age & birthdate");
		
		// 3.1. Create Column Person.name
		System.out.print("\t3.1. Creating Column ");
		ColumnManager.createNewColumn(tableName, name, nameType);
		Column column = ColumnManager.getColumn(tableName, name);
		System.out.println(column.getName() + " ["+ column.getType().getSimpleName() +"] in table Person with order : " + column.getOrder() + " [done successfully]");
		
		// 3.2. Create Column Person.age
		System.out.print("\t3.2. Creating Column ");
		ColumnManager.createNewColumn(tableName, age, ageType);
		column = ColumnManager.getColumn(tableName, age);
		System.out.println(column.getName() + " ["+ column.getType().getSimpleName() +"] in table Person with order : " + column.getOrder() + " [done successfully]");
		
		// 3.3. Create Column Person.birthdate
		System.out.print("\t3.3. Creating Column ");
		ColumnManager.createNewColumn(tableName, birthdate, birthdateType);
		column = ColumnManager.getColumn(tableName, birthdate);
		System.out.println(column.getName() + " ["+ column.getType().getSimpleName() +"] in table Person with order : " + column.getOrder() + " [done successfully]");
		
		
		//4. Insert records
		System.out.println("4. Insert records");
		// 4.1. First Person ("Yassine Diouri", 24, 15/11/1992)
		System.out.println("\t4.1. First Person ('Yassine Diouri', 24, 15/11/1992)");
		
		//  4.1.1. Create Line for the First Person
		System.out.print("\t\t4.1.1. Create new empty line to insert values with index : ");
		Line line = LineManager.createNewEmptyLine(tableName);
		System.out.println(line.getIndex() + " [done successfully]");
		
		//  4.1.2. Add name : "Yassine Diouri"
		System.out.print("\t\t4.1.2. insert name person = ");
		column = ColumnManager.getColumn(tableName, name);
		ColumnValueManager.createNewColumnValue(tableName, line.getIndex(), column.getOrder(), "Yassine Diouri");
		System.out.println(ColumnValueManager.getValue(tableName, line.getIndex(), column.getOrder()) + " [done successfully]");
		
		//  4.1.3. Add age : 24
		System.out.print("\t\t4.1.3. insert age person = ");
		column = ColumnManager.getColumn(tableName, age);
		ColumnValueManager.createNewColumnValue(tableName, line.getIndex(), column.getOrder(), 24);
		System.out.println(ColumnValueManager.getValue(tableName, line.getIndex(), column.getOrder()) + " [done successfully]");
		
		//  4.1.4. Add birthdate : 15/11/1992
		System.out.print("\t\t4.1.4. insert birthdate person = ");
		column = ColumnManager.getColumn(tableName, birthdate);
		ColumnValueManager.createNewColumnValue(tableName, line.getIndex(), column.getOrder(), Date.from(LocalDate.of(1992, 11, 15).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		System.out.println(ColumnValueManager.getValue(tableName, line.getIndex(), column.getOrder()) + " [done successfully]");
		
		// 4.2. Person with wrong type of age : Person ("xxxxxx", "yassine", xx/xx/xxxx)
		System.out.println("\t4.2. Person with wrong type of age : Person ('xxxxxx', 'yassine', xx/xx/xxxx)");
		
		//  4.2.1. Create Line for the Second Person
		System.out.print("\t\t4.2.1. Create new empty line to insert values with index : ");
		line = LineManager.createNewEmptyLine(tableName);
		System.out.println(line.getIndex() + " [done successfully]");
		
		//  4.2.2. Add age : "yassine"
		System.out.print("\t\t4.2.2. insert age person = ");
		column = ColumnManager.getColumn(tableName, age);
		ColumnValueManager.createNewColumnValue(tableName, line.getIndex(), column.getOrder(), "yassine");
		System.out.println(ColumnValueManager.getValue(tableName, line.getIndex(), column.getOrder()) + " [done successfully]");
		System.out.println("\t\t\t{The Value did not change and it was maintained to the init value : null}");
		
		// 4.3. Update Person name : "Yassine Diouri" => "Yassine DIOURI"
		System.out.println("\t4.3. Update Person name : 'Yassine Diouri' => 'Yassine DIOURI'");
		
		//  4.3.1. Create Line for the Second Person
		System.out.print("\t\t4.3.1. get Line which contains the old value [using index : 0] : ");
		line = LineManager.getLine(tableName, 0L);
		column = ColumnManager.getColumn(tableName, name);
		System.out.println(ColumnValueManager.getValue(tableName, line.getIndex(), column.getOrder()) + " [done successfully]");
		
		//  4.3.2. Add age : "yassine"
		System.out.print("\t\t4.3.2. update to new Person name = ");
		column = ColumnManager.getColumn(tableName, name);
		ColumnValueManager.updateValue(tableName, line.getIndex(), column.getOrder(), "Yassine DIOURI");
		System.out.println(ColumnValueManager.getValue(tableName, line.getIndex(), column.getOrder()) + " [done successfully]");
	}
}

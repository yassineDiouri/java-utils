package org.binx.utils.database.memdb;

import java.util.List;

import org.binx.utils.database.memdb.core.manager.ColumnManager;
import org.binx.utils.database.memdb.core.manager.ColumnValueManager;
import org.binx.utils.database.memdb.core.manager.DatabaseManager;
import org.binx.utils.database.memdb.core.manager.LineManager;
import org.binx.utils.database.memdb.core.manager.TableManager;
import org.binx.utils.database.memdb.core.model.ConstraintType;
import org.binx.utils.database.memdb.core.model.Line;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class MemdbUtils {
	
    public static Boolean createDatabase(String databaseName) {
        DatabaseManager.createNewDatabase(databaseName);
        DatabaseManager.setToDefault(databaseName);
        return true;
    }

    public static Boolean changeDatabase(String databaseName) {
        if(DatabaseManager.exists(databaseName)) {
            DatabaseManager.setToDefault(databaseName);
            return true;
        }
        return false;
    }

    public static Boolean createTable(String tableName) {
        return TableManager.createNewTable(tableName);
    }

    public static Boolean createColumn(String tableName, String columnName, Class<?> columnType, ConstraintType... constraintTypes) {
        return constraintTypes.length > 0 ? ColumnManager.createNewColumn(tableName, columnName, columnType, constraintTypes)
                : ColumnManager.createNewColumn(tableName, columnName, columnType);
    }

    public static Boolean insertInto(String tableName, Object... values) {
        if(TableManager.countColumns(tableName) == values.length) {
            Line line = LineManager.createNewEmptyLine(tableName);
            for(int i = 0; i < values.length; i++) {
                Boolean result = ColumnValueManager.createNewColumnValue(tableName, line.getIndex(), i, values[i]);
                if(!result) {
                    LineManager.delete(tableName, line.getIndex());
                    return null;
                }
            }
            return true;
        }
        return null;
    }

    public static Boolean insertInto(String tableName, List<String> columnNames, List<Object> columnsValues) {
        if(columnNames.size() == columnsValues.size()) {
            for(String columnName : columnNames) {
                if(!ColumnManager.exists(tableName, columnName))
                    return null;
            }
            Line line = LineManager.createNewEmptyLine(tableName);
            for(int i = 0; i < columnsValues.size(); i++) {
                Boolean result = ColumnValueManager.createNewColumnValue(tableName, line.getIndex(), 
                        ColumnManager.getColumn(tableName, columnNames.get(i)).getOrder(), columnsValues.get(i));
                if(!result) {
                    LineManager.delete(tableName, line.getIndex());
                    return null;
                }
            }
            return true;
        }
        return null;
    }
}
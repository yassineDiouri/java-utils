package org.binx.utils.database.memdb.generator;

import java.util.*;

import org.binx.utils.database.memdb.model.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class ColumnGenerator {
	
	public static Column getColumn(String name, Class<?> type) {
		return new Column(name, type);
	}
	
	public static Column getColumn(String name, Class<?> type, ConstraintType... types) {
		List<Constraint> constraints = new ArrayList<>(types.length);
		for(ConstraintType constraintType : types) {
			constraints.add(ConstraintGenerator.getConstraint(name + "_" + constraintType.name(), constraintType));
		}
		return new Column(name, type, constraints);
	}
}

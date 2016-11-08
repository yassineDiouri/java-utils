package org.binx.utils.database.memdb.generator;

import org.binx.utils.database.memdb.model.*;

/**
 * 
 * @author Yassine Diouri
 *
 */
public abstract class ConstraintGenerator {

	public static Constraint getConstraint(String name, ConstraintType type) {
		return new Constraint(name, type);
	}
}

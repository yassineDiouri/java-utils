package org.binx.utils.database.memdb.core.generator;

import org.binx.utils.database.memdb.core.model.Constraint;
import org.binx.utils.database.memdb.core.model.ConstraintType;

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
